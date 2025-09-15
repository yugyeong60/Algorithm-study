import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N][M];
		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		boolean[][] used = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		int sum = 0;

		q.add(new int[] { 0, 0, 1 });
		used[0][0] = true;

		while (!q.isEmpty()) {

			int[] p = q.poll();
			int x = p[0];
			int y = p[1];
			int cnt = p[2];

			if (x == N - 1 && y == M - 1) {
				sum = cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (map[nx][ny] == 1 && !used[nx][ny]) {
					q.add(new int[] { nx, ny, cnt + 1 });
					used[nx][ny] = true;
				}
			}

		}

		System.out.println(sum);

	}

}
