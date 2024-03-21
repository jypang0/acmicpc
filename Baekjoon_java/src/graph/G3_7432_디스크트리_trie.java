package graph;
import java.io.*;
import java.util.*;

/**
 * @사용알고리즘 trie, DFS(for prepareSb)
 * @사용자료구조 Node, Map, List(made of Set)
 *  
 * @배운점 trie 사용법
 * 
 * @try1
 *
 * @Date 2024. 3. 21.
 */
class G3_7432_디스크트리_trie {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		Node rootNode = new Node();
		
		while(n-->0) {
			st = new StringTokenizer(br.readLine(),"\\");
			Node node = rootNode;
			while(st.hasMoreElements()) {
				node = node.nextNode.computeIfAbsent(st.nextToken(), k->new Node());
			}
		}
		
		prepareSb(rootNode,0);
		System.out.print(sb);
	}
	
	static StringBuilder sb = new StringBuilder();
	static void prepareSb(Node node, int depth) {
		if(node.nextNode.isEmpty())
			return;
		List<String> keyVals = new ArrayList<>(node.nextNode.keySet());
		Collections.sort(keyVals);
		for(String key:keyVals) {
			for(int i=0;i<depth;i++) {
				sb.append(" ");
			}
			sb.append(key).append("\n");
			prepareSb(node.nextNode.get(key),depth+1);
		}
	}
	
	static class Node {
		Map<String, Node> nextNode = new HashMap<>();
	}
}