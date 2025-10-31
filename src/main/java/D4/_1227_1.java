import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();

			int[][] map = new int[100][100];
			int[] srt = new int[2];

//			값 저장
			for (int i = 0; i < 100; i++) {
				String str = sc.next();
				for (int j = 0; j < 100; j++) {
					map[i][j] = str.charAt(j) - '0';

					if (map[i][j] == 2) { // 시작점 찾기
						srt[0] = i;
						srt[1] = j;
					}
				}
			}

			Queue<int[]> q = new LinkedList<>();
			boolean[][] used = new boolean[100][100]; // 무한 루프 방지
			boolean isOk = false; // 도착 여부

//			시작점
			q.add(srt);
			used[srt[0]][srt[1]] = true;

//			bfs
			while (!q.isEmpty()) {
				int[] pnt = q.poll();

				for (int i = 0; i < 4; i++) { // 상하좌우
					int nx = pnt[0] + dx[i];
					int ny = pnt[1] + dy[i];

					if (map[nx][ny] == 0 && !used[nx][ny]) {
						q.add(new int[] { nx, ny });
						used[nx][ny] = true;
					} else if (map[nx][ny] == 3) {
						isOk = true;
						break;
					}
				}
			}

			int result = 0;
			if (isOk)
				result = 1;
			System.out.println("#" + tc + " " + result);

		}
	}
}