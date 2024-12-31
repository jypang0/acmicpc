package DP;
import java.util.Scanner;

/**
 * @사용알고리즘 DP
 * @사용자료구조 
 *  
 * @배운점 DP를 겁내지말자! 그래프로 그려봤는데 훨씬 이해가 쉬웠다
 * 
 * @try1
 *
 * @Date 30 Dec 2024
 */
public class S4_2839_설탕배달_bottomUp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int x = N / 3;
		int y = N / 5;

		int ans = x == N * 3 ? x : y == N * 5 && y > x ? y : Integer.MAX_VALUE;

		// y = -3x/5+N/5
		for (int i = x; i >= 0; i--) {
			double j = (N - 3 * i) / 5.0;
			// if both are integers
			if (j % 1 == 0) {
				if (i + j < ans) {
					ans = i + (int) j;
				} else {
					break;
				}
			}
		}

		// x = -5y/3+N/3
		for (int i = y; i >= 0; i--) {
			double j = (N - 5 * i) / 3.0;
			// if both are integers
			if (j % 1 == 0) {
				if (i + j < ans) {
					ans = i + (int) j;
				} else {
					break;
				}
			}
		}

		System.out.println(ans < Integer.MAX_VALUE ? ans : -1);

	}
}