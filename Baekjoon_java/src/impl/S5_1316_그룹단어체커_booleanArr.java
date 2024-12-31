package impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @사용알고리즘 
 * @사용자료구조 binary array
 *  
 * @배운점
 * 
 * @try1
 *
 * @Date 30 Dec 2024
 */
public class S5_1316_그룹단어체커_booleanArr {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		while(num-->0) {
			char[] charArray = br.readLine().toCharArray();
			if(charArray.length==1) {
				ans++;
				continue;
			}
			int cur = charArray[0];
			boolean[] check = new boolean['z'+1];
			check[cur] = true;
			for(int i=1;i<charArray.length;i++){
				if(charArray[i]!=cur) {
					cur = charArray[i];
					if(check[cur])
						break;
					else
						check[cur]=true;
				}
				if(i==charArray.length-1) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
}