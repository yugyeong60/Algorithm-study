import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] money = new int[8];
			int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			
			for (int i=0; i<8; i++) {
				while (N >= units[i]) {
					money[i]++;
					N -= units[i];
				}
			}

			System.out.println("#" + test_case);
			for (int x : money)
				System.out.print(x + " ");
			System.out.println();
		}
	}
}