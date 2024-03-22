package graph;
import java.util.*;

/**
 * @사용알고리즘 trie
 * @사용자료구조 
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 2024. 3. 23.
 */
class G3_16934_게임닉네임_trie {
	static Node rootNode = new Node();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		String[] nicknames = new String[N];
		StringBuilder sb = new StringBuilder();
		
		Map<String, Integer> counts = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String nickname = sc.next();
			nicknames[i] = nickname;
			boolean flag = true;

			Node node = rootNode;

			for (int c = 0; c < nickname.length(); c++) {
				char n = nickname.charAt(c);
				
				if(flag) {
					sb.append(n);
				}
				
				if(node.childNodes.get(n)==null) {
					node.childNodes.put(n, new Node());
					flag = false;
				} 
				
				node = node.childNodes.get(n);
			}
			
			if(counts.get(nickname)!=null) {
				sb.append(counts.get(nickname)+1);
				counts.put(nickname, counts.get(nickname)+1);
			} else {
				counts.put(nickname, 1);
			}
			sb.append("\n");
		}
		
		
		System.out.print(sb);
	}

	static class Node {
		Map<Character, Node> childNodes = new HashMap<>();
	}
}