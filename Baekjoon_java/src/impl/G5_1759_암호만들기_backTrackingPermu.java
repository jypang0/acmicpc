package impl;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @사용알고리즘 backtracking
 * @사용자료구조 
 *  
 * @배운점 백트할 때 각 들고가는 값이 무엇을 뜻하는지 정확히 알고 쓰자.
 * 
 * @try1
 *
 * @Date 2024. 3. 21.
 */
class G5_1759_암호만들기_backTrackingPermu {
	static int L, C;
	static char[] chars;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		L = sc.nextInt();
		C = sc.nextInt();

		chars = new char[C];
		for (int i = 0; i < C; i++) {
			chars[i] = sc.next().charAt(0);
		}
		Arrays.sort(chars);

		for (int i = 0; i < C; i++)
			permu(1, i, isVowel(chars[i])?1:0, isVowel(chars[i])?0:1, String.valueOf(chars[i]));
		
		System.out.print(answer);
	}

	static void permu(int depth, int curr, int numVowel, int numConso, String temp) {
		if (depth == L) {
			if(numVowel>=1 && numConso>=2) answer.append(temp).append("\n");
			return;
		}

		for (int i = curr+1; i < C; i++) {
			boolean isVowel = isVowel(chars[i]);
			permu(depth + 1, i, numVowel+(isVowel?1:0), numConso+(isVowel?0:1), temp + chars[i]);
		}
	}
	
	static boolean isVowel(char c) {
		char[] vowels = {'a','e','i','o','u'};
		for(int i=0;i<vowels.length;i++) {
			if(c==vowels[i]) {
				return true;
			}
		}
		return false;
	}
}