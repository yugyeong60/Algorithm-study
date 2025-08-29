import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][3];

			for (int i = 0; i < N; i++) {

				String string = sc.next();

				for (int j = 0; j < M; j++) {
					switch (string.charAt(j)) {
					case 'W':
						arr[i][0]++;
						break;
					case 'B':
						arr[i][1]++;
						break;
					case 'R':
						arr[i][2]++;
						break;
					}
				}
			}

			Queue<Integer[]> caseN = new LinkedList<>();

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j <= N - 2 - i; j++) {
					caseN.add(new Integer[] { i, j, N - 2 - i - j });
				}
			}
			
			int min = N * M;
			while (!caseN.isEmpty()) {
				int num = 0;
				Integer[] test = caseN.remove();

				int idx = 1;
				for (int w = 0; w < test[0]; w++) {
					num += arr[idx][1];
					num += arr[idx][2];
					idx++;
				}
				for (int b = 0; b < test[1]; b++) {
					num += arr[idx][0];
					num += arr[idx][2];
					idx++;
				}

				for (int r = 0; r < test[2]; r++) {
					num += arr[idx][0];
					num += arr[idx][1];
					idx++;
				}

				min = Math.min(min, num);
			}

			min += arr[0][1];
			min += arr[0][2];
			min += arr[N - 1][0];
			min += arr[N - 1][1];

			System.out.println("#" + test_case + " " + min);

		}
	}
}