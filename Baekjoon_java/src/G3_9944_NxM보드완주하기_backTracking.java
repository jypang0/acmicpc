import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_9944_NxM보드완주하기_backTracking {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, answer;
	static boolean[][] board;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int TC = 1;
		while (true) {
			String firstLine = br.readLine();
			if (firstLine == null) {
				break;
			}
			sb.append("Case ").append(TC++).append(": ");

			st = new StringTokenizer(firstLine);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			board = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				String row = br.readLine();
				for (int j = 0; j < M; j++) {
					board[i][j] = row.charAt(j) == '.' ? true : false;
				}
			}

			run();
		}

		System.out.print(sb);
	}

	static int[][] drdc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static void run() {

		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!board[i][j]) {
					continue;
				}

				for (int d = 0; d < 4; d++) {
					answer = Math.min(answer, backTracking(new boolean[N][M], i, j, d, 0));
				}
			}
		}

		sb.append(answer).append("\n");
	}

	static int backTracking(boolean[][] visited, int r, int c, int d, int ans) {
		if (ans > answer) {
			return Integer.MAX_VALUE;
		}

		int newR = r;
		int newC = c;
		while (true) {
			visited[newR][newC] = true;
			newR = newR + drdc[d][0];
			newC = newC + drdc[d][1];

			if (newR < 0 || newC < 0 || newR >= N || newC >= M || !board[newR][newC]) {
				newR = newR - drdc[d][0];
				newC = newC - drdc[d][1];

				if (newR == r && newC == c) {
					return Integer.MAX_VALUE;
				}

				break;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (d == i)
				continue;
			backTracking(visited, newR, newC, i, ans + 1);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] && !visited[i][j]) { // can travel but did not
					return -1;
				}
			}
		}

		return Integer.MAX_VALUE;
	}
}
