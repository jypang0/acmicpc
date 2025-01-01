package greedy;
import java.util.Arrays;
import java.util.Scanner;

public class S4_11399_ATM_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int ans = 0;
		int temp = ans;
		for (int a : arr) {
			ans += temp + a;
			temp = temp + a;
		}

		System.out.println(ans);
	}
}