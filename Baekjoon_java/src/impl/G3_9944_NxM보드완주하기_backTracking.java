package impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 backtracking
 * @사용자료구조 
 *  
 * @배운점 차근차근.. 잘 생각해서 풀어라.. 이런건 그냥 완탐한다고 생각하자
 * 
 * @try1
 *
 * @Date 2024. 3. 23.
 */
public class G3_9944_NxM보드완주하기_backTracking {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, toTravel, answer;
	static boolean[][] board;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int TC = 1;
		String firstLine = "";
		while ((firstLine = br.readLine()) != null) {
			sb.append("Case ").append(TC++).append(": ");
			toTravel = 0;

			st = new StringTokenizer(firstLine);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			board = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				String row = br.readLine();
				for (int j = 0; j < M; j++) {
					if (row.charAt(j) == '.') {
						board[i][j] = true;
						toTravel++;
					} else {
						board[i][j] = false;
					}
				}
			}

			run();
		}

		System.out.print(sb);
	}

	static int[][] drdc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static void run() {

		answer = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!board[i][j]) {
					continue;
				}
				visited[i][j] = true;
				backTracking(visited, i, j, 1, 0);
				visited[i][j] = false;
			}
		}

		sb.append(answer==Integer.MAX_VALUE?-1:answer).append("\n");
	}

	static void backTracking(boolean[][] visited, int r, int c, int traveled, int ans) {
		if (traveled == toTravel) { // 다 돌았다
			answer = Math.min(ans, answer);
			return;
		}

		int newR = r;
		int newC = c;

		for (int d = 0; d < 4; d++) {
			while (true) {
				int nextR = newR + drdc[d][0];
				int nextC = newC + drdc[d][1];

				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M || !board[nextR][nextC]
						|| visited[nextR][nextC]) {
					break;
				}

				newR = nextR;
				newC = nextC;
				traveled++;
				visited[newR][newC] = true;
			}

			if (newR == r && newC == c) { // 한칸도 못움직임
				continue;
			}

			backTracking(visited, newR, newC, traveled, ans + 1);

			while (newR != r || newC != c) {
				visited[newR][newC] = false;
				traveled--;
				newR -= drdc[d][0];
				newC -= drdc[d][1];
			}

		}
	}
}
