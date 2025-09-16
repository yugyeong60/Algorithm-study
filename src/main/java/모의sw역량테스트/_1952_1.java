import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int oneD = sc.nextInt();
			int oneM = sc.nextInt();
			int treeM = sc.nextInt();
			int oneY = sc.nextInt();

			int[] plan = new int[13];
			for (int i = 1; i < 13; i++) {
				plan[i] = sc.nextInt();
			}

//			동적 프로그래밍 사용
			int[] dp = new int[13];
			for (int i = 1; i < 13; i++) {
//				1일 이용권 vs 1달 이용권
				dp[i] = Math.min(plan[i] * oneD, oneM) + dp[i - 1];

//				3달 이용권
				if (i >= 3)
					dp[i] = Math.min(dp[i], dp[i - 3] + treeM);
			}

//			1년 이용권
			int result = Math.min(dp[12], oneY);
			
			System.out.println("#" + test_case + " " + result);

		}
	}
}