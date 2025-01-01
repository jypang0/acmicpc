package greedy;
import java.util.Scanner;

public class S4_11047_동전0_arithmetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}

		int ans = 0;
		for (int i = N - 1; i >= 0; i--) {
			// 바본가.. 왜 하나하나 하고있냐 나누면 바론데
//			while (K >= coins[i]) {
//				K -= coins[i];
//				ans++;
//			}
			while (K / coins[i] != 0) {
				ans += K / coins[i];
				K -= coins[i] * (K / coins[i]);
			}
			if (K == 0)
				break;
		}

		System.out.println(ans);
	}
}