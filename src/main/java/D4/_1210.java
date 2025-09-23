import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int t = sc.nextInt();
			int[][] map = new int[100][100];
			int C = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 2)
						C = j;
				}
			}

			boolean[][] used = new boolean[100][100];
			int R = 99;
			used[R][C] = true;
			while (R > 0) {
//				좌
				if (C - 1 >= 0 && map[R][C - 1] == 1 && !used[R][C - 1])
					used[R][--C] = true;
//				우
				else if (C + 1 < 100 && map[R][C + 1] == 1 && !used[R][C + 1])
					used[R][++C] = true;
//				위
				else if (R - 1 >= 0 && map[R - 1][C] == 1 && !used[R - 1][C])
					used[--R][C] = true;
			}

			System.out.println("#" + t + " " + C);
		}
	}
}