package impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @사용알고리즘 구현
 * @사용자료구조 
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 4 Apr 2024
 */
class S4_9012_괄호_impl {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			char[] brackets = br.readLine().toCharArray();

			int openB = 0;
			for (char b : brackets) {
				if (b == '(') {
					openB++;
				} else {
					openB--;
				}

				if (openB < 0) {
					sb.append("NO\n");
					break;
				}
			}

			if (openB > 0) {
				sb.append("NO\n");
			} else if (openB == 0) {
				sb.append("YES\n");
			}
		}

		System.out.print(sb);
	}
}