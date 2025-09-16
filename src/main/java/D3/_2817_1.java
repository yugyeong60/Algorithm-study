import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}

			int[] dp = new int[K + 1];
			dp[0] = 1;

			for (int i = 0; i < N; i++) {
				for (int k = K; k >= nums[i]; k--) {
					dp[k] += dp[k - nums[i]];
				}
			}

			System.out.println("#" + test_case + " " + dp[K]);
		}
	}
}