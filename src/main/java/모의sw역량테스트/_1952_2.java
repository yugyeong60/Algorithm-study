import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int day = sc.nextInt();
			int month = sc.nextInt();
			int month3 = sc.nextInt();
			int year = sc.nextInt();

			int[] plan = new int[13];
			for (int i = 1; i < 13; i++)
				plan[i] = sc.nextInt();

			int[] dp = new int[13];
			for (int i = 1; i < 13; i++) {
//				1일	
				dp[i] = dp[i - 1] + plan[i] * day;

//				1달
				dp[i] = Math.min(dp[i], dp[i - 1] + month);

//				3달
				if (i == 1) {
					dp[i] = Math.min(dp[i], month3);
				} else if (i == 2)
					dp[i] = Math.min(dp[i], month3);
				else
					dp[i] = Math.min(dp[i], dp[i - 3] + month3);
			}

			int min = Math.min(dp[12], year);
			System.out.println("#" + test_case + " " + min);

		}
	}
}