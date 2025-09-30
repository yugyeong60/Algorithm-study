import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static int len;
	static int tries;
	static int max;
	static int[] num;
	static Set<Integer>[] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			String N = sc.next();
			len = N.length();
			tries = sc.nextInt();

			num = new int[len];
			for (int i = 0; i < len; i++) {
				num[i] = N.charAt(i) - '0';
			}

			max = 0;
			used = new HashSet[tries + 1];
			for (int i = 0; i < tries + 1; i++)
				used[i] = new HashSet<>();

			dfs(0);
			System.out.println("#" + test_case + " " + max);
		}
	}

	static void dfs(int cnt) {

//		배열 >> 수로 표현
		int n = 0;
		int nth = (int) Math.pow(10, len - 1);
		for (int x : num) {
			n += nth * x;
			nth /= 10;
		}

//		이미 사용되었다면
		if (used[cnt].contains(n))
			return;

//		탈출 >> 최댓값 비교
		if (cnt == tries) {
			max = Math.max(max, n);
			return;
		}

//		재귀
		used[cnt].add(n);
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {

				int tmp = num[i];
				num[i] = num[j];
				num[j] = tmp;

				dfs(cnt + 1);

				tmp = num[i];
				num[i] = num[j];
				num[j] = tmp;
			}
		}
	}

}
