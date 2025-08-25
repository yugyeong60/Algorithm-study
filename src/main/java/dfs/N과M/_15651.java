import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static LinkedList<Integer> arr = new LinkedList<>();
	static StringBuffer stringBuffer;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		stringBuffer = new StringBuffer();
		dfs(0);
		System.out.println(stringBuffer);
	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int x : arr) {
				stringBuffer.append(x).append(" ");
			}
			stringBuffer.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			arr.add(i);
			dfs(depth + 1);
			arr.removeLast();
		}
	}

}
