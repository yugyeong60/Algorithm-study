import java.util.Scanner;

class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int INF = Integer.MAX_VALUE;

			int[][] edges = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int n = sc.nextInt();
					if (n == 0)
						edges[i][j] = INF;
					else
						edges[i][j] = n;
				}
				edges[i][i] = 0;
			}

//			플로이드 워셜
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (edges[i][k] != INF && edges[k][j] != INF)
							edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
					}
				}
			}

//			각 노드의 cc 구하고 그중 최소 구하기
			int cc = INF;
			for (int i = 0; i < N; i++) {

				int sum = 0;
				for (int j = 0; j < N; j++)
					sum += edges[i][j];

				if (cc > sum)
					cc = sum;
			}

			System.out.println("#" + test_case + " " + cc);
		}
	}
}