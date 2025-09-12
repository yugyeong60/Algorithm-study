import java.util.Scanner;

class Main {

	static int[] f;
	static int code1;
	static int code2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		f = new int[N + 1];
		code1 = 1;
		code2 = 0;

		fib(N);
		fibonacci(N);

		System.out.println(code1 + " " + code2);
	}

	static int fib(int n) {

		if (n == 1 || n == 2) {
			return 1;
		} else {
			code1++;
			return (fib(n - 1) + fib(n - 2));
		}
	}

	static int fibonacci(int n) {
		f[1] = f[2] = 1;

		for (int i = 3; i <= n; i++) {
			code2++;
			f[i] = f[i - 1] + f[i - 2];
		}

		return f[n];
	}
}
