package search;
import java.util.*;

/**
 * @사용알고리즘 binary search
 * @사용자료구조 
 *  
 * @배운점 외우자! front = 0, back arr.length-1, while(front<=back)
 * 
 * @try1
 *
 * @Date 2024. 3. 20.
 */
class S4_1920_수찾기_BinarySearch {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		int[] queries = new int[M];
		for(int i=0;i<M;i++) {
			queries[i] = sc.nextInt();
		}
		
		StringBuilder sb = new StringBuilder();
		for(int query:queries) {
			sb.append(binarySearch(query)?1:0).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static boolean binarySearch(int n) {
		int front = 0;
		int back = arr.length-1;
		
		while(front<=back) {
			int middle = (front+back)/2;
			
			if(arr[middle]>n) {
				back = middle-1;
			} else if(arr[middle]<n) {
				front = middle+1;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	
}