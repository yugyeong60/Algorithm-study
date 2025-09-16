import java.util.Scanner;

class Solution {
	static int N;
	static int K;
	static int cnt;
	static int[] nums;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();

			nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}

			cnt = 0;
			dfs(0, 0);
			System.out.println("#" + test_case + " " + cnt);
		}
	}

	static void dfs(int num, int start) {
		if (num == K) {
			cnt++;
			return;
		}

		for (int i = start; i < N; i++) {
			if (num + nums[i] <= K)
				dfs(num + nums[i], i + 1);
		}

	}
}