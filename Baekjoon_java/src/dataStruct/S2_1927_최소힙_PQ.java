package dataStruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @사용알고리즘 
 * @사용자료구조 PQ
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 4 Apr 2024
 */
class S2_1927_최소힙_PQ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
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