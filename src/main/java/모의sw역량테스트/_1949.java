import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] used;
	static int[] dx;
	static int[] dy;
	static int start;
	static int max;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();

//			값 받아오기
			map = new int[N][N];
			start = 1; // 가장 높은 봉우리 크기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = sc.nextInt();
					map[i][j] = num;
					start = Math.max(start, num);
				}
			}

//			출발 지점 찾기
			ArrayList<int[]> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == start)
						list.add(new int[] { i, j });
				}
			}

			dx = new int[] { 0, 0, 1, -1 };
			dy = new int[] { 1, -1, 0, 0 };
			max = 1; // 가장 긴 등산로 길이
			used = new boolean[N][N];
			for (int[] point : list) {
				used[point[0]][point[1]] = true;

				dfs(1, false, point[0], point[1]);

				used[point[0]][point[1]] = false;

			}

			System.out.println("#" + test_case + " " + max);
		}
	}

	static void dfs(int depth, boolean use, int x, int y) {

		boolean done = true;

//		상하좌우
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;

			if (used[nx][ny])
				continue;

//			값이 작으면
			if (map[nx][ny] < map[x][y]) {
				used[nx][ny] = true;

				dfs(depth + 1, use, nx, ny);

				used[nx][ny] = false;

				done = false;
			}
//			값이 크지만, 공사 가능하다면
			else if (!use && (map[nx][ny] - K) < map[x][y]) {
				int tmp = map[nx][ny];
				map[nx][ny] = map[x][y] - 1;
				used[nx][ny] = true;

				dfs(depth + 1, true, nx, ny);

				map[nx][ny] = tmp;
				used[nx][ny] = false;

				done = false;
			}
		}

//		갈 수 있는 곳이 아무 곳도 없다면
		if (done) {
			max = Math.max(max, depth);
			return;
		}

	}

}