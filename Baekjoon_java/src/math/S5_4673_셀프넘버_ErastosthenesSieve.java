package math;
/**
 * @사용알고리즘 에라스토스테네스의 체와 비슷한 접근으로 품
 * @사용자료구조 
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 5 Jan 2025
 */
public class S5_4673_셀프넘버_ErastosthenesSieve {
	public static void main(String[] args) {
		boolean[] notSelf = new boolean[10001];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < notSelf.length; i++) {
			if (notSelf[i])
				continue;
			sb.append(i).append("\n");
			int num = d(i);
			while (num < notSelf.length) {
				notSelf[num] = true;
				num = d(num);
			}
		}
		System.out.println(sb);
	}

	public static int d(int n) {
		int ret = n;

		while (n > 0) {
			ret += n % 10;
			n /= 10;
		}

		return ret;
	}
}