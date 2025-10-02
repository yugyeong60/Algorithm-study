import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
//				90
				for (int j = N - 1; j >= 0; j--) // 행
					sb.append(map[j][i]);

				sb.append(" ");

//				180
				for (int j = N - 1; j >= 0; j--) // 열
					sb.append(map[N - 1 - i][j]);

				sb.append(" ");

//				270
				for (int j = 0; j < N; j++) // 행
					sb.append(map[j][N - 1 - i]);

				sb.append("\n");
			}

			System.out.println("#" + test_case);
			System.out.print(sb);

		}
	}
}