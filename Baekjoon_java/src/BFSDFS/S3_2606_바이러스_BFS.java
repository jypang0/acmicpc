package BFSDFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_2606_바이러스_BFS  {
	
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		graph[1] = new ArrayList<Integer>();
		while(M-->0) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tok.nextToken());
			int b = Integer.parseInt(tok.nextToken());
			
			if(graph[a]==null) {
				graph[a] = new ArrayList<Integer>();
			}
			if(graph[b]==null) {
				graph[b] = new ArrayList<Integer>();
			}
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		System.out.println(BFS());
	}
	
	public static int BFS() {
		int count = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		boolean[] visited = new boolean[graph.length];
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			if(visited[curr]==true)
				continue;
			
			count++;
			visited[curr] = true;
			
			for(int node:graph[curr]) {
				if(!visited[node]) {
					queue.add(node);
				}
			}
		}
		
		return count;
	}
}