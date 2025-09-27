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

//			치즈 값 받아오기
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int max = 1;
			int[] dx = { 0, 0, 1, -1 };
			int[] dy = { 1, -1, 0, 0 };

			for (int day = 1; day <= 100; day++) { // 100일 동안
				
				int cnt = 0; // 덩어리 수
				boolean[][] used = new boolean[N][N]; // 방문 여부

//				모든 위치를 돌면서 bfs
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {

						if (!used[i][j] && map[i][j] > day) {

							cnt++;
							Queue<int[]> q = new LinkedList<>();
							q.add(new int[] { i, j });
							used[i][j] = true;

							while (!q.isEmpty()) {
								int[] p = q.poll();

								for (int t = 0; t < 4; t++) {
									int nx = p[0] + dx[t];
									int ny = p[1] + dy[t];

									if (nx < 0 || nx >= N || ny < 0 || ny >= N)
										continue;

									if (!used[nx][ny] && map[nx][ny] > day) {
										q.add(new int[] { nx, ny });
										used[nx][ny] = true;
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