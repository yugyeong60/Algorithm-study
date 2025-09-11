import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

//			edges 배열 : 간선 저장
			int INF = Integer.MAX_VALUE;
			int[][] edges = new int[N + 1][N + 1];
			for (int i = 1; i < N + 1; i++) {
				Arrays.fill(edges[i], INF);
				edges[i][i] = 0;
			}

			for (int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				edges[from][to] = 1;
			}

//			플로이드 워셜 > 모든 쌍의 최단 경로 찾기
			for (int k = 1; k < N + 1; k++) {
				for (int from = 1; from < N + 1; from++) {
					for (int to = 1; to < N + 1; to++) {
						if (edges[from][k] != INF && edges[k][to] != INF)
							edges[from][to] = Math.min(edges[from][to], edges[from][k] + edges[k][to]);
					}
				}
			}

//			한 점에서 나머지 다른 점들까지 모두 연결이 된다면 (from/to) > 키 순서 확인 가능
			int sum = 0;
			for (int r = 1; r < N + 1; r++) {
				Set<Integer> set = new HashSet<>();
				for (int c = 1; c < N + 1; c++) {
					if (edges[r][c] != INF)
						set.add(c);
					if (edges[c][r] != INF)
						set.add(c);
				}

				if (set.size() == N)
					sum++;
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}