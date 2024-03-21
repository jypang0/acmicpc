package impl;
import java.util.*;
import java.io.*;

/**
 * @사용알고리즘 back tracking
 * @사용자료구조 
 *  
 * @배운점 오.. 근데 이건 기억으로 풀었다.. ㅋㅋㅋㅋ 외우고 있다는것 만으로 좋은건가
 * 
 * @try1
 *
 * @Date 2024. 3. 21.
 */
class G4_14500_테트로미노_backTracking {
	
	static int N, M, answer = 0;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int temp = board[i][j];
				board[i][j]=0;
				recur(i,j,1,temp);
				board[i][j]=temp;
			}
		}
		
		System.out.println(answer);
	}
	
	static int[][] DRDC = {{1,0},{0,-1},{0,1}};
	static void recur(int row, int col, int depth, int total) {
		if(depth==4) {
			answer = Math.max(answer, total);
			return;
		}
		
		for(int i=0;i<DRDC.length;i++) {
			int newRow = row+DRDC[i][0];
			int newCol = col+DRDC[i][1];
			
			if(!isValid(newRow, newCol))
				continue;
			
			if(board[newRow][newCol]==0)
				continue;
			
			int temp = board[newRow][newCol];
			board[newRow][newCol]= 0;
			recur(newRow, newCol, depth+1, total+temp);
			if(depth==2) {
				recur(row, col, depth+1, total+temp);
			}
			board[newRow][newCol]= temp;
		}
	}
	
	static boolean isValid(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
}