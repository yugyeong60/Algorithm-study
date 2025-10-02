import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int[] dxPlus = { 0, 0, 1, -1 };
		int[] dyPlus = { 1, -1, 0, 0 };
		int[] dxProd = { 1, 1, -1, -1 };
		int[] dyProd = { 1, -1, 1, -1 };

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int max = 0;

			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {

					int sumPlus = map[x][y];
					int sumProd = map[x][y];

					for (int i = 1; i < M; i++) { // 세기
						for (int t = 0; t < 4; t++) { // 4방향
//							+
							int nxPlus = x + dxPlus[t] * i;
							int nyPlus = y + dyPlus[t] * i;

							if (nxPlus < 0 || nxPlus >= N || nyPlus < 0 || nyPlus >= N)
								continue;

							sumPlus += map[nxPlus][nyPlus];

//							x
							int nxProd = x + dxProd[t] * i;
							int nyProd = y + dyProd[t] * i;

							if (nxProd < 0 || nxProd >= N || nyProd < 0 || nyProd >= N)
								continue;

							sumProd += map[nxProd][nyProd];
						}

					}
					max = Math.max(max, Math.max(sumPlus, sumProd));
				}
			}

			System.out.println("#" + test_case + " " + max);

		}
	}
}