package BFSDFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_2606_바이러스_DFS  {
	
	static List<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		
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
		
		DFS(1);
		System.out.println(answer);
	}
	static int answer = -1;
	
	public static void DFS(int curr) {
		if(visited[curr])
			return;
		
		visited[curr] = true;
		answer++;
		
		for(int node:graph[curr]) {
			if(!visited[node]) {
				DFS(node);
			}
		}
		
	}
}