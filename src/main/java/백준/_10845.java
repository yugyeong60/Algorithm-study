import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _10845 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuffer stringBuffer = new StringBuffer();

		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		int input = 99;

		for (int i = 0; i < N; i++) {

			String st = sc.next();
			
			switch (st) {
			
			case "push":
				input = sc.nextInt();
				q.add(input);
				break;

			case "front":
				if (q.isEmpty()) {
					stringBuffer.append(-1).append("\n");

				} else {
					stringBuffer.append(q.peek()).append("\n");
				}
				break;

			case "back":
				if (q.isEmpty()) {
					stringBuffer.append(-1).append("\n");
				} else {
					stringBuffer.append(input).append("\n");
				}
				break;


			case "empty":
				if (q.isEmpty()) {
					stringBuffer.append(1).append("\n");
				} else {
					stringBuffer.append(0).append("\n");
				}
				break;


			case "pop":
				if (q.isEmpty()) {
					stringBuffer.append(-1).append("\n");
				} else {
					stringBuffer.append(q.poll()).append("\n");
				}
				break;

			case "size":
				stringBuffer.append(q.size()).append("\n");
				break;

			}
			
		}
		System.out.println(stringBuffer);
	}
}
