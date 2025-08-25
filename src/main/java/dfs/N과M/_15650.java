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

		dfs(0, 1);

	}

	static void dfs(int depth, int start) {
		if (depth == M) {
			for (int x : arr) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i=start; i<=N; i++) {
			arr.add(i);
			dfs(depth + 1, i + 1);
			
			arr.removeLast();
		}

	}

}