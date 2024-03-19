package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 BFS
 * @사용자료구조 BFS
 *  
 * @배운점 BFS
 * 
 * @try1 그냥 막 품 ㅋㅋㅋㅋ 더 잘할수있을듯
 *
 * @Date 2024. 3. 19.
 */
class G4_14502_연구소_BFS {
	public static void main(String[] args) throws IOException {
		int N = nextInt();
		int M = nextInt();

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = nextInt();
			}
		}

		int result = -1;

		for (int i = 0; i < N * M; i++) {
			if (arr[i / M][i % M] != 0)
				continue;
			arr[i / M][i % M] = 1;
			for (int j = i + 1; j < N * M; j++) {
				if (arr[j / M][j % M] != 0)
					continue;
				arr[j / M][j % M] = 1;
				for (int k = j + 1; k < N * M; k++) {
					if (arr[k / M][k % M] != 0)
						continue;
					arr[k / M][k % M] = 1;

					result = Math.max(result, spread(arr));

					arr[k / M][k % M] = 0;
				}
				arr[j / M][j % M] = 0;
			}
			arr[i / M][i % M] = 0;
		}

		System.out.println(result);
	}

	static int[][] drdc = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static int spread(int[][] A) {
		Queue<int[]> queue = new LinkedList<>();
		
		int[][] arr = new int[A.length][A[0].length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = A[i][j];
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 2) {
					queue.add(new int[] { i, j });
				}
			}
		}

		boolean[][] visited = new boolean[arr.length][arr[0].length];
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			if (visited[curr[0]][curr[1]]) {
				continue;
			}

			visited[curr[0]][curr[1]] = true;
			arr[curr[0]][curr[1]] = 2;

			for (int i = 0; i < 4; i++) {
				int newR = curr[0] + drdc[i][0];
				int newC = curr[1] + drdc[i][1];

				if (newR < 0 || newC < 0 || newR >= arr.length || newC >= arr[0].length)
					continue;
				if (arr[newR][newC] != 0 || visited[newR][newC])
					continue;

				queue.add(new int[] { newR, newC });
			}
		}

		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0)
					result++;
			}
		}

		return result;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok;

	static int nextInt() throws IOException {
		if (tok == null || !tok.hasMoreElements()) {
			tok = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(tok.nextToken());
	}
}