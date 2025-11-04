import java.util.LinkedList;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		int N = sc.nextInt();
		int[][] map = new int[N][N];

//		사과가 있는 곳
		int K = sc.nextInt();
		for (int i = 0; i < K; i++)
			map[sc.nextInt() - 1][sc.nextInt() - 1] = 2;

//		방향 전환을 하는 시간, 방향
		int L = sc.nextInt();
		int[] times = new int[L];
		String[] change = new String[L];
		for (int i = 0; i < L; i++) {
			times[i] = sc.nextInt();
			change[i] = sc.next();
		}

		int time = 0; // 걸리는 시간
		int x = 0; // 머리
		int y = 0;
		int dir = 0; // 방향
		map[x][y] = 1;
		int idx = 0;
		LinkedList<int[]> snake = new LinkedList<>();
		snake.add(new int[] { x, y });

		while (true) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				break;

			if (map[nx][ny] == 1)
				break;

			time++;
			x = nx;
			y = ny;
			snake.add(new int[] { x, y });

//			사과 x > 꼬리 둘이기
			if (map[nx][ny] != 2) {
				int[] tail = snake.pollFirst();
				map[tail[0]][tail[1]] = 0;
			}

			map[nx][ny] = 1;

//			방향 바꾸기
			if (idx < times.length && time == times[idx]) {
//				오른쪽 90도 회전
				if (change[idx].equals("D"))
					dir = (dir + 1) % 4;
//				왼쪽 90도 회전
				else
					dir = (dir + 3) % 4;
				idx++;
			}
		}
		System.out.println(time + 1);
	}
}