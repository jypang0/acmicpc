package math;
import java.util.Scanner;

/**
 * @사용알고리즘 아라토스테네스의 체
 * @사용자료구조 
 *  
 * @배운점 소수를 구하는 공식 -> 소수를 찾으면 그 모든 배수를 지운다, 구하고자하는 최댓값의 제곱근까지만 구한다
 * 
 * @try1
 *
 * @Date 31 Dec 2024
 */
public class S3_1929_소수구하기_EratosthenesSieve {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		boolean[] notPrime = new boolean[N + 1];
		for (int i = 2; i < Math.sqrt(N) + 1; i++) {
			// if i is a prime number
			if (!notPrime[i]) {
				for (int j = i; i * j < N + 1; j++) {
					notPrime[i * j] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (i == 1)
				continue;
			if (!notPrime[i]) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb);
	}
}