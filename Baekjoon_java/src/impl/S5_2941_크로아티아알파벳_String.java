package impl;
import java.util.Scanner;

public class S5_2941_크로아티아알파벳_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.next().toCharArray();

		int count = 1;

		for (int i = 1; i < input.length; i++) {
			count++;
			switch (input[i]) {
			case '=':
				if (input[i - 1] == 'c' || input[i - 1] == 's')
					count--;
				else if (input[i - 1] == 'z') {
					if (i > 1 && input[i - 2] == 'd')
						count--;
					count--;
				}
				break;
			case '-':
				if (input[i - 1] == 'c' || input[i - 1] == 'd')
					count--;
				break;
			case 'j':
				if (input[i - 1] == 'l' || input[i - 1] == 'n')
					count--;
				break;
			}
		}

		System.out.println(count);
	}
}