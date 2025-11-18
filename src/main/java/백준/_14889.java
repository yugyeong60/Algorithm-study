import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] score;
	static int min;
	static LinkedList<Integer> teamS;
	static boolean[] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		score = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				score[i][j] = sc.nextInt();
		}

		min = Integer.MAX_VALUE;

		teamS = new LinkedList<>();
		used = new boolean[N];
		dfs(0, 0);

		System.out.println(min);
	}

	static void dfs(int depth, int start) {
		if (depth == N / 2) {
//			링크팀 찾기
			ArrayList<Integer> teamL = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (!used[i])
					teamL.add(i);
			}

//			각 팀의 능력치 계산
			int sumS = 0;
			int sumL = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					sumS += score[teamS.get(i)][teamS.get(j)];
					sumL += score[teamL.get(i)][teamL.get(j)];
				}
			}

//			능력치 차이의 최솟값 구하기
			min = Math.min(min, Math.abs(sumS - sumL));
			return;
		}

//		조합 > 스타트팀원 찾기
		for (int i = start; i < N; i++) {
			teamS.add(i);
			used[i] = true;

			dfs(depth + 1, i + 1);

			teamS.removeLast();
			used[i] = false;
		}

	}

}
