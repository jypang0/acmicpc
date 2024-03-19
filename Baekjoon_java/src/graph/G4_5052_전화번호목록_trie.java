package graph;

import java.util.*;

/**
 * @사용알고리즘 trie
 * @사용자료구조 map<int, node> , node
 *  
 * @배운점 trie
 * 
 * @try1
 *
 * @Date 2024. 3. 20.
 */
class G4_5052_전화번호목록_trie {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			sb.append(run() ? "YES\n" : "NO\n");
		}
		System.out.print(sb);
	}

	static boolean run() {
		Node rootNode = new Node();

		int N = sc.nextInt();
		while (N-- > 0) {
			Node node = rootNode;
			String num = sc.next();
			for (int i = 0; i < num.length(); i++) {
				int n = num.charAt(i) - '0';
				if (node.childNodes.containsKey(n)) {
					node = node.childNodes.get(n);
					if (node.EOW || i == num.length() - 1) {
						while (N-- > 0)
							sc.nextInt();
						return false;
					}
				} else {
					node.childNodes.put(n, new Node());
					node = node.childNodes.get(n);
					if (i == num.length() - 1) {
						node.EOW = true;
					}
				}
			}
		}

		return true;
	}

	static class Node {
		Map<Integer, Node> childNodes = new HashMap<>();
		boolean EOW;

	}

}