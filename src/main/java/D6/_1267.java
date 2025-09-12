import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			int[][] edges = new int[V + 1][V + 1];
			int[] inN = new int[V + 1];

			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				edges[from][to] = 1;
				inN[to]++;
			}

			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i < V + 1; i++) {
				if (inN[i] == 0) {
					q.add(i);
				}
			}

			StringBuffer sb = new StringBuffer();
			while (!q.isEmpty()) {
				int from = q.poll();
				sb.append(" ").append(from);

				for (int to = 1; to < V + 1; to++) {
					if (edges[from][to] == 1) {
						inN[to]--;

						if (inN[to] == 0) {
							q.add(to);
						}
					}
				}
			}

			System.out.println("#" + test_case + sb);

		}
	}
}