package impl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 not.. much..
 * @사용자료구조 string..?
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 2024. 3. 14.
 */
class S5_25206_너의평점은_String {
	public static void main(String[] args) throws Exception {
		double aggScore = 0;
		double aggTotal = 0;
		for (int i = 0; i < 20; i++) {
			next();
			double score = nextDouble();
			String grade = next();
			if (grade.equals("P"))
				continue;

			double gradeAvg = calGradeAvg(grade);
			
			aggScore+=score;
			aggTotal+=(score*gradeAvg);
		}
		
		System.out.println(aggTotal/aggScore);

	}

	static double calGradeAvg(String grade) {
		double result = 4.0-(grade.charAt(0)-'A');
		if(result>0) {
			if(grade.charAt(1)=='+') result+=0.5;
		} else {
			result = 0;
		}
		return result;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String next() throws Exception {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	static double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}
}