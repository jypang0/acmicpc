package BFSDFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @사용알고리즘 BFS
 * @사용자료구조 Queue
 *  
 * @배운점 [외워라] 제발 뽑고 visited 변경하고 넣기전에 visited 확인하고
 * 
 * @try1
 *
 * @Date 2024. 3. 21.
 */
class G5_13549_숨바꼭질3_BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int answer = Integer.MAX_VALUE;
		
		boolean[] visited = new boolean[100_001];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N,0});
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			visited[curr[0]] = true;
			if(curr[0]==K) {
				answer = Math.min(curr[1], answer);
			}

			// *2
			if(curr[0]*2<visited.length && !visited[curr[0]*2]) {
				queue.add(new int[] {curr[0]*2, curr[1]});
			}
			
			// +1
			if(curr[0]+1<visited.length && !visited[curr[0]+1]) {
				queue.add(new int[] {curr[0]+1, curr[1]+1});
			}
			
			// -1
			if(curr[0]-1>=0 && !visited[curr[0]-1]) {
				queue.add(new int[] {curr[0]-1, curr[1]+1});
			}
		}
		
		System.out.println(answer);
	}
}