import java.util.Scanner;

class Solution {
	static int M;
	static int C;
	static int[] arr;
	static int max;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 벌통 크기
			M = sc.nextInt(); // 채취 수
			C = sc.nextInt(); // 최대 양

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}

			boolean[][] used; // 첫 번째 일꾼 채취 여부
			int result = 0; // 최종 출력값
			for (int r1 = 0; r1 < N; r1++) {
				for (int c1 = 0; c1 <= N - M; c1++) {

//					첫 번째 일꾼의 최대 수익
					arr = new int[M];
					max = 0;
					used = new boolean[N][N];
					for (int m = 0; m < M; m++) {
						used[r1][c1 + m] = true;
						arr[m] = map[r1][c1 + m];
					}
					dfs(0, 0, 0);
					int sumMax1 = max;

					for (int r2 = r1; r2 < N; r2++) {
						for (int c2 = 0; c2 <= N - M; c2++) {

//							겹치지 X
							if (r1 == r2 && c2 < c1 + M && c1 < c2 + M)
								continue;

//							두 번쨰 일꿀의 최대 수익
							arr = new int[M];
							max = 0;
							for (int m = 0; m < M; m++) {
								arr[m] = map[r2][c2 + m];
							}
							dfs(0, 0, 0);
							int sumMax2 = max;

//							비교
							result = Math.max(result, sumMax1 + sumMax2);
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

	static void dfs(int idx, int sum, int sumSquare) {
		if (idx == M) {
			max = Math.max(max, sumSquare);
			return;
		}

		if (sum + arr[idx] <= C)
			dfs(idx + 1, sum + arr[idx], sumSquare + arr[idx] * arr[idx]);

		dfs(idx + 1, sum, sumSquare);

	}
}