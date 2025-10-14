import java.util.Scanner;

class Solution {
	
	static int N;
	static int[] weight;
	static boolean[] used;
	static int cnt;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			weight = new int[N];
			for (int i = 0; i < N; i++)
				weight[i] = sc.nextInt();

			used = new boolean[N];
			cnt = 0;
			dfs(0, 0, 0);
			System.out.println("#" + test_case + " " + cnt);

		}
	}

	static void dfs(int depth, int left, int right) {
		if (depth == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!used[i]) {
//				오른쪽에 무게추를 올려도 될 때
				if (left >= right + weight[i]) {
//					오른쪽에 두기
					used[i] = true;
					dfs(depth + 1, left, right + weight[i]);
					used[i] = false;

//					왼쪽에 두기
					used[i] = true;
					dfs(depth + 1, left + weight[i], right);
					used[i] = false;
				}
//				오른쪽에 둘 수 없을 때
				else {
					used[i] = true;
					dfs(depth + 1, left + weight[i], right);
					used[i] = false;
				}
			}
		}
	}

}