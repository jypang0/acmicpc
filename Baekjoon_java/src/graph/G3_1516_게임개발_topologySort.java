package graph;
import java.util.*;

/**
 * @사용알고리즘 topology Sort
 * @사용자료구조 
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 2024. 3. 23.
 */
class G3_1516_게임개발_topologySort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		List<Integer>[] map = new List[N];
		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<Integer>();
		}
		int[] time = new int[N];
		int[] depth = new int[N];
		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();

			int before = sc.nextInt() - 1;
			while (before >= 0) {
				depth[i]++;
				map[before].add(i);
				before = sc.nextInt() - 1;
			}
		}

		int[] answer = new int[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			if (depth[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			answer[cur] += time[cur];
			for (int next : map[cur]) {
				answer[next] = Math.max(answer[next], answer[cur]);
				if (--depth[next] == 0) {
					queue.add(next);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(answer[i]);
		}
	}

}