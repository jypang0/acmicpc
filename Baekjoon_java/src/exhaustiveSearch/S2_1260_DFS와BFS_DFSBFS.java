package exhaustiveSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 백트랙킹
 * @사용자료구조 Stack, Queue(Linked List), adjacent matrix(boolean[][])
 * 
 * @배운점 Stack이 백트래킹보다 더 빠름
 * 
 * @try1 인접그래프 / 백트래킹 / 큐 	-> 20836/260
 * @try2 인접그래프 / 스택 / 큐 	-> 20276/252
 */
public class S2_1260_DFS와BFS_DFSBFS {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok;

	public static int readInt() throws IOException {
		if (tok == null || !tok.hasMoreElements()) {
			tok = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(tok.nextToken());
	}

	static int N, M, V;
	static boolean[][] graph;
	static StringBuilder sb;
	static boolean[] flag;

	public static void main(String[] args) throws IOException {
		N = readInt();
		M = readInt();
		V = readInt() - 1;

		graph = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			int a = readInt() - 1;
			int b = readInt() - 1;

			graph[a][b] = true;
			graph[b][a] = true;
		}

		DFS();
		BFS();
	}

	/**
	 * @try1
	 * recur을 이용해서 backtracking으로 품
	 */
	public static void DFS() {
		sb = new StringBuilder();
		flag = new boolean[N];
		recur(V);
		System.out.println(sb.deleteCharAt(sb.length() - 1));

	}

	/**
	 * backtracking part
	 * @param curr
	 */
	public static void recur(int curr) {
		if (flag[curr]) {
			return;
		}

		sb.append(curr + 1).append(" ");
		flag[curr] = true;

		for (int i = 0; i < N; i++) {
			if (graph[curr][i] && !flag[i]) {
				recur(i);
			}
		}
	}

	/**
	 * @try2
	 * stack을 사용
	 */
	public static void DFS1() {
		sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		flag = new boolean[N];
		stack.add(V);

		while (!stack.isEmpty()) {
			int v = stack.pop();
			if (flag[v])
				continue;
			flag[v] = true;
			sb.append(v + 1).append(" ");

			for (int i = N - 1; i >= 0; i--) {
				if (graph[v][i] && !flag[i]) {
					stack.add(i);
				}
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}

	public static void BFS() {
		sb = new StringBuilder();

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		flag = new boolean[N];
		flag[V] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr + 1).append(" ");

			for (int i = 0; i < N; i++) {
				if (graph[curr][i] && !flag[i]) {
					flag[i] = true;
					queue.add(i);
				}
			}
		}

		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}

}