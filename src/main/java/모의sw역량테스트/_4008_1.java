import java.util.Scanner;

class Solution {

	static int N;
	static int[] oper;
	static int[] nums;

	static int max;
	static int min;
	static boolean[] used;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();

//			연산자
			oper = new int[N - 1];
			int idx = 0;
			for (int i = 0; i < 4; i++) {
				int cnt = sc.nextInt();
				for (int j = 0; j < cnt; j++)
					oper[idx++] = i;
			}

//			숫자
			nums = new int[N];
			for (int i = 0; i < N; i++)
				nums[i] = sc.nextInt();

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			used = new boolean[N - 1];
			dfs(0, nums[0]);

			System.out.println("#" + test_case + " " + (max - min));
		}
	}

	static void dfs(int depth, int num) {
		if (depth == N - 1) {
			min = Math.min(min, num);
			max = Math.max(max, num);
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (!used[i]) {

                if (i > 0 && oper[i] == oper[i-1] && !used[i-1]) continue;

				int tmp = num;

				if (oper[i] == 0)
					num = num + nums[depth + 1];
				else if (oper[i] == 1)
					num = num - nums[depth + 1];
				else if (oper[i] == 2)
					num = num * nums[depth + 1];
				else
					num = num / nums[depth + 1];

				used[i] = true;

				dfs(depth + 1, num);

				num = tmp;
				used[i] = false;
			}
		}
	}

}