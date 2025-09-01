import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static Map<Character, Character[]> arr;
	static StringBuilder sb;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		arr = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			Character key = sc.next().charAt(0);
			Character lift = sc.next().charAt(0);
			Character right = sc.next().charAt(0);

			arr.put(key, new Character[] { lift, right });
		}

		sb = new StringBuilder();
		preOrder('A');
		sb.append("\n");
		inOrder('A');
		sb.append("\n");
		postOrder('A');

		System.out.println(sb);
	}

	static void preOrder(char key) {
		if (key - 'A' + 1 <= 0)
			return;

		sb.append(key);
		preOrder(arr.get(key)[0]);
		preOrder(arr.get(key)[1]);
	}

	static void inOrder(char key) {
		if (key - 'A' + 1 <= 0)
			return;

		inOrder(arr.get(key)[0]);
		sb.append(key);
		inOrder(arr.get(key)[1]);
	}

	static void postOrder(char key) {
		if (key - 'A' + 1 <= 0)
			return;

		postOrder(arr.get(key)[0]);
		postOrder(arr.get(key)[1]);
		sb.append(key);

	}
}
