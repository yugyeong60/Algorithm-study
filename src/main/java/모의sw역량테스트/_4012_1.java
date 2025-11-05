import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {

	static int N;
	static int[][] map;
	static LinkedList<Integer> idxA;
	static boolean[] used;
	static int min;

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

			idxA = new LinkedList<>();
			used = new boolean[N];
			min = Integer.MAX_VALUE;
			dfs(0, 0);

			System.out.println("#" + test_case + " " + min);
		}
	}

	static void dfs(int depth, int start) {
		if (depth == N / 2) {

//			B의 식재료 
			ArrayList<Integer> idxB = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (!used[i])
					idxB.add(i);
			}

//			맛 구하기
			int sumA = 0;
			int sumB = 0;
			for (int a1 : idxA) {
				for (int a2 : idxA)
					sumA += map[a1][a2];
			}
			for (int b1 : idxB) {
				for (int b2 : idxB)
					sumB += map[b1][b2];
			}

//			차이 구하기
			min = Math.min(min, Math.abs(sumA - sumB));
			return;
		}

//		A의 식재료 구하기
		for (int i = start; i < N; i++) {
			idxA.addLast(i);
			used[i] = true;
			dfs(depth + 1, i + 1);
			idxA.removeLast();
			used[i] = false;
		}

	}
}