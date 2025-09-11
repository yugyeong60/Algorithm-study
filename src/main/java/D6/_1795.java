import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int INF = 1_000_000_000; 

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 정점 수
			int M = sc.nextInt(); // 간선 수
			int X = sc.nextInt(); // 시작점

			int[][] times = new int[N + 1][N + 1]; // 정방향 간선 > 돌아갈 때
			int[][] timesR = new int[N + 1][N + 1]; // 역방향 간선 > 갈 때

//			간선 값 저장
			for (int i = 1; i <= N; i++) {
				Arrays.fill(times[i], INF);
				Arrays.fill(timesR[i], INF);
				timesR[i][i] = 0;
				times[i][i] = 0;
			}

			for (int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				int time = sc.nextInt();

				times[from][to] = time;
				timesR[to][from] = time;
			}

//			돌아갈 때 
//			다익스트라 알고리즘
			int[] d = new int[N + 1];
			Arrays.fill(d, INF);
			d[X] = 0;
			boolean[] used = new boolean[N + 1];
			for (int v = 1; v <= N; v++) {
				int min = INF;
				int num = -1;

				for (int i = 1; i <= N; i++) {
					if (!used[i] && d[i] < min) {
						min = d[i];
						num = i;
					}
				}

				used[num] = true;

				for (int i = 1; i <= N; i++) {
					if (!used[i] && d[i] > d[num] + times[num][i]) {
						d[i] = d[num] + times[num][i];
					}
				}
			}

//			갈 때
//			다익스트라 알고리즘
			int[] dR = new int[N + 1];
			Arrays.fill(dR, INF);
			dR[X] = 0;
			used = new boolean[N + 1];
			for (int v = 1; v <= N; v++) {
				int min = INF;
				int num = -1;

				for (int i = 1; i <= N; i++) {
					if (!used[i] && dR[i] < min) {
						min = dR[i];
						num = i;
					}
				}

				used[num] = true;

				for (int i = 1; i <= N; i++) {
					if (!used[i] && dR[i] > dR[num] + timesR[num][i]) {
						dR[i] = dR[num] + timesR[num][i];
					}
				}
			}

//			왕복 값이 가장 큰 것 찾기
			int max = 0;
			for (int i = 1; i <= N; i++) {
				if (i == X)
					continue;
				max = Math.max(max, d[i] + dR[i]);
			}

			System.out.println("#" + test_case + " " + max);

		}
	}
}