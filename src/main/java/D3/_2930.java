package D3;

import java.util.Scanner;

class _2930 {

	static int[][] nodeArr;
	static int result;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int[] heap = new int[N + 1];
			int size = 0;
			StringBuilder stringBuilder = new StringBuilder();

			for (int i = 0; i < N; i++) {
				int caseNum = sc.nextInt();

//				연산 1. 자연수 x를 삽입
				if (caseNum == 1) {
					int x = sc.nextInt();

					int chi = ++size;
					int par = chi / 2;

//					맨 뒤에 삽입
					heap[chi] = x;

//					힙 정리
					while (chi / 2 != 0 && heap[chi] > heap[par]) {
						int tmp = heap[chi];
						heap[chi] = heap[par];
						heap[par] = tmp;

						chi = par;
						par = chi / 2;
					}

				}
//				연산 2. 최대 힙의 루트 노드의 키값을 출력하고, 해당 노드를 삭제
				else {
//					루드 노드의 키값 출력
					if (size == 0) {
						stringBuilder.append(" ").append(-1);
					} else {
						stringBuilder.append(" ").append(heap[1]);
						heap[1] = heap[size--];

//						힙 정리
						int par = 1;

						while (true) {
							int leftChi = par * 2;
							int rightChi = par * 2 + 1;
							int maxChild = leftChi;

							if (rightChi <= size && heap[rightChi] > heap[leftChi]) {
								maxChild = rightChi;
							}

							if (maxChild <= size && heap[maxChild] > heap[par]) {
								int tmp = heap[maxChild];
								heap[maxChild] = heap[par];
								heap[par] = tmp;

								par = maxChild;
							} else {
								break;
							}
						}
					}

				}

			}
			System.out.println("#" + test_case + stringBuilder);
		}
	}

}