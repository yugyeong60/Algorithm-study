import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
		int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			boolean[][] used = new boolean[N][N];
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '*')
						used[i][j] = true;
				}
			}

			int cnt = 0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) { // 모든 위치를 돌면서

//					0인 곳 찾기
					if (used[x][y])
						continue;

					boolean isOk = true;
					for (int i = 0; i < 8; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];

						if (nx < 0 || nx >= N || ny < 0 || ny >= N)
							continue;

						if (map[nx][ny] == '*') {
							isOk = false;
							break;
						}
					}

//					bfs
					if (isOk) {
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[] { x, y });
						used[x][y] = true;
						cnt++;

						while (!q.isEmpty()) {

							int[] pnt = q.poll();

							isOk = true;
							for (int i = 0; i < 8; i++) {
								int nx = pnt[0] + dx[i];
								int ny = pnt[1] + dy[i];

								if (nx < 0 || nx >= N || ny < 0 || ny >= N)
									continue;

								if (map[nx][ny] == '*') {
									isOk = false;
									break;
								}
							}

							if (isOk) {
								for (int i = 0; i < 8; i++) {
									int nx = pnt[0] + dx[i];
									int ny = pnt[1] + dy[i];

									if (nx < 0 || nx >= N || ny < 0 || ny >= N)
										continue;

									if (!used[nx][ny]) {
										q.add(new int[] { nx, ny });
										used[nx][ny] = true;
									}
								}
							}

						}
					}
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (!used[i][j]) cnt++;
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);

		}
	}
}