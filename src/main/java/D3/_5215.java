import java.util.Scanner;

class Solution {
	static int N;
	static int L;
	static int[][] arr;
	static int max;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();

			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}

			max = 0;
			dfs(0, 0, 0);

			System.out.println("#" + test_case + " " + max);

		}
	}

	static void dfs(int scoreSum, int calSunm, int idx) {
		if (calSunm > L) {
			return;
		}

		if (idx == N) {
			max = Math.max(scoreSum, max);
			return;
		}

//		재료 선택
		dfs(scoreSum + arr[idx][0], calSunm + arr[idx][1], idx + 1);

//			재료 미선택
		dfs(scoreSum, calSunm, idx + 1);

	}
}