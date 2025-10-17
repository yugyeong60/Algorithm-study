import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++)
					map[i][j] = str.charAt(j);
			}

			String result = "NO";
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					가능 여부 확인
					int[] isOk = new int[4];
					for (int t = 0; t < 5; t++) {
//						행
						if (j + t >= N || map[i][j + t] == '.')
							isOk[0] = 1;
//						열
						if (i + t >= N || map[i + t][j] == '.')
							isOk[1] = 1;

//						대각선 아래
						if ((i + t >= N || j + t >= N) || map[i + t][j + t] == '.')
							isOk[2] = 1;

//						대각선 위
						if ((i - t < 0 || j + t >= N) || map[i - t][j + t] == '.')
							isOk[3] = 1;
					}

					for (int x : isOk) {
						if (x == 0) {
							result = "YES";
							break;
						}
					}

					if (result.equals("YES"))
						break;
				}
				if (result.equals("YES"))
					break;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}