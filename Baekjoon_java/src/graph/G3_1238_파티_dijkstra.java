package graph;
import java.io.*;
import java.util.*;

/**
 * @사용알고리즘 dijkstra
 * @사용자료구조 PQ
 *  
 * @배운점 [외우기] curr 뽑으 다음에 체크하는거 잊지말자!
 * 
 * @try1
 *
 * @Date 2024. 3. 21.
 */
class G3_1238_파티_dijkstra {
	static int N, X;
	static List<Node>[] graph; // 정방
	static List<Node>[] revGraph; // 역방향

	public static void main(String[] args) throws IOException {
		N = nextInt();
		int m = nextInt();
		X = nextInt();

		graph = new List[N+1];
		revGraph = new List[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
			revGraph[i] = new ArrayList<>();
		}
		while (m-- > 0) {
			int a = nextInt();
			int b = nextInt();
			int c = nextInt();

			graph[a].add(new Node(b, c));
			revGraph[b].add(new Node(a, c));
		}

		int[] dist = dijkstra(graph);
		int[] revDist = dijkstra(revGraph);
		
		int answer = 0;
		for(int i=1;i<N+1;i++) {
			answer = Math.max(answer, dist[i]+revDist[i]);
		}
		
		System.out.println(answer);
	}
	
	static int[] dijkstra(List<Node>[] g) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (curr.weight > dist[curr.idx])
				continue;

			dist[curr.idx] = curr.weight;

			for (Node edge : g[curr.idx]) {
				if (curr.weight + edge.weight >= dist[edge.idx])
					continue;

				pq.add(new Node(edge.idx, curr.weight + edge.weight));
			}
		}
		return dist;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static class Node implements Comparable<Node> {
		int idx;
		int weight;

		public Node(int dest, int weight) {
			this.idx = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}