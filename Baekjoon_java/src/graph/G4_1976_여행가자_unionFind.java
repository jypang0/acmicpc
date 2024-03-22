package graph;
import java.util.*;

class G4_1976_여행가자_unionFind {
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		parent = new int[N];
		for(int i=0;i<N;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int connected = sc.nextInt();
				if(i==j)
					continue;
				if(connected==1) {
					union(i,j);
				}
			}
		}
		
		int[] trip = new int[M];
		for(int i=0;i<M;i++) {
			trip[i] = sc.nextInt()-1;
		}
		
		for(int i=0;i<M-1;i++) {
			if(find(trip[i])!=find(trip[i+1])) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) {
			return;
		}
		
		if(a<b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}
	
	static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
}