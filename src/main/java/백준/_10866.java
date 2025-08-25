import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Deque<Integer> dq = new ArrayDeque<>();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < N; i++) {
			String string = sc.next();

			switch (string) {
			case "push_front":
				dq.addFirst(sc.nextInt());
				break;

			case "push_back":
				dq.addLast(sc.nextInt());
				break;

			case "pop_front":
				if (dq.isEmpty())
					sb.append(-1);
				else {
					sb.append(dq.removeFirst());
				}
				sb.append("\n");
				break;

			case "pop_back":
				if (dq.isEmpty())
					sb.append(-1);
				else {
					sb.append(dq.removeLast());
				}
				sb.append("\n");
				break;

			case "size":
				sb.append(dq.size()).append("\n");
				break;

			case "empty":
				if (dq.isEmpty())
					sb.append(1);
				else {
					sb.append(0);
				}
				sb.append("\n");
				break;

			case "front":
				if (dq.isEmpty())
					sb.append(-1);
				else {
					sb.append(dq.getFirst());
				}
				sb.append("\n");
				break;

			case "back":
				if (dq.isEmpty())
					sb.append(-1);
				else {
					sb.append(dq.getLast());
				}
				sb.append("\n");
				break;

			}
		}

		System.out.println(sb);
	}
}