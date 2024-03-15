package graph;
import java.io.*;
import java.util.*;

/**
 * @사용알고리즘 dijkstra
 * @사용자료구조 list[], pq
 *  
 * @배운점
 * 
 * @try1 [TODO] visited 안쓰면 왜 안되는지 무조건 알아내라 무조건
 *
 * @Date 2024. 3. 16.
 */
class G5_1916_최소비용구하기_dijkstra {
	public static void main(String[] args) throws IOException {
		int N = nextInt();
		int M = nextInt();

		List<Edge>[] graph = new List[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			int from = nextInt();
			int to = nextInt();
			int weight = nextInt();

			graph[from].add(new Edge(to, weight));
		}

		int A = nextInt();
		int B = nextInt();

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[A] = 0;
		
		boolean[] visited = new boolean[N+1];

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(A, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (visited[cur.to] || cur.weight > dist[cur.to])
				continue;
			
			visited[cur.to]=true;

			for (Edge next : graph[cur.to]) {
				if (next.weight + cur.weight > dist[next.to])
					continue;
				dist[next.to] = next.weight + cur.weight;
				pq.add(new Edge(next.to, dist[next.to]));
			}
		}

		System.out.println(dist[B]);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int nextInt() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(st.nextToken());
	}

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", weight=" + weight + "]";
		}
	}
}