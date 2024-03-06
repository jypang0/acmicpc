package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 DFS
 * @사용자료구조 array of list
 *  
 * @배운점 백트 DFS할 때 순서 잘 생각하면서 하자
 * 
 * @try1
 *
 * @Date 2024. 3. 7.
 */
public class S2_2644_촌수계산_DFS {

	static int A, B;
	static List<Integer>[] graph;
	static int[] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		graph = new List[N + 1];
		for(int i=0;i<N+1;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		dist = new int[N + 1];
		Arrays.fill(dist, -1);

		StringTokenizer tok = new StringTokenizer(br.readLine());
		A = Integer.parseInt(tok.nextToken());
		B = Integer.parseInt(tok.nextToken());

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			tok = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tok.nextToken());
			int y = Integer.parseInt(tok.nextToken());

			graph[x].add(y);
			graph[y].add(x);
		}

		dist[A] = 0;
		DFS(A,0);
		
		System.out.println(dist[B]);
	}

	public static void DFS(int curr, int d) {
		if (dist[curr] != -1 && curr!=A)
			return;

		dist[curr] = d;
		
		if (curr == B)
			return;

		for (int node : graph[curr]) {
			if (dist[node] != -1)
				continue;
			DFS(node,dist[curr]+1);
		}
	}
}