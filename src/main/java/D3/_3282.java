import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] V = new int[N]; // 부피
			int[] C = new int[N]; // 가치
			for (int i = 0; i < N; i++) {
				V[i] = sc.nextInt();
				C[i] = sc.nextInt();
			}

			int[][] dp = new int[N][K + 1];

			int v = V[0];
			int c = C[0];
			for (int i = v; i < K + 1; i++) {
				dp[0][i] = c;
			}

			for (int i = 1; i < N; i++) {
				v = V[i];
				c = C[i];
				for (int j = 1; j < K + 1; j++) {
					if (j >= v) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - V[i]] + c);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
			System.out.println("#" + test_case + " " + dp[N - 1][K]);
		}
	}
}