import java.util.Scanner;

class Solution {
	static int N;
	static int[][] edges;
	static boolean[] used;
	static int max;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			int M = sc.nextInt();

			edges = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				edges[x][y] = 1;
				edges[y][x] = 1;
			}

			used = new boolean[N + 1];
			max = 0;

			for (int i = 1; i < N + 1; i++) {
				used[i] = true;
				dfs(i, 1);
				used[i] = false;
			}

			System.out.println("#" + test_case + " " + max);
		}
	}

	static void dfs(int v, int depth) {
		boolean end = true;

		for (int i = 1; i < N + 1; i++) {
			if (edges[v][i] == 1 && !used[i]) {
				used[i] = true;
				dfs(i, depth + 1);
				used[i] = false;
				end = false;
			}
		}

		if (end)
			max = Math.max(max, depth);
	}

}