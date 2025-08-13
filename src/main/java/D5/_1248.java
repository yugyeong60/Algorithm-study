package D5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Solution {

	static int[][] nodeArr;
	static int result;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int V = sc.nextInt();
			int E = sc.nextInt();

			int searchNum1 = sc.nextInt();
			int searchNum2 = sc.nextInt();

			nodeArr = new int[V + 1][3];

			for (int i = 0; i < E; i++) {

				int par = sc.nextInt();
				int chi = sc.nextInt();

//				자식 정보 저장
				if (nodeArr[par][0] == 0)
					nodeArr[par][0] = chi;
				else
					nodeArr[par][1] = chi;

//				부모 정보 저장
				nodeArr[chi][2] = par;
			}

//			2개의 정점 > 모든 조상 정보 저장
			List<Integer> list1 = new LinkedList<>();
			List<Integer> list2 = new LinkedList<>();

			while (nodeArr[searchNum1][2] != 1) {
				list1.add(nodeArr[searchNum1][2]);
				searchNum1 = nodeArr[searchNum1][2];
			}
			list1.add(1);

			while (nodeArr[searchNum2][2] != 1) {
				list2.add(nodeArr[searchNum2][2]);
				searchNum2 = nodeArr[searchNum2][2];
			}
			list2.add(1);

//			최대 공통 조상 찾기
			boolean isOk = false;
			int resultNode = 0;
			for (int x : list1) {
				for (int y : list2) {
					if (x == y) {
						resultNode = x;
						isOk = true;
						break;
					}
				}
				if (isOk)
					break;
			}

			result = 0;
			sizeTree(resultNode);

			System.out.println("#" + test_case + " " + resultNode + " " + result);

		}
	}

//	서브트리의 크기 계산
	public static void sizeTree(int nodeInt) {

		if (nodeArr[nodeInt][0] != 0) {
			sizeTree(nodeArr[nodeInt][0]);
		}
		if (nodeArr[nodeInt][1] != 0) {
			sizeTree(nodeArr[nodeInt][1]);
		}
		result++;
	}

}