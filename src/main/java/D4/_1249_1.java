import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int test_case = 1; test_case <= T; test_case++) {

//			값 저장
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++)
					map[i][j] = str.charAt(j) - '0';
			}

//			누적 비용 저장 (DP)
			int[][] cost = new int[N][N];
			for (int i = 0; i < N; i++)
				Arrays.fill(cost[i], Integer.MAX_VALUE);
			cost[0][0] = map[0][0];

			LinkedList<int[]> list = new LinkedList<>();
			list.add(new int[] { 0, 0 });

//			bfs
			while (!list.isEmpty()) {
				int[] pnt = list.pollLast();

				for (int i = 0; i < 4; i++) {
					int nx = pnt[0] + dx[i];
					int ny = pnt[1] + dy[i];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;

					if (cost[nx][ny] > cost[pnt[0]][pnt[1]] + map[nx][ny]) {
						cost[nx][ny] = cost[pnt[0]][pnt[1]] + map[nx][ny];
						list.add(new int[] { nx, ny });
					}
				}
			}
			System.out.println("#" + test_case + " " + cost[N - 1][N - 1]);
		}
	}
}
