package impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_18111_마인크래프트_BruteForce {
	static int ansHeight = 257;
	static int minTime = Integer.MAX_VALUE;

	static int inventories;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		// 최소, 최고 높이를 확인하고 최소->최고 사이의 높이를 하나하나 확인

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tok.nextToken());
		int M = Integer.parseInt(tok.nextToken());
		inventories = Integer.parseInt(tok.nextToken());

		int min = 257;
		int max = -1;

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int next = Integer.parseInt(tok.nextToken());
				min = Math.min(min, next);
				max = Math.max(max, next);
				map[i][j] = next;
			}
		}

		if (min == max) {
			System.out.println("0 " + min);
			return;
		}

		for (int height = min; height <= max; height++) {
			run(height);
		}

		System.out.println(minTime + " " + ansHeight);
	}

	public static void run(int height) {
		int inv = inventories;
		int time = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (time > minTime)
					return;
				// 제거만 먼저
				if (map[i][j] <= height)
					continue;
				// 제거해야함 -> 2초
				if (map[i][j] > height) {
					time += (map[i][j] - height) * 2;
					inv += (map[i][j] - height);
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (time > minTime)
					return;
				if (map[i][j] >= height) {
					continue;
				} else {
					if (height - map[i][j] > inv) {
						return;
					} else {
						time += (height - map[i][j]);
						inv -= (height - map[i][j]);
					}
				}
			}
		}
		if (minTime >= time) {
			minTime = time;
			ansHeight = height;
		}
	}
}