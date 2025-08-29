import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		TreeSet<String> setN = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			setN.add(sc.next());
		}

		TreeSet<String> setM = new TreeSet<>();
		int num = 0;
		for (int i = 0; i < M; i++) {
			String string = sc.next();

			if (setN.contains(string)) {
				setM.add(string);
				num++;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(num).append("\n");
		for (String x : setM) {
			sb.append(x).append("\n");
		}
		System.out.println(sb);
	}
}
