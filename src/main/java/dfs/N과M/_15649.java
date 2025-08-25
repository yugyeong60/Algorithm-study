import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static boolean[] used;
	static LinkedList<Integer> arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		used = new boolean[N + 1];
		arr = new LinkedList<>();

		dfs(0);

	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i < N + 1; i++) {
			if (!used[i]) {
				arr.add(i);
				used[i] = true;

				dfs(depth + 1);

				used[i] = false;
				arr.removeLast(); // 백트래킹 (마지막 원소 제거)
			}
		}

	}
}