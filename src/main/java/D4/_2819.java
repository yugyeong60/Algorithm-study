import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Solution {

	static int[][] map;
	static int[] arr;
	static HashSet<Integer> set;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

//			값 받아오기
			map = new int[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++)
					map[i][j] = sc.nextInt();
			}

			arr = new int[7];
			set = new HashSet<>(); // 만들어지는 7자리 수 저장 공간

//			모든 곳에서 동서남북 탐핵 7번 진행
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					arr[0] = map[x][y];
					dfs(0, x, y);
				}
			}
			System.out.println("#" + test_case + " " + set.size());
		}
	}

	static void dfs(int depth, int x, int y) {
		if (depth == 7) {
			int num = 0;
			for (int i : arr)
				num = num * 10 + i;

			set.add(num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
				continue;

			arr[depth] = map[nx][ny];
			dfs(depth + 1, nx, ny);
		}

	}
}