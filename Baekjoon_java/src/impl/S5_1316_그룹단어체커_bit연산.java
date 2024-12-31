package impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @사용알고리즘 bit 연산
 * @사용자료구조 
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 30 Dec 2024
 */
public class S5_1316_그룹단어체커_bit연산 {
	static int flag = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		while (n-- > 0) {
			char[] input = br.readLine().toCharArray();
			char cur = input[0];
			flag = (1 << cur);
			int i = 1;
			for (; i < input.length; i++) {
				if (input[i] == cur)
					continue;

				if (checked(input[i]))
					break;

				cur = input[i];
				flag |= (1 << cur);
			}
			if (i == input.length)
				ans++;
		}

		System.out.println(ans);
	}

	private static boolean checked(int idx) {
		return (flag & (1 << idx)) != 0;
	}
}