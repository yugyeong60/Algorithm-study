import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int[] nums = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
				sum += nums[i];
			}

			boolean[] possible = new boolean[sum + 1];
			possible[0] = true;

			for (int n : nums) {
				for (int i = sum; i >= n; i--) {
					if (possible[i - n])
						possible[i] = true;
				}
			}
			
			
			int cnt = 0;
			for (boolean b : possible)
				if (b) cnt++;
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}

}