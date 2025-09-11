import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

//			값 저장
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int max = 0; // 최대 몇 개의 방을 이동할 수 있는지
			int startP = 0; // 처음에 출발해야 하는 방 번호

//			모든 점에서 bfs
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] { i, j });
					int endP = map[i][j];

					while (!q.isEmpty()) {

						int[] point = q.poll();
						int x = point[0];
						int y = point[1];

						for (int k = 0; k < 4; k++) {

							int nx = x + dx[k];
							int ny = y + dy[k];

							if (nx < 0 || nx >= N || ny < 0 || ny >= N)
								continue;

							if (map[nx][ny] == map[x][y] + 1) {
								q.add(new int[] { nx, ny });
								endP = Math.max(endP, map[nx][ny]);
							}

						}
					}

//					시작 점에 대한 최대 길이
					int length = endP - map[i][j] + 1;

//					전체 점에 대한 최대 길이 비교
					if (length > max || (length == max && map[i][j] < startP)) {
						max = length;
						startP = map[i][j];
					}

				}
			}
			System.out.println("#" + test_case + " " + startP + " " + max);
		}
	}
}