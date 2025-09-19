import java.util.Scanner;

class Solution {

	static int[][] idx;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int K = sc.nextInt();

//			자석 4개의 정보
			int[][] NS = new int[4][8];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					NS[i][j] = sc.nextInt();
				}
			}

//			자석 4개들이 붙어있는 곳의 정보
			idx = new int[4][2];
			for (int i = 0; i < 4; i++) {
				idx[i][0] = 6;
				idx[i][1] = 2;
			}

			for (int i = 0; i < K; i++) {
				int num = sc.nextInt() - 1;
				int dir = sc.nextInt();

				int dirOpp = 0;
				if (dir == 1)
					dirOpp = -1;
				else
					dirOpp = 1;

//				3곳 비교
//				(0, 1) (1, 0) / (1, 1) (2, 0) / (2, 1) (3, 0)
				if (num == 0) {
					if (NS[0][idx[0][1]] != NS[1][idx[1][0]]) {
						if (NS[1][idx[1][1]] != NS[2][idx[2][0]]) {
							if (NS[2][idx[2][1]] != NS[3][idx[3][0]]) {
								turn(3, dirOpp);
							}
							turn(2, dir);
						}
						turn(1, dirOpp);
					}
					turn(0, dir);

				} else if (num == 1) {
					if (NS[1][idx[1][1]] != NS[2][idx[2][0]]) {
						if (NS[2][idx[2][1]] != NS[3][idx[3][0]])
							turn(3, dir);
						turn(2, dirOpp);
					}

					if (NS[0][idx[0][1]] != NS[1][idx[1][0]])
						turn(0, dirOpp);

					turn(1, dir);

				} else if (num == 2) {
					if (NS[1][idx[1][1]] != NS[2][idx[2][0]]) {
						if (NS[0][idx[0][1]] != NS[1][idx[1][0]])
							turn(0, dir);
						turn(1, dirOpp);
					}

					if (NS[2][idx[2][1]] != NS[3][idx[3][0]])
						turn(3, dirOpp);

					turn(2, dir);

				} else if (num == 3) {
					if (NS[2][idx[2][1]] != NS[3][idx[3][0]]) {
						if (NS[1][idx[1][1]] != NS[2][idx[2][0]]) {
							if (NS[0][idx[0][1]] != NS[1][idx[1][0]]) {
								turn(0, dirOpp);
							}
							turn(1, dir);
						}
						turn(2, dirOpp);
					}
					turn(3, dir);
				}

			}

			int sum = 0;
			for (int i = 0; i < 4; i++) {
				int index = (idx[i][1] + 6) % 8;

				if (NS[i][index] == 1)
					sum += Math.pow(2, i);
			}

			System.out.println("#" + test_case + " " + sum);

		}

	}

	static void turn(int num, int dir) {
//		시계방향 회전
		if (dir == 1) {
			idx[num][0] = (idx[num][0] + 7) % 8;
			idx[num][1] = (idx[num][1] + 7) % 8;

		}
//		반시계방향 회전
		else {
			idx[num][0] = (idx[num][0] + 1) % 8;
			idx[num][1] = (idx[num][1] + 1) % 8;
		}
	}
}