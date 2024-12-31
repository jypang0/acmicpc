package dataStruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class S2_11279_최대힙_PQ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				if(pq.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				pq.add(n);
			}
		}
		
		System.out.print(sb);
	}
}