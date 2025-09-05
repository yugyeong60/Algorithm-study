import java.util.LinkedList;
import java.util.Scanner;

class Solution {

	static int N;
	static LinkedList<Integer> list;
	static int sum;
	static int max;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();

			list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}

			sum = 0;
			max = 0;
			dfs(N);

			System.out.println("#" + test_case + " " + max);
		}
	}

	static void dfs(int num) {
		if (num == 0) {
			max = Math.max(sum, max);
		}

		for (int i = 0; i < num; i++) {

			if (list.size() == 1)
				sum += list.get(i);
			else if (i == 0)
				sum += list.get(i + 1);
			else if (i == num - 1)
				sum += list.get(i - 1);
			else
				sum += (list.get(i - 1) * list.get(i + 1));

			int value = list.remove(i);

			dfs(num - 1);

			list.add(i, value);

			if (list.size() == 1)
				sum -= list.get(i);
			else if (i == 0)
				sum -= list.get(i + 1);
			else if (i == num - 1)
				sum -= list.get(i - 1);
			else
				sum -= (list.get(i - 1) * list.get(i + 1));

		}

	}

}
