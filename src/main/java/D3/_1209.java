import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();

			int[][] map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++)
					map[i][j] = sc.nextInt();
			}

			int max = 0;
			int diagSum1 = 0;
			int diagSum2 = 0;
			for (int i = 0; i < 100; i++) {
				int colSum = 0;
				int rowSum = 0;

				for (int j = 0; j < 100; j++) {
//					각 행의 합
					colSum += map[i][j];

//					각 열의 함
					rowSum += map[j][i];
				}

				max = Math.max(max, colSum);
				max = Math.max(max, rowSum);

//				대각선 합
				diagSum1 += map[i][i];
				diagSum2 += map[i][99 - i];
			}
			max = Math.max(max, diagSum1);
			max = Math.max(max, diagSum2);

			System.out.println("#" + tc + " " + max);
		}
	}
}