package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1753_최단경로_dijkstra {

	static int[] dist;
	static List<Edge>[] edges;
	static int V, E, K;

	public static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		dist[K] = 0;
		pq.add(new Edge(K, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (cur.weight > dist[cur.to]) {
				continue;
			}

			for (Edge next : edges[cur.to]) {
				int nextW = cur.weight + next.weight;
				if (nextW < dist[next.to]) {
					dist[next.to] = nextW;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		V = nextInt();
		E = nextInt();
		K = nextInt();

		dist = new int[V + 1];
		edges = new List[V + 1];
		for (int i = 0; i < V + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
			edges[i] = new ArrayList<>();
		}

		dist[K] = 0;

		for (int e = 0; e < E; e++) {
			int u = nextInt();
			int v = nextInt();
			int w = nextInt();

			edges[u].add(new Edge(v, w));
		}

		dijkstra();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V + 1; i++) {
			if(dist[i] == Integer.MAX_VALUE) 
				sb.append("INF\n");
			else 
				sb.append(dist[i]).append("\n");
		}
		System.out.print(sb.toString());
	}

	static class Edge implements Comparable<Edge>{
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", weight=" + weight + "]";
		}
		
		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok;

	public static int nextInt() throws IOException {
		if (tok == null || !tok.hasMoreElements())
			tok = new StringTokenizer(br.readLine());

		return Integer.parseInt(tok.nextToken());
	}
}