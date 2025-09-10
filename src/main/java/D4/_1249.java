import java.util.Arrays;
import java.util.Scanner;

class Solution {

//	다익스트라 알고리즘 사용
//	정점 - N x N 칸 모두
//	간선 - 정점의 상, 하, 좌, 우
//	복구 작업 시간  - 간선의 비용 

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
//			복구 작업 시간 저장
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			boolean[][] used = new boolean[N][N];
			int[][] d = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(d[i], Integer.MAX_VALUE);
			}

//			시작점
			d[0][0] = 0;

			for (int t = 0; t < N * N; t++) {
//				최소 복구 시간인 정점 찾기
				int min = Integer.MAX_VALUE;
				int x = -1;
				int y = -1;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!used[i][j] && d[i][j] < min) {
							min = d[i][j];
							x = i;
							y = j;
						}
					}
				}

				used[x][y] = true;

//				찾은 정점을 포함한 복구 시간 갱신
				int[] dx = { -1, 1, 0, 0 };
				int[] dy = { 0, 0, -1, 1 };
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;

					if (!used[nx][ny] && d[nx][ny] > (d[x][y] + map[nx][ny])) {
						d[nx][ny] = d[x][y] + map[nx][ny];
					}
				}

			}

			System.out.println("#" + test_case + " " + d[N - 1][N - 1]);

		}
	}
}