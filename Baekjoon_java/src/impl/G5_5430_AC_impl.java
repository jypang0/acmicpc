package impl;
import java.util.*;
import java.io.*;

/**
 * @사용알고리즘 없음
 * @사용자료구조 int[]...?
 *  
 * @배운점 제발 정신줄 놓지말고 끝까지 집중좀
 * 
 * @try1
 *
 * @Date 2024. 3. 16.
 */
class G5_5430_AC_impl {
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			sb.append(test()).append("\n");
		}
		System.out.print(sb);
	}
	
	static String test() throws IOException {
		char[] commands = next().toCharArray();
		
		boolean isFront = true;
		int front = 0;
		int rear = nextInt()-1;
		
		int[] array = getIntArray(rear+1);
		
		for(int i=0;i<commands.length;i++) {
			if(commands[i]=='R') {
				isFront = !isFront;
			} else {
				if(isFront) {
					front++;
				} else {
					rear--;
				}
				
				if(rear<front-1) {
					return "error";
				}
			}
		}
		
		StringBuilder answer = new StringBuilder();
		answer.append("[");
		if(isFront) {
			for(int i=front;i<=rear;i++) {
				answer.append(array[i]).append(",");
			}
		} else {
			for(int i=rear;i>=front;i--) {
				answer.append(array[i]).append(",");
			}
		}
		if(answer.length()!=1) answer.setLength(answer.length()-1);
		answer.append("]");
		
		return answer.toString();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok;
	
	static String next() throws IOException {
		if (tok == null || !tok.hasMoreElements())
			tok = new StringTokenizer(br.readLine());

		return tok.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static int[] getIntArray(int arrayLength) throws IOException {
		String tempStr = br.readLine();
		tempStr = tempStr.substring(1, tempStr.length() - 1);
		StringTokenizer temp = new StringTokenizer(tempStr, ",");

		int[] arr = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			arr[i] = Integer.parseInt(temp.nextToken());
		}

		return arr;
	}
}