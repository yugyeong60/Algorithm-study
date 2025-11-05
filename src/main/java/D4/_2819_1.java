import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
	static int[][] map;
	static HashSet<Integer> set;
	static LinkedList<Integer> list;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			map = new int[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++)
					map[i][j] = sc.nextInt();
			}

			set = new HashSet<>();
			list = new LinkedList<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++)
					dfs(0, i, j);
			}
			System.out.println("#" + test_case + " " + set.size());
		}
	}

	static void dfs(int depth, int x, int y) {
		if (depth == 7) {
			int num = 0;
			for (int n : list)
				num = num * 10 + n;

			set.add(num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
				continue;

			list.addLast(map[nx][ny]);
			dfs(depth + 1, nx, ny);
			list.removeLast();
		}
	}

}