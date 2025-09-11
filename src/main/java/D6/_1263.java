import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

//			edges : 간선 여부 저장 배열
			int[][] edges = new int[N][N];
			int INF = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (sc.nextInt() == 1)
						edges[i][j] = 1;
					else
						edges[i][j] = INF;
				}
				edges[i][i] = 0;
			}

//			플로이드 - 워셜 알고리즘
			for (int k = 0; k < N; k++) {
				for (int from = 0; from < N; from++) {
					for (int to = 0; to < N; to++) {
						if (edges[from][k] != INF && edges[k][to] != INF)
							edges[from][to] = Math.min(edges[from][to], edges[from][k] + edges[k][to]);
					}
				}
			}

//			한 점에서 다른 모든 점까지의 최소거리 합 구하기 > 합이 가장 작은 것을 min으로
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += edges[i][j];
				}
				min = Math.min(min, sum);
			}

			System.out.println("#" + test_case + " " + min);
		}
	}
}