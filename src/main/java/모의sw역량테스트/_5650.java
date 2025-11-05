import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int[][][] hole = new int[6][2][2];
			for (int i = 0; i < 6; i++)
				hole[i][0][0] = -1;
			int max = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();

					if (map[i][j] >= 6 && map[i][j] <= 10) {
						int num = map[i][j] - 6;
						if (hole[num][0][0] == -1) {
							hole[num][0][0] = i;
							hole[num][0][1] = j;
						} else {
							hole[num][1][0] = i;
							hole[num][1][1] = j;
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					시작 위치
					if (map[i][j] != 0)
						continue;

					for (int d = 0; d < 4; d++) {

						int x = i;
						int y = j;
						int cnt = 0;
						int dir = d;

						while (true) {
							int nx = x + dx[dir];
							int ny = y + dy[dir];

//								벽에 부딪힐 때
							if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
								if (dir == 0)
									dir = 1;
								else if (dir == 1)
									dir = 0;
								else if (dir == 2)
									dir = 3;
								else if (dir == 3)
									dir = 2;

								cnt++;
								x = nx;
								y = ny;
								continue;
							}

//								블랙홀 || 원래 자리
							if (map[nx][ny] == -1 || (nx == i && ny == j)) {
								max = Math.max(max, cnt);
								break;
							}

//								블록일 때
							if (map[nx][ny] >= 1 && map[nx][ny] <= 5) {
								if (map[nx][ny] == 1) {
									if (dir == 0)
										dir = 1;
									else if (dir == 1)
										dir = 2;
									else if (dir == 2)
										dir = 3;
									else if (dir == 3)
										dir = 0;

								} else if (map[nx][ny] == 2) {
									if (dir == 0)
										dir = 1;
									else if (dir == 1)
										dir = 3;
									else if (dir == 2)
										dir = 0;
									else if (dir == 3)
										dir = 2;

								} else if (map[nx][ny] == 3) {
									if (dir == 0)
										dir = 3;
									else if (dir == 1)
										dir = 0;
									else if (dir == 2)
										dir = 1;
									else if (dir == 3)
										dir = 2;

								} else if (map[nx][ny] == 4) {
									if (dir == 0)
										dir = 2;
									else if (dir == 1)
										dir = 0;
									else if (dir == 2)
										dir = 3;
									else if (dir == 3)
										dir = 1;

								} else if (map[nx][ny] == 5) {
									if (dir == 0)
										dir = 1;
									else if (dir == 1)
										dir = 0;
									else if (dir == 2)
										dir = 3;
									else if (dir == 3)
										dir = 2;
								}

								cnt++;
								x = nx;
								y = ny;
								continue;
							}

//								원홀일 때
							if (map[nx][ny] >= 6 && map[nx][ny] <= 10) {
								int n = map[nx][ny] - 6;

								if (hole[n][0][0] == nx && hole[n][0][1] == ny) {
									nx = hole[n][1][0];
									ny = hole[n][1][1];
								} else {
									nx = hole[n][0][0];
									ny = hole[n][0][1];
								}
								x = nx;
								y = ny;
								continue;
							}

							x = nx;
							y = ny;
						}

					}
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
	}
}
