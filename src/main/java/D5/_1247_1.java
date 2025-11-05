import java.util.LinkedList;
import java.util.Scanner;

class Solution {
	static int N;
	static int[] srtP;
	static int[] endP;
	static int[][] nP;
	static LinkedList<Integer> list;
	static int min;
	static boolean[] used;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			srtP = new int[] { sc.nextInt(), sc.nextInt() };
			endP = new int[] { sc.nextInt(), sc.nextInt() };

			nP = new int[N][2];
			for (int i = 0; i < N; i++) {
				nP[i][0] = sc.nextInt();
				nP[i][1] = sc.nextInt();
			}

			list = new LinkedList<>();
			min = Integer.MAX_VALUE;
			used = new boolean[N];
			dfs(0);
			System.out.println("#" + test_case + " " + min);

		}
	}

	static void dfs(int depth) {
		if (depth == N) {
			int sum = 0;
			int[] p = srtP;

			for (int i : list) {
				sum = sum + Math.abs(p[0] - nP[i][0]) + Math.abs(p[1] - nP[i][1]);
				p = nP[i];
			}
			sum = sum + Math.abs(p[0] - endP[0]) + Math.abs(p[1] - endP[1]);

			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				list.addLast(i);
				used[i] = true;

				dfs(depth + 1);

				list.removeLast();
				used[i] = false;
			}

		}

	}

}