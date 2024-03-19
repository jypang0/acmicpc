package impl;
import java.io.*;
import java.util.*;

/**
 * @사용알고리즘 back tracking
 * @사용자료구조 
 *  
 * @배운점 테케 짜자.. 네이버는 테케 안준다
 * 
 * @try1 answer init 잘못함 -> 하나도 안움직이는 case 고려하여 처음부터 board 최댓값으로 설정해야함
 * @try2 0일때 가져오고, 다시 그 위치부터 탐색해야함 -> 2 0 4 4 면, 2 4 0 4 -> 2 8 0 0 이 되어야함
 *
 * @Date 2024. 3. 19.
 */
class G2_12100_2048Easy_backTracking {
	static int N, answer = -1;

	public static void main(String[] args) throws IOException {
		N = nextInt();

		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = nextInt();
				answer = Math.max(answer, board[i][j]);
			}
		}
		
		for(int i=0;i<4;i++) {
			run(i, board, 0);
		}
		
		System.out.println(answer);

	}

	static void run(int dir, int[][] boardOrig, int depth) {
		if (depth == 5)
			return;

		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = boardOrig[i][j];
			}
		}

		switch (dir) {
		case 0:
			moveL(board);
			break;
		case 1:
			moveR(board);
			break;
		case 2:
			moveU(board);
			break;
		default:
			moveD(board);
			break;
		}

		for (int i = 0; i < 4; i++) {
			run(i, board, depth + 1);
		}
	}

	static void moveL(int[][] board) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N-1; c++) {
				int curValue = board[r][c];
				for(int next = c+1; next < N; next++) {
					if(board[r][next]!=0) {
						if(curValue==0) {
							board[r][c] = board[r][next];
							board[r][next] = 0;
							c--;
						} else if(board[r][next]==curValue) {
							board[r][c]*=2;
							board[r][next] = 0;
							answer = Math.max(answer, board[r][c]);
						} 
						break;
					}
				}
			}
		}
	}

	static void moveR(int[][] board) {
		for (int r = 0; r < N; r++) {
			for (int c = N-1; c > 0; c--) {
				int curValue = board[r][c];
				for(int next = c-1; next >= 0; next--) {
					if(board[r][next]!=0) {
						if(curValue==0) {
							board[r][c] = board[r][next];
							board[r][next] = 0;
							c++;
						} else if(board[r][next]==curValue) {
							board[r][c]*=2;
							board[r][next] = 0;
							answer = Math.max(answer, board[r][c]);
						} 
						break;
					}
				}
			}
		}
	}
	static void moveD(int[][] board) {
		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N-1; r++) {
				int curValue = board[r][c];
				for(int next = r+1; next < N; next++) {
					if(board[next][c]!=0) {
						if(curValue==0) {
							board[r][c] = board[next][c];
							board[next][c] = 0;
							r--;
						} else if(board[next][c]==curValue) {
							board[r][c]*=2;
							board[next][c] = 0;
							answer = Math.max(answer, board[r][c]);
						} 
						break;
					}
				}
			}
		}
	}
	
	static void moveU(int[][] board) {
		for (int c = 0; c < N; c++) {
			for (int r = N-1; r > 0; r--) {
				int curValue = board[r][c];
				for(int next = r-1; next >= 0; next--) {
					if(board[next][c]!=0) {
						if(curValue==0) {
							board[r][c] = board[next][c];
							board[next][c] = 0;
							r++;
						} else if(board[next][c]==curValue) {
							board[r][c]*=2;
							board[next][c] = 0;
							answer = Math.max(answer, board[r][c]);
						} 
						break;
					}
				}
			}
		}
	}


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}