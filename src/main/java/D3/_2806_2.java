import java.util.Scanner;

class Solution {

	static int N;
	static int sum;
	static int[][] map;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 1, -1 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			sum = 0;
			map = new int[N][N];
			dfs(0);
			
			System.out.println("#" + test_case + " " + sum);
		}
	}

	static void dfs(int x) {
		if (x == N) {
			sum++;
			return;
		}

		for (int y = 0; y < N; y++) {
			if (map[x][y] == 0) {

				for (int i = 0; i < N; i++) {
//					열
					map[i][y]++;

//					대각선
					for (int j = 0; j < 4; j++) {
						int nx = x + i * dx[j];
						int ny = y + i * dy[j];

						if (nx >= 0 && nx < N && ny >= 0 && ny < N)
							map[nx][ny]++;
					}
				}

				dfs(x + 1);

				for (int i = 0; i < N; i++) {
//					열
					map[i][y]--;

//					대각선
					for (int j = 0; j < 4; j++) {
						int nx = x + i * dx[j];
						int ny = y + i * dy[j];

						if (nx >= 0 && nx < N && ny >= 0 && ny < N)
							map[nx][ny]--;
					}
				}

			}
		}

	}
}