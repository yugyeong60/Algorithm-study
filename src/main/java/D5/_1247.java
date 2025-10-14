import java.util.LinkedList;
import java.util.Scanner;

class Solution {
	static int N;
	static int[] str;
	static int[] end;
	static int[] X;
	static int[] Y;

	static int min;
	static LinkedList<Integer> list;
	static boolean[] used;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			str = new int[] { sc.nextInt(), sc.nextInt() };
			end = new int[] { sc.nextInt(), sc.nextInt() };

			X = new int[N];
			Y = new int[N];
			for (int i = 0; i < N; i++) {
				X[i] = sc.nextInt();
				Y[i] = sc.nextInt();
			}

			list = new LinkedList<>();
			used = new boolean[N];
			min = Integer.MAX_VALUE;
			dfs(0);

			System.out.println("#" + test_case + " " + min);
		}
	}

	static public void dfs(int depth) {
		if (depth == N) {
			int len = Math.abs(X[list.get(0)] - str[0]) + Math.abs(Y[list.get(0)] - str[1]) // 회사 출발
					+ Math.abs(X[list.get(N - 1)] - end[0]) + Math.abs(Y[list.get(N - 1)] - end[1]); // 집 도착

//			고객 방문
			for (int idx = 0; idx < N - 1; idx++) {
				len += Math.abs(X[list.get(idx)] - X[list.get(idx + 1)])
						+ Math.abs(Y[list.get(idx)] - Y[list.get(idx + 1)]);
			}

//			값 비교
			min = Math.min(min, len);
			return;
		}

		for (int idx = 0; idx < N; idx++) {
			if (!used[idx]) {
				list.add(idx);
				used[idx] = true;

				dfs(depth + 1);

				list.removeLast();
				used[idx] = false;
			}
		}
	}
}