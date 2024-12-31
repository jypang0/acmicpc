package math;
import java.util.Scanner;

/**
 * @사용알고리즘 median은 count를 더하면서 min에서 올라갔을 때 전체 크기 중간 ((N+1)/2)에 위치해 있는것이 median임을 기억!
 * @사용자료구조 
 *  
 * @배운점 median을 더 똑똑하게 구하는 법.. count array로 mode median둘 다 구할 수 있다
 * 
 * @try1
 *
 * @Date 31 Dec 2024
 */
public class S3_2108_통계확_meanModeMedianRange_final {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		double sum = 0;
		int min = 4001;
		int max = -4001;
		int[] count = new int[8001];

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			sum += input;
			min = Math.min(min, input);
			max = Math.max(max, input);
			count[input + 4000]++;
		}

		int median = 0;
		boolean foundMedian = false;
		int countSum = 0;

		int maxCount = 0;
		boolean isSecond = false;
		int mode = -4001;

		for (int i = min + 4000; i <= 4000 + max; i++) {
			if (count[i] == 0)
				continue;

			if (!foundMedian) {
				countSum += count[i];
				if (countSum >= (N + 1) / 2) {
					median = i - 4000;
					foundMedian = true;
				}
			}

			if (count[i] > maxCount) {
				maxCount = count[i];
				mode = i - 4000;
				isSecond = false;
			} else if (count[i] == maxCount) {
				if (isSecond)
					continue;
				mode = i - 4000;
				isSecond = true;
			}
		}

		System.out.println(Math.round(sum / N));
		System.out.println(median);
		System.out.println(mode);
		System.out.println(max - min);
	}
}