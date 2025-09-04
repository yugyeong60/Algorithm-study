import java.util.Scanner;

class Solution {
	static int N;
	static int[][] mat;
	static int[] dx;
	static int[] dy;
	static int startX;
	static int startY;
	static boolean[] used;
	static int max;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();

			mat = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mat[i][j] = sc.nextInt();
				}
			}

			used = new boolean[100 + 1];
//			오른쪽 아래, 왼쪽 아래, 왼쪽 위, 오른쪽 위 순서
			dx = new int[] { 1, 1, -1, -1 };
			dy = new int[] { 1, -1, -1, 1 };
			max = -1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					startX = i;
					startY = j;

					used[mat[startX][startY]] = true;
					dfs(startX, startY, 1, 0);
					used[mat[startX][startY]] = false;
				}
			}

			System.out.println("#" + test_case + " " + max);

		}
	}

	static void dfs(int x, int y, int count, int dir) {
		for (int i = dir; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

//			위치를 벗어나면
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;

//			처음 위치로 돌아오면 >> 성공 !
			if (nx == startX && ny == startY && count >= 4) {
				max = Math.max(max, count);
				continue;
			}

//			이미 방문 했으면
			if (used[mat[nx][ny]])
				continue;

			used[mat[nx][ny]] = true;
			dfs(nx, ny, count + 1, i);
			used[mat[nx][ny]] = false;

		}

	}
}