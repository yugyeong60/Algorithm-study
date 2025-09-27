1import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt(); // 거슬러 주어야 하는 돈
			int[] money = { 10, 50, 100, 500, 1000, 5000, 10000, 50000 }; // 돈 종류
			int[] cnt = new int[8];

			for (int t = 7; t >= 0; t--) {
				while (N >= money[t]) {
					cnt[7-t]++;
					N -= money[t];
				}
			}

			StringBuffer sb = new StringBuffer();
			for (int m : cnt)
				sb.append(m).append(" ");

			System.out.println("#" + test_case + " ");
			System.out.println(sb);
		}
	}
}