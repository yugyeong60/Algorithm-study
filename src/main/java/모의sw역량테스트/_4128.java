import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Solution {
	static int N;
	static List<int[]> case2;
	static LinkedList<Integer> list;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

//			모든 조합 경우
			case2 = new ArrayList<>();
//			하나의 조합 경우
			list = new LinkedList<>();

//			A, B가 가지는 식재료 조합 계산
			dfs(0, 0);
			
			int min = 20000;
			for (int i = 0; i < case2.size() / 2; i++) {
				int sumA = 0;
				int sumB = 0;
				int[] A = case2.get(i);
				int[] B = case2.get(case2.size() - 1 - i);

				for (int j = 0; j < A.length; j++) {
					for (int k = 0; k < A.length; k++) {
						sumA += arr[A[j]][A[k]];
					}
				}

				for (int j = 0; j < B.length; j++) {
					for (int k = 0; k < B.length; k++) {
						sumB += arr[B[j]][B[k]];
					}
				}

				min = Math.min(Math.abs(sumA - sumB), min);

			}

			System.out.println("#" + test_case + " " + min);

		}

	}

	static void dfs(int depth, int start) {
		if (depth == N / 2) {
			int[] comb = new int[N / 2];
			int k = 0;
			for (int x : list)
				comb[k++] = x;
			case2.add(comb); // 저장
			return;
		}

		for (int i = start; i < N; i++) {
			list.add(i);
			dfs(depth + 1, i + 1);
			list.removeLast();
		}
	}

}