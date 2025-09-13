import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int[] dx = { 1, -1, 0, 0 };
			int[] dy = { 0, 0, 1, -1 };

			int max = 1;
			for (int k = 1; k <= 100; k++) {

				int cnt = 0;
				boolean[][] used = new boolean[N][N];

				for (int x = 0; x < N; x++) {
					for (int y = 0; y < N; y++) {

						Queue<int[]> q = new LinkedList<>();

						if (map[x][y] > k && !used[x][y]) {
							q.add(new int[] { x, y });
							used[x][y] = true;
							cnt++;
						}

						while (!q.isEmpty()) {

							int[] point = q.poll();

							for (int l = 0; l < 4; l++) {
								int nx = point[0] + dx[l];
								int ny = point[1] + dy[l];

								if (nx < 0 || nx >= N || ny < 0 || ny >= N)
									continue;
								if (used[nx][ny])
									continue;
								if (map[nx][ny] <= k)
									continue;

								q.add(new int[] { nx, ny });
								used[nx][ny] = true;

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