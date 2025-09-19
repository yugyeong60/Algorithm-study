import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

	static int N;
	static int K;
	static int[][] map;
	static List<int[]> startList;
	static boolean[][] used;
	static int max;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();

			map = new int[N][N];
			int maxH = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int n = sc.nextInt();

					map[i][j] = n;
					if (n > maxH)
						maxH = n;
				}
			}

			startList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxH)
						startList.add(new int[] { i, j });
				}
			}

			max = 1; // 가장 긴 등산로 길이
			used = new boolean[N][N]; // 방문 여부

//			모든 봉우리에서 돌리기
			for (int[] start : startList) {
				int x = start[0];
				int y = start[1];

				used[x][y] = true;

				dfs(x, y, true, 1);

				used[x][y] = false;

			}

			System.out.println("#" + test_case + " " + max);

		}

	}

	static void dfs(int x, int y, boolean use, int len) {

		boolean Ok = false;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;

			if (used[nx][ny])
				continue;

//			값이 작다면
			if (map[nx][ny] < map[x][y]) {
				used[nx][ny] = true;

				dfs(nx, ny, use, len + 1);

				used[nx][ny] = false;

				Ok = true;
			}
//			값이 크지만, 깍을 수 있고 깎았을 때 값이 작아진다면
			else if (map[nx][ny] >= map[x][y] && use && map[nx][ny] - K < map[x][y]) {
				int tmp = map[nx][ny];
				map[nx][ny] = map[x][y] - 1;
				used[nx][ny] = true;

				dfs(nx, ny, false, len + 1);

				used[nx][ny] = false;
				map[nx][ny] = tmp;

				Ok = true;
			}

		}

//		더이상 움직일 곳이 없다면 >> 등산로의 길이 비교
		if (!Ok) {
			max = Math.max(max, len);
			return;
		}

	}
}