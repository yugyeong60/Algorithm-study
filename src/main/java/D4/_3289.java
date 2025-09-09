import java.util.Scanner;

class Solution {
	static int[] p;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			StringBuffer sb = new StringBuffer();

			p = new int[n+1];
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}

			for (int t = 0; t < m; t++) {
				int oper = sc.nextInt(); // 연산 종류
				int from = sc.nextInt(); 
				int to = sc.nextInt();

//				합집합 연산
				if (oper == 0) {
					p[findSet(to)] = findSet(from);
				}
//				포함여부 확인 연산
				else {
					if (findSet(from) == findSet(to))
						sb.append(1);
					else
						sb.append(0);
				}
			}

			System.out.println("#" + test_case + " " + sb);
		}
	}

// 부모 찾기
	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}
}