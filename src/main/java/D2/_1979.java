package D2;

import java.util.Scanner;

class _1979 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int N;
		int K;
		int[][] pz;
		int count;

		for (int test_case = 1; test_case <= T; test_case++) {

//			값 불러오기
			N = sc.nextInt();
			K = sc.nextInt();

			pz = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					pz[i][j] = sc.nextInt();
				}
			}

//			전체를 돌면서 K길이의 단어가 들어갈 공간 탐색
			count = 0;

//			가로
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - K; j++) {

					// 앞 칸이 1이면 스킵 (경계 조건)
					if (j - 1 >= 0 && pz[i][j - 1] == 1)
						continue;

					// 뒤 칸이 1이면 스킵
					if (j + K < N && pz[i][j + K] == 1)
						continue;

					boolean isOkCol = true;
					for (int k = 0; k < K; k++) {
						if (pz[i][j + k] != 1) {
							isOkCol = false;
							break;
						}
					}

					if (isOkCol) {
						count++;
					}
				}
			}

//			세로
			for (int i = 0; i <= N - K; i++) {
				for (int j = 0; j < N; j++) {

					if (i - 1 >= 0 && pz[i - 1][j] == 1)
						continue;

					// 아래 칸이 1이면 스킵
					if (i + K < N && pz[i + K][j] == 1)
						continue;

					boolean isOkRow = true;
					for (int k = 0; k < K; k++) {
						if (pz[i + k][j] != 1) {
							isOkRow = false;
							break;
						}
					}

					if (isOkRow) {
						count++;
					}

				}
			}

			System.out.println("#" + test_case + " " + count);

		}
	}
}