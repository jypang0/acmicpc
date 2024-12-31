package math;
import java.util.Scanner;

/**
 * @사용알고리즘 딱히 알고리즘이랄건 없지만.. +와 -가 혼재되어있을때 괄호는 +에 다 해줘야 최댓값이 나온다는걸 기억하자
 * @사용자료구조 
 *  
 * @배운점 split method에서 parenthesis안에는 regex가 들어와야하는데 +는 regex에서 사용되는 문자여서 그냥 적으면 오류난다 -> "\\+"이런식으로 적어줘야함
 * 
 * @try1 원래 ArrayList와 StringTokenizer로 만들었었는데 그렇게하는거랑 사실 크게 mem, cpu차이는 없는듯...
 *
 * @Date 31 Dec 2024
 */
public class S2_1541_잃어버린괄호_splitMethod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] sums = sc.nextLine().split("-");

		int ans = sum(sums[0]);

		for (int i = 1; i < sums.length; i++) {
			ans -= sum(sums[i]);
		}

		System.out.println(ans);
	}

	public static int sum(String expr) {
		String[] nums = expr.split("\\+");
		int ans = 0;
		for (String n : nums) {
			ans += Integer.parseInt(n);
		}
		return ans;
	}
}