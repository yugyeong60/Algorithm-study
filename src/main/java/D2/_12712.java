package D2;

import java.util.Scanner;

class _12712 {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		int N;
		int M;

		for (int test_case = 1; test_case <= T; test_case++) {

//			값 받아오기
			N = sc.nextInt();
			M = sc.nextInt();

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

//			상 하 좌 우 대각선 경우
			int[] nr = { -1, 1, 0, 0, 1, 1, -1, -1 };
			int[] nc = { 0, 0, -1, 1, 1, -1, 1, -1 };

			int max = 0;
			int sumCross = 0;
			int sumProd = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					sumCross = arr[i][j];
					sumProd = arr[i][j];

					for (int m = 1; m < M; m++) {
						for (int l = 0; l < 4; l++) {
							
//							+ 형태 분사
							if (i + nr[l] * m >= 0 && i + nr[l] * m < N 
									&& j + nc[l] * m >= 0 && j + nc[l] * m < N)
								sumCross += arr[i + nr[l] * m][j + nc[l] * m];

//							x 형태 분사
							if (i + nr[l + 4] * m >= 0 && i + nr[l + 4] * m < N 
									&& j + nc[l + 4] * m >= 0 && j + nc[l + 4] * m < N)
								sumProd += arr[i + nr[l + 4] * m][j + nc[l + 4] * m];
						}
					}

					max = Math.max(max, Math.max(sumCross, sumProd));
				}
			}

			System.out.println("#" + test_case + " " + max);

		}
	}
}