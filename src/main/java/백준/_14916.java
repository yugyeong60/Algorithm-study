import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N + 1];

		Arrays.fill(dp, 100001);
		dp[0] = 0;

		for (int j = 2; j <= N; j++)
			dp[j] = Math.min(dp[j], dp[j - 2] + 1);

		for (int j = 5; j <= N; j++)
			dp[j] = Math.min(dp[j], dp[j - 5] + 1);

		if (dp[N] == 100001)
			System.out.println(-1);
		else
			System.out.println(dp[N]);

	}
}