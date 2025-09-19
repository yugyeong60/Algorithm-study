import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 행
			int M = sc.nextInt(); // 열

			int R = sc.nextInt(); // 시작점 행
			int C = sc.nextInt(); // 시작점 열

			int L = sc.nextInt(); // 경과 시간

			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			Queue<int[]> q = new LinkedList<>();
			boolean[][] used = new boolean[N][M];
			int cnt = 0; // 장소의 개수

			// 상, 하, 좌, 우
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };

			// 각 구조물 타입별 이동 가능 방향
			int[][] pipeDir = {
				{},         // 0번 없음
				{0,1,2,3},  // 1번
				{0,1},      // 2번
				{2,3},      // 3번
				{0,3},      // 4번
				{1,3},      // 5번
				{1,2},      // 6번
				{0,2}       // 7번
			};

			// 반대 방향 (상하좌우)
			int[] opposite = {1, 0, 3, 2};

			// 맨홀 뚜껑
			q.add(new int[] { R, C });
			used[R][C] = true;
			cnt++;

			// BFS
			for (int i = 0; i < L - 1; i++) { // 시간만큼
				int size = q.size();
				for (int j = 0; j < size; j++) {
					int[] p = q.poll();
					int x = p[0];
					int y = p[1];

					// 구조물 타입에 따라 탐색 설정
					int type = map[x][y];
					int[] idxs = pipeDir[type];

					for (int idx : idxs) {
						int nx = x + dx[idx];
						int ny = y + dy[idx];

						if (nx < 0 || nx >= N || ny < 0 || ny >= M)
							continue;
						if (used[nx][ny] || map[nx][ny] == 0)
							continue;

						// 다음 칸이 현재 방향과 연결되어 있는지 확인
						boolean canMove = false;
						for (int nextDir : pipeDir[map[nx][ny]]) {
							if (nextDir == opposite[idx]) {
								canMove = true;
								break;
							}
						}
						if (!canMove) continue;

						q.add(new int[] { nx, ny });
						used[nx][ny] = true;
						cnt++;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
