import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		ArrayList<int[]> case0 = new ArrayList<>(); // 0 빈 칸
		ArrayList<int[]> case2 = new ArrayList<>(); // 2 바이러스
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0)
					case0.add(new int[] { i, j });
				else if (map[i][j] == 2)
					case2.add(new int[] { i, j });
			}
		}

		int max = 0;

//		조합 > 벽 세울 세 곳 선택
		for (int p1 = 0; p1 < case0.size() - 2; p1++) {
			if (map[case0.get(p1)[0]][case0.get(p1)[1]] != 0)
				continue;
			for (int p2 = p1 + 1; p2 < case0.size() - 1; p2++) {
				if (map[case0.get(p2)[0]][case0.get(p2)[1]] != 0)
					continue;
				for (int p3 = p2 + 1; p3 < case0.size(); p3++) {
					if (map[case0.get(p3)[0]][case0.get(p3)[1]] != 0)
						continue;

//					복사본
					int[][] mapCopy = map.clone();
					for (int i = 0; i < map.length; i++) {
						mapCopy[i] = map[i].clone();
					}

//					3곳 벽으로 변경
					mapCopy[case0.get(p1)[0]][case0.get(p1)[1]] = 1;
					mapCopy[case0.get(p2)[0]][case0.get(p2)[1]] = 1;
					mapCopy[case0.get(p3)[0]][case0.get(p3)[1]] = 1;

//					바이러스가 퍼진 모습 확인 > bfs
					boolean[][] used = new boolean[N][M];
					for (int i = 0; i < case2.size(); i++) {
						Queue<int[]> q = new LinkedList<>();
						q.add(case2.get(i));

						while (!q.isEmpty()) {
							int[] p = q.poll();

							for (int j = 0; j < 4; j++) {
								int nx = p[0] + dx[j];
								int ny = p[1] + dy[j];

								if (nx < 0 || nx >= N || ny < 0 || ny >= M)
									continue;

								if (!used[nx][ny] && mapCopy[nx][ny] == 0) {
									used[nx][ny] = true;
									q.add(new int[] { nx, ny });
									mapCopy[nx][ny] = 2;
								}
							}
						}
					}

					int sum = 0;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (mapCopy[i][j] == 0)
								sum++;
						}
					}

					max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);
	}

}
