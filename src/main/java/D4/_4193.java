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
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int sX = sc.nextInt(); // 시작 x
			int sY = sc.nextInt(); // 시작 y
			int eX = sc.nextInt(); // 도착 x
			int eY = sc.nextInt(); // 도착 y

			int[] dx = { 0, 0, 1, -1 };
			int[] dy = { 1, -1, 0, 0 };

			boolean[][] used = new boolean[N][N];
			int result = -1;

//			bfs
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { sX, sY, 0 }); // 시작점
			used[sX][sY] = true;

			while (!q.isEmpty()) {
				int[] pnt = q.poll();
				boolean isOk = false;
				for (int i = 0; i < 4; i++) {
					int nx = pnt[0] + dx[i];
					int ny = pnt[1] + dy[i];
					int time = pnt[2];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;

					if (used[nx][ny])
						continue;

					if (nx == eX && ny == eY) {
						result = time + 1;
						isOk = true;
						break;
					}

//					1 : 섬
					if (map[nx][ny] == 1)
						continue;

//					2 : 소용돌이
					else if (map[nx][ny] == 2) {
						if ((time) % 3 == 2) { // 움직이기
							q.add(new int[] { nx, ny, time + 1 });
							used[nx][ny] = true;
						} else { // 자리에서 기다리기
							q.add(new int[] { pnt[0], pnt[1], time + 1 });
						}
					}

//					0 : 아무 것도 아닌 것
					else {
						q.add(new int[] { nx, ny, time + 1 });
						used[nx][ny] = true;
					}
				}
				if (isOk)
					break;
			}

			System.out.println("#" + test_case + " " + result);
		}
	}
}