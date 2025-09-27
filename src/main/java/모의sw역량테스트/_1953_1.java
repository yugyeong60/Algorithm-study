import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int oneDay = sc.nextInt();
			int oneMonth = sc.nextInt();
			int treeMonth = sc.nextInt();
			int oneYear = sc.nextInt();

			int[] plan = new int[13];
			for (int i = 1; i <= 12; i++)
				plan[i] = sc.nextInt();

			int[] dp = new int[13];

			for (int i = 1; i <= 12; i++) {
//				1일권
				dp[i] = dp[i - 1] + plan[i] * oneDay;

//				1달권
				dp[i] = Math.min(dp[i], dp[i - 1] + oneMonth);

//				3달권
				if (i >= 3)
					dp[i] = Math.min(dp[i], dp[i - 3] + treeMonth);
				else // 1, 2월
					dp[i] = Math.min(dp[i], treeMonth);

			}

//			1년권
			int result = Math.min(dp[12], oneYear);

			System.out.println("#" + test_case + " " + result);

		}
	}
}