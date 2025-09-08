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

//			치즈 값 저장
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int max = 1;
			int[] dr = { 0, 0, 1, -1 };
			int[] dc = { 1, -1, 0, 0 };

//			1일부터 100일까지
			for (int day = 1; day <= 100; day++) {

				boolean[][] used = new boolean[N][N];
				int count = 0;

//				지드 덩어리 찾기
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {

//						bfs로 한 덩어리 찾기
						if (map[r][c] > day && !used[r][c]) {
							count++;
							Queue<int[]> q = new LinkedList<>();
							used[r][c] = true;
							q.add(new int[] { r, c });

							while (!q.isEmpty()) {
								int[] arr = q.poll();

								for (int n = 0; n < 4; n++) {
									int nr = arr[0] + dr[n];
									int nc = arr[1] + dc[n];

									if (nr < 0 || nr >= N || nc < 0 || nc >= N)
										continue;

									if (map[nr][nc] <= day)
										continue;

									if (used[nr][nc])
										continue;

									q.add(new int[] { nr, nc });
									used[nr][nc] = true;

								}
							}

						}

					}
				}
//				덩어리가 많을 때의  덩어리 개수 찾기
				max = Math.max(max, count);
			}

			System.out.println("#" + test_case + " " + max);

		}
	}
}