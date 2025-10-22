import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] corr = new int[200]; // 복도
			for (int i = 0; i < N; i++) {
				int idx1 = (sc.nextInt() + 1) / 2 - 1;
				int idx2 = (sc.nextInt() + 1) / 2 - 1;

				if (idx1 < idx2) {
					for (int idx = idx1; idx <= idx2; idx++)
						corr[idx]++;
				} else {
					for (int idx = idx2; idx <= idx1; idx++)
						corr[idx]++;
				}
			}
			Arrays.sort(corr);

			System.out.println("#" + test_case + " " + corr[199]);
		}
	}
}