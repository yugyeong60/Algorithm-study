import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

//			1 : Alice, 0: Bob턴
			int AorB = 1;

			while (true) {
				boolean isOk = false;
				for (int i = N - 1; i > 1; i--) {
//					약수 존재
					if (N % i == 0) {
						AorB = (AorB + 1) % 2; // 턴 바꾸기
						N -= i;
						isOk = true;
						break;

					}
				}
				if (!isOk)
					break;
			}

//			턴을 넘기지 못했음 > 겼음
			if (AorB == 1)
				System.out.println("B");
			else
				System.out.println("A");
		}
	}
}