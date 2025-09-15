import java.util.HashSet;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}

		int M = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < M; i++) {
			
			int num = sc.nextInt();
			
			if (set.contains(num))
				sb.append(1).append(" ");
			else
				sb.append(0).append(" ");
		}

		System.out.println(sb);

	}
}
