import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			char[][] map = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String str = sc.next();
				for (int j = 0; j < 8; j++)
					map[i][j] = str.charAt(j);
			}

			int cnt = 0;
//			가로
			for (int i = 0; i < 8; i++) { // 행
				for (int j = 0; j < 8 - (N - 1); j++) { // 열
					boolean isOk = true;
					for (int k = 0; k < N / 2; k++) {
						if (map[i][j + k] != map[i][j + N - 1 - k]) {
							isOk = false;
							break;
						}
					}
					if (isOk)
						cnt++;
				}
			}

//			세로
			for (int i = 0; i < 8 - (N - 1); i++) { // 행
				for (int j = 0; j < 8; j++) { // 열
					boolean isOk = true;
					for (int k = 0; k < N / 2; k++) {
						if (map[i + k][j] != map[i + N - 1 - k][j]) {
							isOk = false;
							break;
						}
					}
					if (isOk)
						cnt++;
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}
	}
}