package D2;

import java.util.Scanner;
import java.util.Stack;

class _1926 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 1; i <= N; i++) {

//			숫자를 1자리수로 잘게 자르기
			Stack<Integer> stack = new Stack<>();

			int tmp = i;

			if (tmp >= 100) {
				stack.add(i % 10);
				tmp = tmp / 10;
			}

			if (tmp >= 10) {
				stack.add(i % 10);
				tmp = tmp / 10;
			}

			stack.add(tmp);

//			3, 6, 9 판별
			boolean isOk = false;
			while (!stack.isEmpty()) {
				int num = stack.pop();
				if (num == 3 || num == 6 || num == 9) {
					isOk = true;
					stringBuilder.append("-");
				}
			}

			if (!isOk)
				stringBuilder.append(i);

			stringBuilder.append(" ");

		}

		System.out.println(stringBuilder);
	}
}