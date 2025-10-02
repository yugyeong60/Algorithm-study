import java.util.Scanner;

class Solution {
	static int[] H;
	static int N;
	static int B;
	static int min;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			B = sc.nextInt();

			H = new int[N];
			for (int i = 0; i < N; i++)
				H[i] = sc.nextInt();

			min = Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.println("#" + test_case + " " + (min - B));

		}
	}

	public static void dfs(int depth, int sum) {

		if (depth == N) { // 깊이까지 다 도달했을 때
			if (sum >= B && min > sum)
				min = sum;
			return;
		}

		if (sum >= B) {
			if (min > sum) {
				min = sum;
			}
			return;
		}

		dfs(depth + 1, sum + H[depth]);

		dfs(depth + 1, sum);

	}
}