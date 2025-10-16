import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++)
					map[i][j] = str.charAt(j) - '0';
			}

			int sum = 0;
			int p = N / 2;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Math.abs(p - i) + Math.abs(p - j) <= p)
						sum += map[i][j];
				}
			}

			System.out.println("#" + test_case + " " + sum);

		}
	}
}
