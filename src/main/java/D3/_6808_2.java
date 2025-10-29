import java.util.LinkedList;
import java.util.Scanner;

class Solution {

	static boolean[] used;
	static LinkedList<Integer> order;
	static int[] card1;
	static int[] card2;
	static int win1;
	static int win2;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
//			규영 1, 인영 2
//			규영이  카드
			card1 = new int[9];
			boolean[] isOk = new boolean[19];
			for (int i = 0; i < 9; i++) {
				int n = sc.nextInt();
				card1[i] = n;
				isOk[n] = true;
			}

//			인영이 카드
			card2 = new int[9];
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!isOk[i])
					card2[idx++] = i;
			}

			used = new boolean[9];
			order = new LinkedList<>();
			win1 = 0;
			win2 = 0;
			dfs(0);

			System.out.println("#" + test_case + " " + win1 + " " + win2);

		}
	}

	static void dfs(int depth) {
		if (depth == 9) {

//			점수 계산
			int score1 = 0;
			int score2 = 0;
			for (int i = 0; i < 9; i++) {
				if (card1[i] > card2[order.get(i)])
					score1 += (card1[i] + card2[order.get(i)]);
				else
					score2 += (card1[i] + card2[order.get(i)]);
			}

//			승패 결정
			if (score1 > score2)
				win1++;
			else if (score1 < score2)
				win2++;

			return;
		}

//		인영이 카드 내는 순서 고르기
		for (int i = 0; i < 9; i++) {
			if (!used[i]) {
				used[i] = true;
				order.add(i);

				dfs(depth + 1);

				used[i] = false;
				order.removeLast();
			}
		}
	}
}