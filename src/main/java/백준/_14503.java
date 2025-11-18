import java.util.Scanner;

public class Main {

//	북 동 남 서 
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		}

		int cnt = 0;
		while (true) {

//			1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if (map[x][y] == 0) {
				map[x][y] = 2;
				cnt++;
			}

//			4방향 청소 여부 확인
			boolean isClean = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (map[nx][ny] == 0) {
					isClean = false;
					break;
				}
			}

//			2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
			if (isClean) {
				int tmp = (d + 2) % 4;
				int nx = x + dx[tmp];
				int ny = y + dy[tmp];

//				-2) 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1)
					break;

//				-1) 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
				x = nx;
				y = ny;
				continue;
			}

//			3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
			else {
				for (int i = 0; i < 4; i++) {
//					-1) 반시계 방향으로 90도 회전
					d = (d + 3) % 4;

//					-2) 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
//					-3) 1번으로 돌아간다.
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1)
						continue;

					if (map[nx][ny] == 0) {
						x = nx;
						y = ny;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
