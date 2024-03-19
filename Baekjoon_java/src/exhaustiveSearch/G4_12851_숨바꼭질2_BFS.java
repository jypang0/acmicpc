package exhaustiveSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// IMPORTANT
/**
 * @사용알고리즘 Queue, int[]
 * @사용자료구조 BFS
 *  
 * @배운점 와... 이거 외우지.. 모든 방법을 하려면 1->2 로 가는 방법이 1+1과 1*2 이렇게 두 방법이 있다는걸 기억해야하는 문제였음 와 이거 나오면 못풀었다 ㅋㅋ visited를 int로 해야했음
 * 
 * @try1
 *
 * @Date 2024. 3. 11.
 */
class G4_12851_숨바꼭질2_BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		if (N >= K) {
			sb.append(N - K).append("\n").append(1);
			System.out.println(sb.toString());
			return;
		}

		// BFS
		int[] visited = new int[100001];
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(N);
		visited[N]++;

		int answer = 0;
		int count = 0;
		boolean flag = false;
		while (!queue.isEmpty() && !flag) {
			int qS = queue.size();
			for (int i = 0; i < qS; i++) {
				int curr = queue.poll();

				for (int j = 0; j < 3; j++) {
					int next = curr;
					switch (j) {
					case 0:
						next++;
						break;
					case 1:
						next--;
						break;
					case 2:
						next *= 2;
						break;
					}

					if (next >= 0 && next < 100001 && visited[next]<=3) {
						if (next == K) {
							flag = true;
							count++;
						} else {
							visited[next]++;
							queue.offer(next);
						}
					}
				}
			}
			answer++;
		}

		sb.append(answer).append("\n").append(count);
		System.out.println(sb.toString());
	}
}