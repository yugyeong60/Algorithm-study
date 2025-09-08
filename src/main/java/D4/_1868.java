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

//			값 저장하기
			char[][] mapChar = new char[N][N];
			for (int i = 0; i < N; i++) {
				String st = sc.next();
				for (int j = 0; j < N; j++) {
					mapChar[i][j] = st.charAt(j);
				}
			}

//			8방향
			int[] dr = { 1, -1, 1, -1, 1, -1, 0, 0 };
			int[] dc = { 1, 1, -1, -1, 0, 0, 1, -1 };

//			8방향 지뢰 수 세서 저장하기
			int[][] mapInt = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					if (mapChar[r][c] == '*') {
						mapInt[r][c] = -1;
						continue;
					}

					int cnt = 0;
					for (int n = 0; n < 8; n++) {
						int nr = r + dr[n];
						int nc = c + dc[n];
						if (nr < 0 || nr >= N || nc < 0 || nc >= N)
							continue;

						if (mapChar[nr][nc] == '*')
							cnt++;
					}
					mapInt[r][c] = cnt;

				}
			}

//			최소 클릭 횟수 세기
			int result = 0;
			boolean[][] used = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

//					0인 곳 클릭해서 연쇄적으로 터트리기
					if (mapInt[r][c] == 0 && !used[r][c]) {
						Queue<int[]> q = new LinkedList<>();

						q.add(new int[] { r, c });
						used[r][c] = true;
						result++;

						while (!q.isEmpty()) {
							int[] arr = q.poll();

							for (int n = 0; n < 8; n++) {
								int nr = arr[0] + dr[n];
								int nc = arr[1] + dc[n];

								if (nr < 0 || nr >= N || nc < 0 || nc >= N)
									continue;

								if (mapInt[nr][nc] == 0 && !used[nr][nc])
									q.add(new int[] { nr, nc });

								used[nr][nc] = true;

							}

						}

					}

				}
			}

//			클릭하지 않은 곳 세기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (mapInt[r][c] > 0 && !used[r][c])
						result++;
				}
			}

			System.out.println("#" + test_case + " " + result);

		}
	}
}