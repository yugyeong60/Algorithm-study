import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			int t = sc.nextInt();
			boolean[][] used = new boolean[100][100];
			
			int[][] map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String str = sc.next();

				for (int j = 0; j < 100; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			Queue<int[]> q = new LinkedList<>();
			
//			시작점
			q.add(new int[] { 1, 1 });
			used[1][1] = true;
			
			int result = 0;

			while (!q.isEmpty()) {
				int[] point = q.poll();
				int x = point[0];
				int y = point[1];
				boolean isOk = false;

				int[] dx = { 1, -1, 0, 0 };
				int[] dy = { 0, 0, 1, -1 };
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

//					도착점 도착
					if (map[nx][ny] == 3) {
						isOk = true;
						break;
					}

//					bfs
					if (!used[nx][ny] && map[nx][ny] == 0) {
						q.add(new int[] { nx, ny });
						used[nx][ny] = true;
					}

				}

				if (isOk) {
					result = 1;
					break;
				} 
			}

			System.out.println("#" + t + " " + result);

		}
	}
}