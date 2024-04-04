package dataStruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class S4_9012_괄호_Stack {
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