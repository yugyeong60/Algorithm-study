import java.util.Scanner;

class Solution {

	static int N;
	static int result;
	static int[] col;
	static int[] diagU;
	static int[] diagD;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			result = 0;

//			열 가능 여부
			col = new int[N];

//			대각선 위 가능 여부
			diagU = new int[N + N - 1];

//			대각선 아래 가능 여부
			diagD = new int[N + N - 1];

			dfs(0);

			System.out.println("#" + test_case + " " + result);

		}
	}

	static void dfs(int depth) {
		if (depth == N) {
			result++;
			return;
		}

		for (int j = 0; j < N; j++) {

			if (col[j] > 0 || diagU[depth + j] > 0 || diagD[depth - j + N - 1] > 0)
				continue;

			col[j]++;
			diagU[depth + j]++;
			diagD[depth - j + N - 1]++;

			dfs(depth + 1);

			col[j]--;
			diagU[depth + j]--;
			diagD[depth - j + N - 1]--;

		}
	}

}


// import java.util.Scanner;

// class Solution {

// 	static int N;
// 	static int result;
// 	static int[][] board;

// 	public static void main(String args[]) throws Exception {

// 		Scanner sc = new Scanner(System.in);
// 		int T;
// 		T = sc.nextInt();
// 		/*
// 		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
// 		 */

// 		for (int test_case = 1; test_case <= T; test_case++) {
// 			N = sc.nextInt();
// 			result = 0;

// 			board = new int[N][N];

// 			dfs(0);
// 			System.out.println("#" + test_case + " " + result);

// 		}
// 	}

// 	static void dfs(int depth) {
// 		if (depth == N)
// 			result++;

// 		for (int i = 0; i < N; i++) {
// 			for (int j = 0; j < N; j++) {

// 				if (board[i][j] > 0)
// 					continue;

// 				for (int len = 0; len < N; len++) {
// 					board[len][j]++;
// 					board[i][len]++;
// 					if (i + len < N && j + len < N)
// 						board[i + len][j + len]++;
// 					if (i - len >= 0 && j + len < N)
// 						board[i - len][j + len]++;
// 					if (i + len < N && j - len >= 0)
// 						board[i + len][j - len]++;
// 					if (i - len >= 0 && j - len >= 0)
// 						board[i - len][j - len]++;
// 				}

// 				dfs(depth + 1);

// 				for (int len = 0; len < N; len++) {
// 					board[len][j]--;
// 					board[i][len]--;
// 					if (i + len < N && j + len < N)
// 						board[i + len][j + len]--;
// 					if (i - len >= 0 && j + len < N)
// 						board[i - len][j + len]--;
// 					if (i + len < N && j - len >= 0)
// 						board[i + len][j - len]--;
// 					if (i - len >= 0 && j - len >= 0)
// 						board[i - len][j - len]--;
// 				}

// 			}
// 		}
// 	}

// }