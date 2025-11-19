import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			list.add(i);

		int[] arr = new int[N];
		int tmp = 0;
		for (int i = N; i >= 1; i--) {
			int skill = sc.nextInt();

			if (skill == 1)
				tmp = list.removeFirst();
			else if (skill == 2)
				tmp = list.remove(1);
			else if (skill == 3)
				tmp = list.removeLast();

			arr[tmp - 1] = i;
		}

		StringBuffer sb = new StringBuffer();
		for (int x : arr)
			sb.append(x).append(" ");

		System.out.println(sb);
	}
}
