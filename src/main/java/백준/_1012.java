import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int test_case = 1; test_case <= T; test_case++) {

			int M = sc.nextInt(); // 가로
			int N = sc.nextInt(); // 세로
			int K = sc.nextInt(); // 배추 수

			int[][] map = new int[N][M]; // 지도
			int[][] loc = new int[K][2]; // 배추 위치
			for (int i = 0; i < K; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();

				map[x][y] = 1;

				loc[i][0] = x;
				loc[i][1] = y;
			}

			boolean[][] used = new boolean[N][M];
			int cnt = 0;

			for (int[] p : loc) {
				if (!used[p[0]][p[1]]) {
					Queue<int[]> q = new LinkedList<>();
					q.add(p);
					used[p[0]][p[1]] = true;
					cnt++;

					while (!q.isEmpty()) {
						int[] pnt = q.poll();

						for (int i = 0; i < 4; i++) {
							int nx = pnt[0] + dx[i];
							int ny = pnt[1] + dy[i];

							if (nx < 0 || nx >= N || ny < 0 || ny >= M)
								continue;

							if (map[nx][ny] == 1 && !used[nx][ny]) {
								q.add(new int[] { nx, ny });
								used[nx][ny] = true;
							}

						}
					}

				}
			}

			System.out.println(cnt);

		}

	}

}
