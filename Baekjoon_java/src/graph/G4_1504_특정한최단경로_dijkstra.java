package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 dijkstra
 * @사용자료구조 
 *  
 * @배운점 Dijkstra
 * 
 * @try1
 *
 * @Date 2024. 3. 23.
 */
class G4_1504_특정한최단경로_dijkstra {

	static int N;
	static List<Node>[] graph;

	public static void main(String[] args) throws IOException {
		N = nextInt();
		graph = new List[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		int m = nextInt();
		while (m-- > 0) {
			int a = nextInt();
			int b = nextInt();
			int c = nextInt();

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		int A = nextInt();
		int B = nextInt();

		int AB = dijkstra(A, B);
		if (AB == -1) {
			System.out.println(-1);
			return;
		}

		int sol1a = dijkstra(1, A);
		int sol1b = dijkstra(B, N);
		int sol2a = dijkstra(1, B);
		int sol2b = dijkstra(A, N);

		int ans = Integer.MAX_VALUE;
		if (sol1a == -1 || sol1b == -1) {
			if (!(sol2a == -1 || sol2b == -1)) {
				ans = sol2a + sol2b + AB;
			} else {
				ans = -1;
			}
		} else if (sol2a == -1 || sol2b == -1) {
			if (!(sol1a == -1 || sol1b == -1)) {
				ans = sol1a + sol2b + AB;
			} else {
				ans = -1;
			}
		} else {
			ans = Math.min(sol1a+sol1b+AB, sol2a+sol2b+AB);
		}
		
		System.out.println(ans);
	}

	static int dijkstra(int from, int to) {
		int[] dist = new int[N + 1];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[from] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
		pq.add(new Node(from, 0));

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();

			if (dist[curNode.destNode] < curNode.dist)
				continue;

			dist[curNode.destNode] = curNode.dist;

			for (Node next : graph[curNode.destNode]) {
				if (dist[next.destNode] < curNode.dist + next.dist) {
					continue;
				}

				pq.add(new Node(next.destNode, curNode.dist + next.dist));
			}
		}

		return dist[to] == Integer.MAX_VALUE ? -1 : dist[to];
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static class Node {
		int destNode;
		int dist;

		public Node(int dN, int d) {
			destNode = dN;
			dist = d;
		}
	}
}