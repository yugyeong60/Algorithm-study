import java.util.Scanner;

class Solution {

	static int N;
	static int[] weight;
	static int cnt;
	static boolean[] used;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			weight = new int[N];
			for (int i = 0; i < N; i++)
				weight[i] = sc.nextInt();

			cnt = 0;
			used = new boolean[N];
			dfs(0, 0, 0);
			System.out.println("#" + test_case + " " + cnt);

		}
	}

	static void dfs(int depth, int left, int right) {
		if (depth == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!used[i]) {

				if (left >= right + weight[i]) {
					used[i] = true;
					dfs(depth + 1, left, right + weight[i]);
					used[i] = false;
				}

				used[i] = true;
				dfs(depth + 1, left + weight[i], right);
				used[i] = false;

			}
		}

	}
}