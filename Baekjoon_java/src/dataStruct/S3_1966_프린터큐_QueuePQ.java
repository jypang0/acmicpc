package dataStruct;
import java.util.*;
import java.io.*;

/**
 * @사용알고리즘 구현
 * @사용자료구조 Queue, PQ
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 4 Apr 2024
 */
class S3_1966_프린터큐_QueuePQ {
	
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			int N = nextInt();
			int M = nextInt();
			
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
			Queue<int[]> q = new LinkedList<>(); // index, value
			for(int i=0;i<N;i++) {
				int a = nextInt();
				
				pq.add(a);
				q.add(new int[] {i,a});
			}
			
			int t = 0;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				if(cur[1]==pq.peek()) {
					pq.poll();
					t++;
					
					if(cur[0]==M) {
						sb.append(t).append("\n");
					}
				} else {
					q.add(cur);
				}
			}
		}
		
		System.out.print(sb);
	}
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int nextInt() throws IOException {
		if(st==null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}