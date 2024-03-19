package exhaustiveSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @사용알고리즘 BFS
 * @사용자료구조 Queue(linked list), PriorityQueue
 *  
 * @배운점 BFS 실습
 * 
 * @try1
 *
 * @Date 2024. 3. 6.
 */
public class S1_2667_단지번호붙이기_BFS {

	static boolean[][] graph, visited;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		graph = new boolean[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < N; j++) {
				graph[i][j] = row.charAt(j) == '1';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] && !visited[i][j]) {
					pq.add(BFS(new int[] { i, j }));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.print(sb.toString());
	}

	final static int[][] DRDC = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static int BFS(int[] start) {
		int count = 0;

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(start);

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (visited[curr[0]][curr[1]])
				continue;

			visited[curr[0]][curr[1]] = true;
			count++;

			for (int i = 0; i < 4; i++) {
				int newR = curr[0] + DRDC[i][0];
				int newC = curr[1] + DRDC[i][1];

				if (newR < 0 || newC < 0 || newR >= graph.length || newC >= graph.length || visited[newR][newC]
						|| !graph[newR][newC]) {
					continue;
				}

				q.add(new int[] { newR, newC });
			}
		}

		return count;
	}
}