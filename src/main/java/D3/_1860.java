import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			int[] time = new int[N];
			for (int i = 0; i < N; i++) {
				time[i] = sc.nextInt();
			}

			Arrays.sort(time);

			if (time[0] < M) {
				System.out.println("#" + test_case + " " + "Impossible");
				continue;
			}

			int cnt = 0;
			int idx = 0;
			boolean isPossible = true;
			for (int i = 1; i <= time[N - 1]; i++) {
				if (i % M == 0)
					cnt += K;

				if (time[idx] == i) {
					idx++;
					cnt--;
				}

				if (cnt < 0) {
					isPossible = false;
					break;
				}
			}

			if (isPossible)
				System.out.println("#" + test_case + " Possible");
			else
				System.out.println("#" + test_case + " Impossible");

		}
	}
}