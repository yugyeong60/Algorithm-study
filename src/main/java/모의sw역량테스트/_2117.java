import java.util.Scanner;

class Solution {

	static int N;
	static int[][] map;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			int M = sc.nextInt();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

//			마름모 크기에 따른 최대 집의 개수 구하기
			int[] homeMax = new int[2 * N];
			for (int k = 1; k < 2 * N; k++) { // 마름모 크기
				for (int x = 0; x < N; x++) { // 행
					for (int y = 0; y < N; y++) { // 열
						homeMax[k] = Math.max(homeMax[k], homeCnt(x, y, k));
					}
				}
			}

//			보안회사의 최대 이익 구하기
			int max = 0;
			for (int k = 1; k < 2 * N; k++) {
				int cost = k * k + (k - 1) * (k - 1);
				int profit = M * homeMax[k];
				if (profit >= cost) {
					max = Math.max(max, homeMax[k]);
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
	}

//	마름모 안에 집이 얼마나 포함되어 있는지 확인
	static int homeCnt(int x, int y, int k) {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (Math.abs(x - i) + Math.abs(y - j) < k && map[i][j] == 1)
					cnt++;
			}
		}

		return cnt;
	}
}