package impl;
import java.util.*;
import java.io.*;

/**
 * @사용알고리즘 back tracking
 * @사용자료구조 
 *  
 * @배운점 -1 이면 +(N-1)%N 하면됨
 * 
 * @try1
 *
 * @Date 2024. 3. 21.
 */
class G4_3190_뱀_backTracking {
	static int N, d = 0, time = 0;
	static int[][] map;
	static LinkedList<int[]> snake = new LinkedList<>();
	static Queue<int[]> changeDir = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		N = nextInt();
		map = new int[N][N];

		int k = nextInt();
		while (k-- > 0) {
			int r = nextInt() - 1;
			int c = nextInt() - 1;
			map[r][c] = 1;
		}

		int l = nextInt();
		while(l-->0) {
			int x = nextInt();
			int c = nextChar();
			changeDir.add(new int[] {x,c});
		}
		
		snake.add(new int[] {0,0});
		map[0][0] = -1;
		
		move();
		
		System.out.println(time);
	}
	
	static int[][] DRDC = {{0,1},{1,0},{0,-1},{-1,0}};
	static void move() {
		time++;

		int[] head = snake.peekFirst();
		
		int nextR = head[0]+DRDC[d][0];
		int nextC = head[1]+DRDC[d][1];
		
		if(nextR<0 || nextC<0 || nextR>=N || nextC>=N || map[nextR][nextC]==-1) {
			return;
		}
		
		if(map[nextR][nextC]==0) { // no apple - move tail
			int[] tail = snake.pollLast();
			map[tail[0]][tail[1]] = 0;
		}
		
		map[nextR][nextC]=-1;
		snake.addFirst(new int[] {nextR,nextC});
		
		if(!changeDir.isEmpty() && time==changeDir.peek()[0]) {
			int[] ld = changeDir.poll();
			if(ld[1]=='D') {
				d = (d+1)%4;
			} else {
				d = (d+3)%4;
			}
		}
		
		move();
	}
	
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	static char nextChar() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return st.nextToken().charAt(0);
	}
}