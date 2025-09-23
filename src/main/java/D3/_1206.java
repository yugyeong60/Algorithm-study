import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int[] map = new int[N];
			for (int i = 0; i < N; i++) {
				map[i] = sc.nextInt();
			}

			int sum = 0;
//			모든 빌딩
			for (int i = 2; i < N - 2; i++) {

//				주변 4개 빌딩 중 가장 높은 빌딩 높이 찾기
				int max = 0;
				for (int j = 1; j <= 2; j++) {
					max = Math.max(max, map[i - j]);
					max = Math.max(max, map[i + j]);
				}

//				조망권
				if (max < map[i])
					sum += (map[i] - max);

			}

			System.out.println("#" + test_case + " " + sum);

		}
	}
}