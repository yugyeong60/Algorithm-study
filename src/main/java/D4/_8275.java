import java.util.ArrayList;
import java.util.Scanner;

class Solution {

	static ArrayList<int[]> CaseN;
	static int[][] record;
	static int N;
	static int X;
	static int M;
	static int[] tmp;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt(); // 우리 수
			X = sc.nextInt(); // 햄스터 최대 수
			M = sc.nextInt(); // 기록 수

			record = new int[M][3];

			for (int i = 0; i < M; i++) {
				record[i][0] = sc.nextInt() - 1; // 시작
				record[i][1] = sc.nextInt() - 1; // 끝
				record[i][2] = sc.nextInt(); // 합
			}

//			우리마다 가질 수 있는 햄스터 수의 모든 경우
			CaseN = new ArrayList<>();
			tmp = new int[N];
			dfs(0);

//			모든 경우중 경근이가 적은 기록에 만족하는 것만 저장
			ArrayList<int[]> results = new ArrayList<>();
			int max = 0;
			for (int[] tmp : CaseN) {
				boolean isOk = true;
				for (int i = 0; i < M; i++) {
					int start = record[i][0];
					int end = record[i][1];

					int sum = 0;
					for (int j = start; j <= end; j++) {
						sum += tmp[j];
					}

					if (sum != record[i][2]) {
						isOk = false;
						break;
					}
				}

				if (isOk) {
					int sumN = 0;
					for (int x : tmp) {
						sumN += x;
					}

					max = Math.max(sumN, max); // 그중 합이 최대인 것 찾기
					results.add(tmp); // 가능 경우 저장
				}
			}

//			가능한 경우 중 사전순으로 가장 앞인 것 찾기
			StringBuffer sb = new StringBuffer();
			if (results.isEmpty())
				sb.append(" ").append(-1);
			else {
				int[] result = new int[N];
				for (int[] tmp : results) {
					int sumN = 0;
					for (int x : tmp) {
						sumN += x;
					}

					if (sumN == max) {
						result = tmp;
						break;
					}
				}

				for (int x : result) {
					sb.append(" ").append(x);
				}
			}

			System.out.println("#" + test_case + sb);
		}
	}

	static void dfs(int idx) {
		if (idx == N) {
			CaseN.add(tmp.clone());
			return;
		}

		for (int i = 0; i <= X; i++) {
			tmp[idx] = i;
			dfs(idx + 1);
		}

	}
}