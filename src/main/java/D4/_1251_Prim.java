import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			int[] x = new int[N];
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
			}

			int[] y = new int[N];
			for (int i = 0; i < N; i++) {
				y[i] = sc.nextInt();
			}

			double E = sc.nextDouble();

//			거리 모두 계산해두기
			long[][] costs = new long[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					long dx = x[i] - x[j];
					long dy = y[i] - y[j];
					long dist = dx * dx + dy * dy;
					costs[i][j] = dist;
					costs[j][i] = dist;
				}
			}

			long[] d = new long[N];
			Arrays.fill(d, Long.MAX_VALUE);
			boolean[] used = new boolean[N];

//			시작점 0
			d[0] = 0;

			for (int i = 0; i < N - 1; i++) { // edge N-1개
//				최소  비용 정점 찾기
				long min = Long.MAX_VALUE;
				int idx = -1;

				for (int j = 0; j < N; j++) {
					if (!used[j] && d[j] < min) {
						idx = j;
						min = d[idx];
					}
				}

				used[idx] = true;

//				선택한 정점을 사용 > 비용 갱신
				for (int j = 0; j < N; j++) {
					if (!used[j] && costs[idx][j] != 0 && d[j] > costs[idx][j]) {
						d[j] = costs[idx][j];
					}
				}
			}

//			모든 비용 합산 + 출력
			long result = 0;
			for (long cost : d) {
				result += cost;
			}
			result = Math.round(result * E);
			System.out.println("#" + test_case + " " + result);

		}
	}
}