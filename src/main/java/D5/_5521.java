import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static int N;
	static int M;
	static int[][] graph;
	static int sum;
	static Set<Integer> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

//			진한 관계 > 그래프로 표현
			graph = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();

				graph[n1][n2] = 1;
				graph[n2][n1] = 1;
			}

			set = new HashSet<>();

			for (int i = 2; i <= N; i++) {
//				상원이랑 친한 친구
				if (graph[1][i] == 1) {
					set.add(i);

//					그 친한 친구의 친한 친구
					for (int j = 2; j <= N; j++) {
						if (graph[i][j] == 1) {
							set.add(j);
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + set.size());
		}

	}

}
