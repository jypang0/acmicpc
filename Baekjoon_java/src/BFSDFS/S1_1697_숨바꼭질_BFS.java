package BFSDFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 BFS
 * @사용자료구조 Queue
 *  
 * @배운점 BufferedReader이 한 100ms 더 빨랐다
 * 
 * @try1
 *
 * @Date 2024. 3. 11.
 */
public class S1_1697_숨바꼭질_BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tok.nextToken());
		int K = Integer.parseInt(tok.nextToken());

		if (N >= K) {
			System.out.println(N - K);
			return;
		}

		System.out.println(BFS(N, K));
	}

	public static int BFS(int N, int K) {
		boolean[] visited = new boolean[100001];
		Queue<Integer> queue = new LinkedList<>();

		visited[N] = true;
		queue.offer(N);

		int answer = 0;

		while (!queue.isEmpty()) {
			int qS = queue.size();
			answer++;
			for (int i = 0; i < qS; i++) {
				int cur = queue.poll();

				// x+1
				int next = cur + 1;
				if (next < 100001 && !visited[next]) {
					if (next == K) {
						return answer;
					}
					visited[next] = true;
					queue.offer(next);
				}
				// x-1
				next = cur - 1;
				if (next >= 0 && !visited[next]) {
					if (next == K) {
						return answer;
					}
					visited[next] = true;
					queue.offer(next);
				}
				// x*2
				next = cur * 2;
				if (next < 100001 && !visited[next]) {
					if (next == K) {
						return answer;
					}
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		return 0;
	}
}