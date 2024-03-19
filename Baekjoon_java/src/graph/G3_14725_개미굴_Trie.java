package graph;
import java.util.*;

/**
 * @사용알고리즘 Trie
 * @사용자료구조 Map, Node
 *  
 * @배운점 Map 사용법을 더 정확히 알게됨 -> computeIfAbsent, keySet
 * 
 * @try1 Key를 오름차순 정렬하는걸 까먹음
 *
 * @Date 2024. 3. 20.
 */
class G3_14725_개미굴_Trie {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static Node rootNode = new Node();
	
	public static void main(String[] args) {
		int N = sc.nextInt();
		
		while(N-->0) {
			int depth = sc.nextInt();
			Node node = rootNode;
			while(depth-->0) {
				String word = sc.next();
				
				node = node.childNodes.computeIfAbsent(word, key->new Node());
			}
		}
		
		runThrough(rootNode, 0);
		
		System.out.println(sb);
	}
	
	static void runThrough(Node node, int depth) {
		
		List<String> keySet = new ArrayList<>(node.childNodes.keySet());
		Collections.sort(keySet);
		
		for(String key:keySet) {
			for(int i=0;i<depth;i++) {
				sb.append("--");
			}
			sb.append(key).append("\n");
			runThrough(node.childNodes.get(key), depth+1);
		}
	}

	static class Node {
		Map<String, Node> childNodes = new HashMap<>();
	}
}