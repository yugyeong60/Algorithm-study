import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		StringBuffer sb = new StringBuffer();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			String st = Integer.toBinaryString(M);
			boolean isOk = true;

			for (int i = 0; i < N; i++) {
			    // 뒤에서 i번째 비트
			    int idx = st.length() - 1 - i;
			    if (idx < 0 || st.charAt(idx) == '0') {
			        sb.append("#").append(test_case).append(" ").append("OFF").append("\n");
			        isOk = false;
			        break;
			    }
			}

			if (isOk)
				sb.append("#").append(test_case).append(" ").append("ON").append("\n");
		}

		System.out.println(sb);
	}
}