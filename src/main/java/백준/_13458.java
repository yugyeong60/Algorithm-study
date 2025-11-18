import java.util.Scanner;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[] num = new long[N];
		for (int i = 0; i < N; i++)
			num[i] = sc.nextInt();

		int B = sc.nextInt();
		int C = sc.nextInt();

		long sum = N;
		for (int i = 0; i < N; i++) {
			long tmp = num[i] - B;

			if (tmp > 0) {
				if (tmp % C != 0)
					sum += (tmp / C + 1);
				else
					sum += (tmp / C);
			}
		}
		System.out.println(sum);
	}
}
