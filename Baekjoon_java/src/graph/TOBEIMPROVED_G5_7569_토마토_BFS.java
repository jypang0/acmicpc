package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 BFS
 * @사용자료구조 Queue, 3차원 배열들
 *  
 * @배운점 iteration을 최대한 줄일생각을하고 storage는 좀 덜 신경쓰자.. 뭐 어짜피 storage도 너가 몇배는 더 씀 ㅋㅋ
 * 
 * @try1 그냥 막 구현
 * @try2 TOBE: 비워지면 다시 채우는게 아니라 꺼낸걸 다시 넣는식으로 생각해서 해볼 것, 시간 계산하는 법 다시 생각해볼것
 * @try3 TOBE: 2차원배열로 푸는 법 고민해볼것
 *
 * @Date 2024. 3. 7.
 */
public class TOBEIMPROVED_G5_7569_토마토_BFS {

	static int[][][] graph;
	static boolean[][][] visited;
	static int unriped = 0, days = 0;
	static int N, M, H;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static Queue<Tomato> queue = new LinkedList<>();

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws IOException {
		M = nextInt();
		N = nextInt();
		H = nextInt();

		graph = new int[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					int t = nextInt();
					graph[h][n][m] = t;
					if (t == 0)
						unriped++;
				}
			}
		}

		if (unriped == 0) {
			System.out.println(0);
			return;
		}

		fillQueue();
		BFS();

		System.out.println(unriped != 0 ? -1 : days);
	}

	public static void fillQueue() {
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (graph[h][n][m] == 1) {
						queue.add(new Tomato(h, n, m, days));
					}
				}
			}
		}
	}

	public static boolean inGraph(int r, int c, int h) {
		return r >= 0 && c >= 0 && h >= 0 && r < M && c < N && h < H;
	}

	final static int[][] MOVE = { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, -1 }, { 0, -1, 0 }, { -1, 0, 0 } };

	public static void BFS() {
		while (true) {
			int initUnriped = unriped;
			visited = new boolean[H][N][M];

			while (!queue.isEmpty()) {
				Tomato curr = queue.poll();

				if (visited[curr.h][curr.n][curr.m]) {
					continue;
				}

				visited[curr.h][curr.n][curr.m] = true;

				if (curr.d > days)
					days = curr.d;

				if (graph[curr.h][curr.n][curr.m] == 0) {
					graph[curr.h][curr.n][curr.m] = 1;
					unriped--;
				}
				if (unriped == 0)
					return;

				for (int i = 0; i < MOVE.length; i++) {
					int newH = curr.h + MOVE[i][0];
					int newN = curr.n + MOVE[i][1];
					int newM = curr.m + MOVE[i][2];

					if (!inGraph(newM, newN, newH))
						continue;
					if (visited[newH][newN][newM])
						continue;
					if (graph[newH][newN][newM] != 0)
						continue;

					queue.add(new Tomato(newH, newN, newM, curr.d + 1));

				}
			}

			if (queue.isEmpty()) {
				if (initUnriped == unriped) {
					return;
				} else {
					fillQueue();
				}
			}
		}
	}

	static class Tomato {
		int h;
		int n;
		int m;
		int d;

		public Tomato(int h, int n, int m, int d) {
			super();
			this.h = h;
			this.n = n;
			this.m = m;
			this.d = d;
		}
	}
}