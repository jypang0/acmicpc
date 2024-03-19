package exhaustiveSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 BFS
 * @사용자료구조 queue, pq, boolean[]
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 2024. 3. 11.
 */
class S2_18352_특정거리의도시찾기_BFS2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());

		return Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws IOException {
		int N = nextInt();
		int M = nextInt();
		int K = nextInt();
		int X = nextInt();

		List<Integer>[] graph = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		while (M-- > 0) {
			int A = nextInt();
			int B = nextInt();
			graph[A].add(B);
		}

		// BFS
		PriorityQueue<Integer> answer = new PriorityQueue<Integer>();

		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(X);
		visited[X] = true;

		int dist = 0;

		while (!queue.isEmpty()) {
			int qS = queue.size();
			for (int i = 0; i < qS; i++) {
				int curr = queue.poll();
				
				for(int next:graph[curr]) {
					if (!visited[next]) {
						visited[next] = true;
						if (dist == K-1) {
							answer.add(next);
						} else {
							queue.add(next);
						}
					}
				}
			}
			dist++;
		}

		StringBuilder sb = new StringBuilder();
		while (!answer.isEmpty()) {
			sb.append(answer.poll()).append("\n");
		}

		if (sb.length() == 0) {
			sb.append("-1\n");
		}

		System.out.print(sb);
	}
}