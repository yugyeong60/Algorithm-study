package D4;


import java.util.Scanner;

class _1219 {

	static int[] arr1;
	static int[] arr2;
	static int isOk;
	static boolean[] visited;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			isOk = 0;
			int tc = sc.nextInt();
			int N = sc.nextInt();

			arr1 = new int[100];
			arr2 = new int[100];
			visited = new boolean[100];

			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();

				if (arr1[start] != 0) {
					arr2[start] = end;
				} else {
					arr1[start] = end;
				}
			}

			duHyeon(0);

			System.out.println("#" + tc + " " + isOk);
		}
	}

	public static void duHyeon(int start) {
		if (isOk == 1)
			return;
		if (arr1[start] == 99 || arr2[start] == 99) {
			isOk = 1;
			return;
		}

		visited[start] = true;

		if (arr1[start] != 0 && !visited[arr1[start]])
			duHyeon(arr1[start]);

		if (arr2[start] != 0 && !visited[arr2[start]])
			duHyeon(arr2[start]);

	}
}
