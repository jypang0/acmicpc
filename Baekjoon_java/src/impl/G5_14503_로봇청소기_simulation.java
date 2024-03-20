package impl;
import java.util.*;

/**
 * @사용알고리즘 
 * @사용자료구조 
 *  
 * @배운점 문제 끝까지 읽기!
 * 
 * @try1 에혀.. trial and error식으로 풀지말고 처음부터 잘 하자.. tempD에다가 i를 왜 더하니 1을 더해야지
 * @try2 90도 돌고 간다고 적혀있는데 무작정 직진은 무슨 자신감이람
 *
 * @Date 2024. 3. 20.
 */
class G5_14503_로봇청소기_simulation {

	static int N, M, r, c, d, answer = 0;
	static int[][] room; // 0-not cleaned, 1-wall, 2-cleaned

	static final int[][] DRDC = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		room = new int[N][M];

		r = sc.nextInt();
		c = sc.nextInt();
		d = 3 - sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				room[i][j] = sc.nextInt();
			}
		}

		clean();

		System.out.println(answer);
	}

	static void clean() {
		while (true) {
			if (room[r][c] == 0) { // if not cleaned
				room[r][c] = 2; // clean the floor
				answer++; // increment amount cleaned
			} else {
				int tempD = d;
				boolean found = false;
				for (int i = 1; i <= 4; i++) {
					tempD = (tempD + 1) % 4;
					int tempR = r + DRDC[tempD][0];
					int tempC = c + DRDC[tempD][1];
					if (!isValid(tempR, tempC))
						continue;

					if (room[tempR][tempC] == 0) { // if not cleaned
						// move the robot
						r = tempR;
						c = tempC;
						d = tempD;
						found = true;
						break;
					}
				}

				if (!found) {
					// 후진
					int tempR = r + DRDC[d][0] * -1;
					int tempC = c + DRDC[d][1] * -1;
					if (!isValid(tempR, tempC) || room[tempR][tempC] == 1) {
						return;
					}
					r = tempR;
					c = tempC;
				}
			}
		}

	}

	static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}