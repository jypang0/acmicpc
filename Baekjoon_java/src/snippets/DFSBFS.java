package snippets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSBFS {
	
	static int n;
	
	public static String bfs(int v, boolean node[][]) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[n+1];
		queue.add(v);
		visited[v] = true;
		int idx;
		while(!queue.isEmpty()) {
			idx = queue.remove();
			sb.append(idx+" ");
			for(int i=1; i<node.length; i++) 
				if(node[idx][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
		}
		return sb.toString();
	}

	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	static boolean node[][] = new boolean[n+1][n+1], visited[] = new boolean[n+1];
	static void dfs(int v) {
		if(visited[v])
	    	return;
		sb.append(v+" ");
		for(int i=1; i<=n; i++)
			if(node[v][i] && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
	}
}
