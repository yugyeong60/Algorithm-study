package D4;

import java.util.Scanner;

class Solution {

	static int N;
	static int[] leftChi;
	static int[] rightChi;
	static String[] nodeOper; // 연산자 저장
	static int[] nodeNum; // 숫가 저장

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			leftChi = new int[N + 1];
			rightChi = new int[N + 1];
			nodeOper = new String[N + 1];
			nodeNum = new int[N + 1];

			for (int i = 0; i < N; i++) {
				int nodeInt = sc.nextInt();
				String nodeData = sc.next();

//				숫자
				if (nodeData.matches("\\d+")) {
					nodeNum[nodeInt] = Integer.parseInt(nodeData);
				}
//				연산자
				else {
					nodeOper[nodeInt] = nodeData;
					leftChi[nodeInt] = sc.nextInt();
					rightChi[nodeInt] = sc.nextInt();
				}
			}

			int result = postOrder(1);
			System.out.println("#" + test_case + " " + result);
		}
	}

//	후위 순회
	public static int postOrder(int nodeInt) {
//		숫자 > 바로 반환
		if (nodeNum[nodeInt] != 0)
			return nodeNum[nodeInt];
		
//		연산자 
		int leftVal = postOrder(leftChi[nodeInt]);
		int rightVal = postOrder(rightChi[nodeInt]);

		switch (nodeOper[nodeInt]) {
		case "+":
			return leftVal + rightVal;
		case "-":
			return leftVal - rightVal;
		case "*":
			return leftVal * rightVal;
		case "/":
			return leftVal / rightVal;
		}
		return 0;
	}

}