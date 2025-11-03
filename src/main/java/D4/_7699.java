import java.util.Scanner;

class Solution {

	static int R;
	static int C;
	static int[][] map;
	static boolean[][] usedMap;
	static boolean[] usedAlp;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int max;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			R = sc.nextInt();
			C = sc.nextInt();

			map = new int[R][C];
			for (int i = 0; i < R; i++) {
				String str = sc.next();

				for (int j = 0; j < C; j++)
					map[i][j] = str.charAt(j) - 65;
			}

			usedMap = new boolean[R][C]; // 방문 여부
			usedMap[0][0] = true;

			usedAlp = new boolean[26]; // 알파벳 사용 여부
			usedAlp[map[0][0]] = true;

			max = 0;
			dfs(1, 0, 0);

			System.out.println("#" + test_case + " " + max);
		}
	}

	static void dfs(int depth, int x, int y) {

		boolean isOk = false;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;

			if (!usedMap[nx][ny] && !usedAlp[map[nx][ny]]) {
				usedMap[nx][ny] = true;
				usedAlp[map[nx][ny]] = true;

				dfs(depth + 1, nx, ny);

				usedMap[nx][ny] = false;
				usedAlp[map[nx][ny]] = false;

				isOk = true;
			}

		}

		if (!isOk) {
			max = Math.max(max, depth);
			return;
		}

	}
}