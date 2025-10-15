import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int p = sc.nextInt();
			int q = sc.nextInt();

//			& 연산
			int pY = 1;
			while (p > pY * (pY - 1) / 2)
				pY++;
			int pX = p - (pY * (pY - 1) / 2 + 1) + 1;

			int qY = 1;
			while (q > qY * (qY - 1) / 2)
				qY++;
			int qX = q - (qY * (qY - 1) / 2 + 1) + 1;

//			합연산
			int y = pY + qY;
			int x = pX + qX;

//			# 연산
			int num = y * (y - 1) / 2 + (x - 1);

			System.out.println("#" + test_case + " " + num);

		}
	}
}