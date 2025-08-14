package D3

import java.util.Scanner;

class _1289 {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			String value = sc.next();
			int size = value.length();

//			새롭게 바꿀 메모리 배열
			int[] newM = new int[size];
			int count = 0;

			for (int i = 0; i < size; i++) {
				int idx = i;

				if (value.charAt(i) == '1' && newM[i] == 0) {
					while (idx < size) {
						newM[idx++] = 1;
					}
					count++;

				} else if (value.charAt(i) == '0' && newM[i] == 1) {
					while (idx < size) {
						newM[idx++] = 0;
					}
					count++;
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}

}