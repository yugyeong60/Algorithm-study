import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();


		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] treeH = new int[N];

			for (int i = 0; i < N; i++) {
				treeH[i] = sc.nextInt();
			}

			Arrays.sort(treeH);
			int maxH = treeH[N - 1];

			for (int i = 0; i < N; i++) {
				treeH[i] = maxH - treeH[i];
			}

			int oddN = 0;
			int evenN = 0;
			for (int i = 0; i < N; i++) {
				if (treeH[i] % 2 == 1) {
					oddN++;
					treeH[i]--;
				}
				evenN += treeH[i] / 2;
			}
			
			int min = Integer.MIN_VALUE;

			while (oddN < evenN-1) {
				evenN--;
				oddN += 2;
			}
			
			if (oddN > evenN) min = 2*oddN - 1;
			else min = evenN*2;
			
			System.out.println("#" + test_case + " " + min);

		}
	}
}