package impl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @사용알고리즘 
 * @사용자료구조 
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 30 Dec 2024
 */
class B5_10430_나머지_BufferedReaderWriter {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tok = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(tok.nextToken());
		int B = Integer.parseInt(tok.nextToken());
		int C = Integer.parseInt(tok.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append((A+B)%C).append("\n").append(((A%C)+(B%C))%C).append("\n").append((A*B)%C).append("\n").append(((A%C)*(B%C))%C);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}