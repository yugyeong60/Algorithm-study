import java.util.Scanner;

public class Main {

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		p = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < M; i++) {
			int tc = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

//			합칩합
			if (tc == 0) {
				if (findSet(x) != findSet(y))
					p[findSet(x)] = findSet(y);
			}
//			같은 집합에 포함되어 있는지 확인
			else {
				if (findSet(x) == findSet(y))
					sb.append("YES").append("\n");
				else
					sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];

	}

}
