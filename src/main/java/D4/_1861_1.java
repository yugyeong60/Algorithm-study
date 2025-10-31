import java.util.Scanner;

class Solution {
	static int N;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int max;
	static int p;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}

			max = 0; // 최대 이동수
			p = Integer.MAX_VALUE; // 시작 점
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					dfs(1, i, j, map[i][j]);
			}

			System.out.println("#" + test_case + " " + p + " " + max);

		}
	}

	static void dfs(int depth, int x, int y, int srt) {

		boolean isOk = false;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;

			if (map[nx][ny] == map[x][y] + 1) {
				dfs(depth + 1, nx, ny, srt);
				isOk = true;
			}
		}

		if (!isOk) {
			if (max < depth) {
				p = srt;
				max = depth;
				return;
			} else if (max == depth && p > srt) {
				p = srt;
				return;
			}
		}

	}
}