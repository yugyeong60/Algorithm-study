import java.awt.Frame;
import java.util.Scanner;

class Solution {

	static int N;
	static int M;
	static int[] gram;
	static int max;
	static int tmp;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			M = sc.nextInt();

			gram = new int[N];
			for (int i = 0; i < N; i++)
				gram[i] = sc.nextInt();

			max = -1;
			tmp = 0;
			dfs(0, 0);
			System.out.println("#" + test_case + " " + max);
		}
	}

//	순열
	static void dfs(int depth, int start) {
		if (depth == 2) {
			max = Math.max(max, tmp);
			return;
		}

		for (int i = start; i < N; i++) {
			if (tmp + gram[i] <= M) {
				tmp += gram[i];
				dfs(depth + 1, i + 1);
				tmp -= gram[i];
			}
		}
	}
}