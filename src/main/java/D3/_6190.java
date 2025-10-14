import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int[] num = new int[N];
			for (int i = 0; i < N; i++)
				num[i] = sc.nextInt();

			int max = -1;

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {

//					단조 증가수인지 확인
					int n = num[i] * num[j];
					String str = Integer.toString(n);

					boolean isOk = true;
					for (int l = 0; l < str.length() - 1; l++) {
						if (str.charAt(l) > str.charAt(l + 1)) {
							isOk = false;
							break;
						}
					}
					if (isOk)
						max = Math.max(max, n);
				}
			}

			System.out.println("#" + test_case + " " + max);

		}
	}
}