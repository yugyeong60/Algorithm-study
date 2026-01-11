import java.util.Scanner;

public class Main {

	static int N;
	static int[] used;
	static int[] num;
	static long cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		used = new int[10];
		num = new int[N];

		for (int i = 1; i < 10; i++) {
			used[i]++;
			num[0] = i;

			dfs(1);

			used[i]--;
		}

		System.out.println(cnt % 1000000000);
	}

	static void dfs(int depth) {
		if (depth == N) {
			boolean isOk = true;
			for (int use : used) { // 0~9를 모두 사용했을 떄
				if (use <= 0) {
					isOk = false;
					break;
				}
			}
			if (isOk)
				cnt++;
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (num[depth - 1] + 1 == i || num[depth - 1] - 1 == i) {
				num[depth] = i;
				used[i]++;

				dfs(depth + 1);

				used[i]--;
			}
		}
	}
}
