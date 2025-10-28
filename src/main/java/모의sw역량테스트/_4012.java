import java.util.LinkedList;
import java.util.Scanner;

class Solution {
	static int N;
	static int[][] map;
	static int min;
	static int[] A;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}

			min = Integer.MAX_VALUE;
			dfs(0, new LinkedList<>());
			System.out.println("#" + test_case + " " + min);
		}
	}

	static void dfs(int depth, LinkedList<Integer> A) {
		if (A.size() == N / 2) {
			LinkedList<Integer> B = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				if (!A.contains(i))
					B.add(i);
			}
			int sumA = 0;
			int sumB = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					sumA += map[A.get(i)][A.get(j)];
					sumB += map[B.get(i)][B.get(j)];
				}
			}

			min = Math.min(min, Math.abs(sumA - sumB));
			return;
		}
		
		if (depth == N)
			return;

		dfs(depth + 1, A);

		A.add(depth);
		dfs(depth + 1, A);
		A.removeLast();

	}
}