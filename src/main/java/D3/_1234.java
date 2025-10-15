import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String str = sc.next();

			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++)
				list.add(str.charAt(i) - '0');

			for (int i = 0; i < list.size() - 1; i++) {
				while (i >= 0 && i < list.size() - 1 && list.get(i) == list.get(i + 1)) {
					list.remove(i + 1);
					list.remove(i);
					i--;
				}
			}

			StringBuffer sb = new StringBuffer();
			for (int x : list)
				sb.append(x);

			System.out.println("#" + test_case + " " + sb);
		}
	}
}