package graph;
import java.io.*;
import java.util.*;

/**
 * @사용알고리즘 UnionFind
 * @사용자료구조 
 *  
 * @배운점 union find 하는 법
 * 
 * @try1
 *
 * @Date 2024. 3. 22.
 */
class G5_1717_집합의표현_unionFind {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		parent = new int[n + 1];
		for(int i=0;i<n+1;i++) {
			parent[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		int m = nextInt();
		while (m-- > 0) {
			int op = nextInt();
			int a = nextInt();
			int b = nextInt();
			if (op == 0) {
				union(a, b);
			} else {
				sb.append((find(a)==find(b))?"YES\n":"NO\n");
			}
		}
		
		System.out.println(sb);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return;
		
		if(a<=b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;

		return parent[a] = find(parent[a]);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}