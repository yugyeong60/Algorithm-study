import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

//			수를 배열로 바꾼 후 정렬
			int[] arr = new int[10];
			for (int i = 0; i < 6; i++) {
				arr[N % 10]++;
				N /= 10;
			}

			for (int j=0; j<2; j++) {
				for (int i = 0; i < 10; i++) {
//					triple
					if (arr[i] >= 3) {
						arr[i] -=3;
					}

//					run
					if (i<= 7 && arr[i] >= 1 && arr[i +1] >= 1 && arr[i+2] >=1) {
						arr[i]--;
						arr[i + 1]--;
						arr[i + 2]--;
					}
				}
			}
			
//			baby-gin
			boolean isBaby = true;
			for (int x : arr) {
				if (x != 0) {
					isBaby = false;
					break;
				}
			}

			System.out.println("#" + test_case + " " + isBaby);

		}
	}
}