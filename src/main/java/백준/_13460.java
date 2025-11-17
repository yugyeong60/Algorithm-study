import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] strP = new int[2][2];
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'R') {
					strP[0][0] = i;
					strP[0][1] = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					strP[1][0] = i;
					strP[1][1] = j;
					map[i][j] = '.';
				}
			}
		}

		int result = -1;
		boolean[][][][] used = new boolean[N][M][N][M];

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { strP[0][0], strP[0][1], strP[1][0], strP[1][1], 0 });
		used[strP[0][0]][strP[0][1]][strP[1][0]][strP[1][1]] = true;

		while (!q.isEmpty()) {
			int[] pnt = q.poll();

			if (pnt[4] >= 10)
				break;

			for (int i = 0; i < 4; i++) {
				int rX = pnt[0];
				int rY = pnt[1];

				int bX = pnt[2];
				int bY = pnt[3];

				// 빨간 이동
				while (true) {
					int nrX = rX + dx[i];
					int nrY = rY + dy[i];
					if (nrX < 0 || nrX >= N || nrY < 0 || nrY >= M)
						break;
					if (map[nrX][nrY] == '#')
						break;
					rX = nrX;
					rY = nrY;
					if (map[rX][rY] == 'O')
						break;
				}

				// 파란 이동
				while (true) {
					int nbX = bX + dx[i];
					int nbY = bY + dy[i];
					if (nbX < 0 || nbX >= N || nbY < 0 || nbY >= M)
						break;
					if (map[nbX][nbY] == '#')
						break;
					bX = nbX;
					bY = nbY;
					if (map[bX][bY] == 'O')
						break;
				}

				// 파란 구슬 구멍
				if (map[bX][bY] == 'O')
					continue;

				// 빨간 구슬 성공
				if (map[rX][rY] == 'O') {
					result = pnt[4] + 1;
					System.out.println(result);
					return;
				}

				// 둘이 같은 칸이면 조정(이동거리 비교)
				if (rX == bX && rY == bY) {
					int rDist = Math.abs(rX - pnt[0]) + Math.abs(rY - pnt[1]);
					int bDist = Math.abs(bX - pnt[2]) + Math.abs(bY - pnt[3]);

					if (rDist > bDist) {
						rX -= dx[i];
						rY -= dy[i];
					} else {
						bX -= dx[i];
						bY -= dy[i];
					}
				}

				// 방문 확인
				if (!used[rX][rY][bX][bY]) {
					used[rX][rY][bX][bY] = true;
					q.add(new int[] { rX, rY, bX, bY, pnt[4] + 1 });
				}

			}
		}

		System.out.println(result);

	}

}
