package graph;
import java.io.*;
import java.util.*;

/**
 * @사용알고리즘 topology sort
 * @사용자료구조 
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 2024. 3. 20.
 */
class G3_2252_줄세우기_topologySort {
	public static void main(String[] args) throws IOException {
		int N = nextInt();
		
		int[] depth = new int[N+1];
		List<Integer>[] graph = new List[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<Integer>();
		}

		int M = nextInt();
		while(M-->0) {
			int A = nextInt();
			int B = nextInt();
			
			graph[A].add(B);
			depth[B]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		// init queue
		for(int i=1;i<=N;i++) {
			if(depth[i]==0) {
				queue.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(" ");
			
			for(int next:graph[curr]) {
				depth[next]--;
				if(depth[next]==0) {
					queue.add(next);
				}
			}
		}
		
		System.out.println(sb);

	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int nextInt() throws IOException {
		if(st==null||!st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
}