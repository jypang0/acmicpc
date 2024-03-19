package exhaustiveSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 queueBFS
 * @사용자료구조 Queue(Linked List)
 * 
 * @배운점 BFS 활용법
 * @배운점 graph 표현에 새로운 아이디어 -> boolean visitied + boolean graph + int weight 이렇게 세개로 할 생각이였는데
 * 하나로 표현하는 방법을 깨달았다
 * 
 */
public class S1_2178_미로탐색_BFS {
	static int N,M;
	static int graph[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());

		graph = new int[N][M]; 
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = row.charAt(j) - '0' == 1 ? 0 : -1;
			}
		}
		graph[0][0]=1;
		
		System.out.println(BFS());
	}
	
	public static int BFS() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0));

		int[][] drdc = {{0,1},{1,0},{-1,0},{0,-1}};
		
		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			
			if(graph[curr.r][curr.c]==-1) {
				continue;
			}
			
			if(curr.r==N-1&&curr.c==M-1) {
				return graph[curr.r][curr.c];
			}
			
			for(int i=0;i<4;i++) {
				int newR = curr.r+drdc[i][0];
				int newC = curr.c+drdc[i][1];
				
				if(newR<0 || newC<0 || newR>=N || newC>=M || graph[newR][newC]!=0) 
					continue;
				
				queue.add(new Point(newR, newC));
				graph[newR][newC] = graph[curr.r][curr.c]+1;
			}
		}
		return -1;
	}

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

}