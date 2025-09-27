import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int k = sc.nextInt();

			int[] V = new int[N]; // 부피
			int[] C = new int[N]; // 가치
			for (int i = 0; i < N; i++) {
				V[i] = sc.nextInt();
				C[i] = sc.nextInt();
			}

			int[][] dp = new int[N][k + 1];

//			첫 번째 물건
			for (int j = V[0]; j < k + 1; j++)
				dp[0][j] = C[0];

			for (int i = 1; i < N; i++) {
				for (int j = 1; j < k + 1; j++) {
					if (j - V[i] >= 0 && dp[i - 1][j] < dp[i - 1][j - V[i]] + C[i])
						dp[i][j] = dp[i - 1][j - V[i]] + C[i];
					else
						dp[i][j] = dp[i - 1][j];
				}
			}

			System.out.println("#" + test_case + " " + dp[N - 1][k]);

		}
	}
}