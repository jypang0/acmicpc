package impl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 switch-case..?
 * @사용자료구조 Stack
 *  
 * @배운점 
 * 
 * @try1 [TODO] 사실하고자하면 더 빠르게할수도 있을듯.. 어짜피 T 주어재니까 그만큼 int[] array만들어서 top위치만 바꾸면되긴함.. 하지만.. 뭐.. 시간 엄청 줄지도않아
 *
 * @Date 2024. 3. 14.
 */
public class S4_10828_스택_swtichCase {
//	push X: 정수 X를 스택에 넣는 연산이다.
//	pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//	size: 스택에 들어있는 정수의 개수를 출력한다.
//	empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
//	top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public static void main(String[] args) throws Exception {
		Stack<Integer> stack = new Stack<>();

		int T = nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			String command = next();
			switch(command) {
			case "push": {
				stack.push(nextInt());
				break;
			}
			case "pop": {
				if(!stack.isEmpty()) {
					sb.append(stack.pop());
				} else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			}
			case "size": {
				sb.append(stack.size());
				sb.append("\n");
				break;
			}
			case "empty": {
				if(stack.isEmpty()) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				sb.append("\n");
				break;
			}
			case "top": {
				if(!stack.isEmpty()) {
					sb.append(stack.peek());
				} else {
					sb.append(-1);
				}
				sb.append("\n");
				break;
			}
			}
		}
		System.out.println(sb);
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static String next() throws Exception {
		if(st==null || !st.hasMoreElements()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}
	
	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}
}