import java.util.Scanner;

class Solution {

	static int[] f;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 5;

		f = new int[50];
		f[0] = 0;
		f[1] = 1;

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			System.out.println(fi(N));
		}
	}

	static int fi(int n) {
		if (n > 1 && f[n] == 0)
			f[n] = fi(n - 1) + fi(n - 2);

		return f[n];
	}
}