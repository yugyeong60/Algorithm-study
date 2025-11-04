import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

	static int N;
	static int K;
	static int[][] map;
	static int max;
	static boolean[][] used;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			int srtH = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					srtH = Math.max(srtH, map[i][j]);
				}
			}

//			시작점 찾기
			List<int[]> srtP = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == srtH)
						srtP.add(new int[] { i, j });
				}
			}

			max = 0;
			used = new boolean[N][N];
			for (int[] p : srtP) {
				used[p[0]][p[1]] = true;
				dfs(1, p[0], p[1], false);
				used[p[0]][p[1]] = false;
			}

			System.out.println("#" + test_case + " " + max);

		}
	}

	static void dfs(int len, int x, int y, boolean broken) {

		boolean moved = false;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;

//			낮은 곳이 존재한다면
			if (map[x][y] > map[nx][ny] && !used[nx][ny]) {
				used[nx][ny] = true;

				dfs(len + 1, nx, ny, broken);

				used[nx][ny] = false;

				moved = true;
			}

//			지형을 깎는 공사가 가능하다면
//			(조건 : 높은 곳이 존재하고, 지형을 깎지 않았고, 깎으면 더 작아지고, 이미 지나온 곳이 아니라면)
			if (map[x][y] <= map[nx][ny] && broken == false && !used[nx][ny] && map[x][y] > map[nx][ny] - K) {
				used[nx][ny] = true;
				int tmp = map[nx][ny];
				map[nx][ny] = map[x][y] - 1;

				dfs(len + 1, nx, ny, true);

				used[nx][ny] = false;
				map[nx][ny] = tmp;

				moved = true;
			}

		}

//		이동하지 않았다면
		if (!moved) {
			max = Math.max(max, len);
			return;
		}
	}

}