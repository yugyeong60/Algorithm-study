import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] oper;
	static int[] num;
	static int max;
	static int min;
	static int sum;
	static boolean[] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

//		숫자 저장
		num = new int[N];
		for (int i = 0; i < N; i++)
			num[i] = sc.nextInt();

//		연산자 저장
		oper = new int[N - 1];
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int tmp = sc.nextInt();
			for (int j = 0; j < tmp; j++)
				oper[idx++] = i;
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		sum = num[0];
		used = new boolean[N - 1];
		dfs(1);

		System.out.println(max);
		System.out.println(min);
	}

//	dfs로 연산자 조합 생성 후 값 계산
	static void dfs(int depth) {
		if (depth == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (!used[i]) {
				int tmp = sum;
				if (oper[i] == 0)
					sum += num[depth];
				else if (oper[i] == 1)
					sum -= num[depth];
				else if (oper[i] == 2)
					sum *= num[depth];
				else if (oper[i] == 3)
					sum /= num[depth];
				used[i] = true;

				dfs(depth + 1);

				sum = tmp;
				used[i] = false;

			}
		}
	}
}
