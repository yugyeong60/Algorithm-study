import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int max = 1;
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}

//			100일
			for (int day = 1; day <= 100; day++) {
//				먹는 경우
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] == day)
							map[i][j] = 0;
					}
				}

//				덩어리 계산
				int cnt = 0;
				boolean[][] used = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {

						if (map[i][j] != 0 && !used[i][j]) {

							Queue<int[]> q = new LinkedList<>();
							q.add(new int[] { i, j });
							used[i][j] = true;
							cnt++;

							while (!q.isEmpty()) {
								int[] pnt = q.poll();
								for (int k = 0; k < 4; k++) {

									int ni = pnt[0] + di[k];
									int nj = pnt[1] + dj[k];

									if (ni < 0 || ni >= N || nj < 0 || nj >= N)
										continue;

									if (map[ni][nj] != 0 && !used[ni][nj]) {
										used[ni][nj] = true;
										q.add(new int[] { ni, nj });
									}
								}
							}
						}
					}
				}

				max = Math.max(max, cnt);

			}

			System.out.println("#" + test_case + " " + max);
		}
	}
}