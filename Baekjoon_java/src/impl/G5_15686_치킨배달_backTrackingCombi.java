package impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 back tracking 짱잼
 * @사용자료구조 
 *  
 * @배운점 백트에서 Array 들고들어갔으면 Copy Copy
 * 
 * @try1
 *
 * @Date 2024. 3. 19.
 */
class G5_15686_치킨배달_backTrackingCombi {

	static int N, M;
	static List<int[]> houses, chickens;

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		N = nextInt();
		M = nextInt();

		houses = new ArrayList<>();
		chickens = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = nextInt();
				if (temp == 1) {
					houses.add(new int[] { i, j });
				} else if (temp == 2) {
					chickens.add(new int[] { i, j });
				}
			}
		}

		int[] dist = new int[houses.size()];
		for (int i = 0; i < chickens.size(); i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);

			run(i, dist, 1);
		}

		System.out.println(answer);

	}

	static void run(int curr, int[] distOrig, int depth) {
		
		int[] dist = Arrays.copyOf(distOrig, distOrig.length);
		
		// stands for chickenRow
		int cR = chickens.get(curr)[0];
		int cC = chickens.get(curr)[1];

		for (int i = 0; i < dist.length; i++) {
			int hR = houses.get(i)[0];
			int hC = houses.get(i)[1];

			int d = Math.abs(hR - cR) + Math.abs(hC - cC);

			dist[i] = Math.min(dist[i], d);
		}

		int temp = 0;
		for (int d : dist)
			temp += d;

		answer = Math.min(answer, temp);

		if (depth == M)
			return;

		for (int i = curr + 1; i < chickens.size(); i++)
			run(i, dist, depth + 1);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());

		return Integer.parseInt(st.nextToken());
	}
}