package D4;

import java.util.Scanner;

class Solution
{
	static int N;
	static int[] leftChi;
	static int[] rightChi;
	static String[] nodeStrings;
	static StringBuilder stringBuilder;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			leftChi = new int[N + 1];
			rightChi = new int[N + 1];
			nodeStrings = new String[N + 1];
			stringBuilder = new StringBuilder();
			int nodeInt;

//			왼/오른쪽 자식 노드 정보 저장
//			자식 2개를 갖는 노드
			for (int i = 0; i < (N - 1) / 2; i++) {
				nodeInt = sc.nextInt();
				nodeStrings[nodeInt] = sc.next();
				leftChi[nodeInt] = sc.nextInt();
				rightChi[nodeInt] = sc.nextInt();

			}

//			짝수일 경우
			if (N % 2 == 0) {
//				자식 1개를 갖는 노드
				nodeInt = sc.nextInt();
				nodeStrings[nodeInt] = sc.next();
				leftChi[nodeInt] = sc.nextInt();

//				리프 노드
				for (int i = 0; i < N / 2; i++) {
					nodeInt = sc.nextInt();
					nodeStrings[nodeInt] = sc.next();
				}

//			홀수일 경우
			} else {
//				리프 노드
				for (int i = 0; i < N / 2 + 1; i++) {
					nodeInt = sc.nextInt();
					nodeStrings[nodeInt] = sc.next();
				}
			}

			inOrder(1);

			System.out.println("#" + test_case + " " + stringBuilder);
		}
	}

//	중위 순회 
	public static void inOrder(int nodeNum) {
		if (nodeNum < 1 && nodeNum > N)
			return;

		if (leftChi[nodeNum] != 0)
			inOrder(leftChi[nodeNum]);
		stringBuilder.append(nodeStrings[nodeNum]);
		if (rightChi[nodeNum] != 0)
			inOrder(rightChi[nodeNum]);
	}

}