package impl;
import java.util.*;
import java.io.*;

/**
 * @사용알고리즘 BFS
 * @사용자료구조 3차원 배열
 *  
 * @배운점 오.. 이게.. 되네 ㅋㅋ
 * 
 * @try1
 *
 * @Date 4 Apr 2024
 */
class G4_16234_인구이동_BFS {
	
	static int N, L, R;
	static int[][] pop;
	static boolean[][][] border;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		
		// input
		N = nextInt();
		L = nextInt();
		R = nextInt();
		
		pop = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				pop[i][j] = nextInt();
			}
		}
		
		int answer = 0;
		while(openBorders()) {
			move();
			answer++;
		} 
		
		System.out.println(answer);
	}
	
	static boolean openBorders() {
		boolean flag = false;
		border = new boolean[N][N][4];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int d=0;d<4;d++) {
					if(i+dr[d]<0 || i+dr[d]==N || j+dc[d]<0 || j+dc[d]==N)
						continue;
					
					int diff = Math.abs(pop[i][j]-pop[i+dr[d]][j+dc[d]]);
					if(!(diff>=L && diff<=R)) {
						continue;
					}
					
					border[i][j][d] = true;
					flag = true;
				}
			}
		}
		
		return flag;
	}
	
	static boolean[][] visited;
	static void move() {
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j])
					continue;
					if(border[i][j][0] || border[i][j][1] || border[i][j][2] || border[i][j][3]) { // if border is open
						
						// BFS to find all adjacent
						Queue<int[]> q = new LinkedList<>();
						Stack<int[]> s = new Stack<>();
						int totalPop = 0;
						q.add(new int[] {i,j});
						visited[i][j] = true;
						
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							s.add(cur);
							totalPop+=pop[cur[0]][cur[1]];
							
							for(int d=0;d<4;d++) {
								if(cur[0]+dr[d]<0 || cur[0]+dr[d]==N || cur[1]+dc[d]<0 || cur[1]+dc[d]==N) 
									continue;
								
								if(visited[cur[0]+dr[d]][cur[1]+dc[d]])
									continue;
								
								if(border[cur[0]][cur[1]][d]) {
									q.add(new int[] {cur[0]+dr[d], cur[1]+dc[d]});
									visited[cur[0]+dr[d]][cur[1]+dc[d]]=true;
								}
							}
						}
						
						int avgPop = totalPop/s.size();
						while(!s.isEmpty()) {
							int[] cur = s.pop();
							pop[cur[0]][cur[1]] = avgPop;
						}
					}
			}
		}
	}
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int nextInt() throws IOException {
		if(st==null || !st.hasMoreElements()) 
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}