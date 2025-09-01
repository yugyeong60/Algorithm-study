import java.util.Scanner;

class Solution {
	static int N;
	static int M;
	static int result;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();

			result = 1;
			product(M);
			
			System.out.println("#" + T + " " +  result);

		}
		
	}

	static void product(int M) {
		if (M == 1) {
			result *= N;
			return;
		}

		product(M/2);
		product(M/2);
		if (M%2 != 0) {
			result *= N;
		}
		
	}
}