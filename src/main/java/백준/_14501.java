import java.util.Scanner;

public class Main {
	static int N;
	static int max;
	static boolean[] used;
	static int[][] plan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		plan = new int[N][2];
		for (int i = 0; i < N; i++) {
			plan[i][0] = sc.nextInt();
			plan[i][1] = sc.nextInt();
		}

		max = 0;
		used = new boolean[N];
		dfs(0, 0);

		System.out.println(max);

	}

	static void dfs(int depth, int sum) {
		if (depth == N) {
			max = Math.max(sum, max);
			return;
		}

//		상담 진행
		if (!used[depth] && plan[depth][0] + depth <= N) {
//			방문 체크
			int t = plan[depth][0];
			for (int i = 0; i < t; i++) {
				used[depth + i] = true;
			}

			dfs(depth + 1, sum + plan[depth][1]);

			for (int i = 0; i < t; i++) {
				used[depth + i] = false;
			}
		}

//		상담 미진행
		dfs(depth + 1, sum);
	}
}
