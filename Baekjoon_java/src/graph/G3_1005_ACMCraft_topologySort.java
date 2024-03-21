package graph;
import java.io.*;
import java.util.*;

/**
 * @사용알고리즘 topology sort
 * @사용자료구조 
 *  
 * @배운점 ... 왜 BFS는 안됐을까... 근데 뭐.. 이전에 해야하는게 있으면 topology라는것 기억할것
 * 
 * @try1
 *
 * @Date 2024. 3. 22.
 */
class G3_1005_ACMCraft_topologySort {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		int T = nextInt();
		while (T-- > 0) {
			int N = nextInt();
			int k = nextInt();

			int[] time = new int[N+1];
			for(int i=1;i<time.length;i++) {
				time[i] = nextInt();
			}
			
			List<Integer>[] graph = new List[N + 1];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
			int[] depth = new int[N+1];
			
			while (k-- > 0) {
				int a = nextInt();
				int b = nextInt();
				
				graph[a].add(b);
				depth[b]++;
			}
			
			int S = nextInt();
			
			int[] aggTime = new int[N+1];
			Queue<Integer> queue = new LinkedList<>();

			for(int i=1;i<depth.length;i++) {
				if(depth[i]==0) {
					queue.add(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				aggTime[curr] += time[curr];
				
				for(int next:graph[curr]) {
					depth[next]--;
					aggTime[next] = Math.max(aggTime[next], aggTime[curr]);
					if(depth[next]==0) {
						queue.add(next);
					}
				}
			}
			
			sb.append(aggTime[S]).append("\n");
		}
		
		System.out.print(sb);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}