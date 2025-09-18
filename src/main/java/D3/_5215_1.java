import java.util.Scanner;

class Solution {

	static int N;
	static int L;
	static int[] cals;
	static int[] scores;
	static int max;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();

			cals = new int[N];
			scores = new int[N];
			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}

			max = 0;
			dfs(0, 0, 0);

			System.out.println("#" + test_case + " " + max);
		}
	}

	static void dfs(int depth, int cal, int score) {
		if (depth == N) {
			max = Math.max(max, score);
			return;
		}

		if (cal + cals[depth] <= L)
			dfs(depth + 1, cal + cals[depth], score + scores[depth]);
		dfs(depth + 1, cal, score);
	}
}