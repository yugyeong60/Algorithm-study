import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {

	static int[] GY;
	static int[] IY;

	static boolean[] used;
	static List<int[]> caseI;
	static int[] arr;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

//			규영이가 가지는 카드 입력 받기
			GY = new int[9];
			for (int i = 0; i < 9; i++) {
				GY[i] = sc.nextInt();
			}

			Arrays.sort(GY);

//			인영이가 가지는 카드 규하기
			used = new boolean[19];
			for (int i = 0; i < 9; i++) {
				used[GY[i]] = true;
			}

			IY = new int[9];
			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if (!used[i])
					IY[idx++] = i;
			}

//			인영이가 내는 카드의 순서 9! 경우 계산
			used = new boolean[9];
			caseI = new ArrayList<>();
			arr = new int[9];
			dfs(0);

//			규영이가 이기/지는 경우 계산
			int winN = 0;
			int looseN = 0;
			for (int[] array : caseI) {
				int point = 0;
				for (int i = 0; i < 9; i++) {
					if (GY[i] > IY[array[i]])
						point += GY[i] + IY[array[i]];
					else
						point -= (GY[i] + IY[array[i]]);
				}

				if (point > 0)
					winN++;
				else if (point < 0)
					looseN++;
			}

			System.out.println("#" + test_case + " " + winN + " " + looseN);
		}
	}

	static void dfs(int depth) {
		if (depth == 9) {
			caseI.add(arr.clone());
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (used[i])
				continue;

			used[i] = true;
			arr[depth] = i;

			dfs(depth + 1);

			used[i] = false;
		}
	}

}