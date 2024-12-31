package impl;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S3_17413_단어뒤집기2_StringTokenizer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer tok = new StringTokenizer(sc.nextLine(), " <>", true);

		StringBuilder sb = new StringBuilder();
		boolean isTag = false;
		while(tok.hasMoreTokens()) {
			String s = tok.nextToken();
			if(s.equals("<")) {
				isTag = true;
				sb.append(s);
			} else if(s.equals(">")) {
				isTag = false;
				sb.append(s);
			} else if(s.equals(" ")) {
				sb.append(s);
			} else {
				if(isTag) {
					sb.append(s);
				} else {
					for(int i=s.length()-1;i>=0;i--) {
						sb.append(s.charAt(i));
					}
				}
			}
		}
		
		System.out.println(sb);
	}
}