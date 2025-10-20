import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			String tmp = sc.next();
			String str = sc.next();

			int cnt = 0;
			for (int i = 0; i <= str.length() - tmp.length(); i++) {
				boolean isOk = true;
				for (int k = 0; k < tmp.length(); k++) {
					if (str.charAt(i + k) != tmp.charAt(k)) {
						isOk = false;
						break;
					}
				}

				if (isOk)
					cnt++;
			}

			System.out.println("#" + tc + " " + cnt);
		}
	}
}