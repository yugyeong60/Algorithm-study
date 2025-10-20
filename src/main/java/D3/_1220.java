import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}

//			1) 테이블 아래로 떨어지는 경우
			for (int j = 0; j < N; j++) { // 열
//				맨 위가 S극 > 없애기
				for (int i = 0; i < N; i++) {
					if (map[i][j] == 1)
						break;
					else if (map[i][j] == 2)
						map[i][j] = 0;
				}

//				맨 아래가 N극 > 없애기
				for (int i = N - 1; i >= 0; i--) {
					if (map[i][j] == 2)
						break;
					else if (map[i][j] == 1)
						map[i][j] = 0;
				}
			}

//			2) 교착상태 수 세기
			int cnt = 0;
			ArrayList<Integer> list;
			for (int j = 0; j < N; j++) { // 열
				list = new ArrayList<>();
				for (int i = 0; i < N; i++) {
					if (map[i][j] != 0)
						list.add(map[i][j]);
				}

				int idx = 0;
				while (idx < list.size() - 1) {
					if (list.get(idx) == 1 && list.get(idx + 1) == 2) {
						cnt++;
						idx += 2;
					} else
						idx++;
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}
	}
}