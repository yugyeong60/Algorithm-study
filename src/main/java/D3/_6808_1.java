import java.util.LinkedList;
import java.util.Scanner;

class Solution {

	static int[] Gyu;
	static int[] In;
	static boolean[] used;
	static LinkedList<Integer> list;
	static int winIn;
	static int winGyu;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

//			규영이가 가진 카드
			Gyu = new int[9];
			used = new boolean[19];
			for (int i = 0; i < 9; i++) {
				int card = sc.nextInt();
				Gyu[i] = card;
				used[card] = true;
			}

//			인영이가 가진 카드
			In = new int[9];
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!used[i])
					In[idx++] = i;
			}

			list = new LinkedList<>();
			used = new boolean[9];
			winIn = 0;
			winGyu = 0;
			dfs(0);

			System.out.println("#" + test_case + " " + winGyu + " " + winIn);

		}
	}

	static void dfs(int depth) {
		if (depth == 9) {
//			게임 결과 계산
			int sumG = 0;
			int sumI = 0;
			for (int i = 0; i < 9; i++) { // 9라운드
				if (Gyu[i] > In[list.get(i)])
					sumG += (Gyu[i] + In[list.get(i)]);
				else
					sumI += (Gyu[i] + In[list.get(i)]);
			}

			if (sumG < sumI)
				winIn++;
			else if (sumG > sumI)
				winGyu++;

			return;
		}

//		인영이가 카드를 낼 순서 > 순열
		for (int i = 0; i < 9; i++) {
			if (!used[i]) {
				used[i] = true;
				list.add(i);
				dfs(depth + 1);
				used[i] = false;
				list.removeLast();
			}
		}

	}

}