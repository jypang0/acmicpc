package snippets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UsefulCodes {
	/**
	 * 1. Reading inputs
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok;

	/**
	 * @return next String in token
	 * @throws IOException
	 */
	public static String read() throws IOException {
		if (tok == null || !tok.hasMoreElements()) {
			tok = new StringTokenizer(br.readLine());
		}
		return tok.nextToken();
	}

	/**
	 * @return next int in token
	 * @throws IOException
	 */
	public static int readInt() throws IOException {
		if (tok == null || !tok.hasMoreElements()) {
			tok = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(tok.nextToken());
	}

	/**
	 * 2. Bitwise Operations
	 */

	/**
	 * If flag is 1011, it means index 0,1,3 are checked, and 2 is not.
	 * 
	 * case01. idx = 2 (not checked yet)
	 * 	 1 0 1 1
	 * & 0 1 0 0
	 * ----------
	 *   0 0 0 0  => return false
	 * 
	 * case02. idx = 1 (already checked)
	 *   1 0 1 1
	 * & 0 0 1 0
	 * ----------
	 *   0 0 1 0 => return true
	 * 
	 * @param flag bitwise checker, is 1 if index is checked, 0 if not
	 * @param idx index to be checked if checked
	 * @return true if checked, false otherwise
	 */
	public boolean checked(int flag, int idx) {
		return (flag & (1 << idx)) != 0;
	}

	/**
	 * if N = 4
	 * 1<<N = 1 0 0 0 0
	 * (1<<N) -1 = 0 1 1 1 1
	 * 
	 * @param flag bitwise checker, is 1 if index is checked, 0 if not
	 * @param N number of elements to be checked
	 * @return true if all checked, false otherwise
	 */
	public boolean allChecked(int flag, int N) {
		return flag == ((1 << N) - 1);
	}
}
