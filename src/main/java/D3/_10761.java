package D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class _10761 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int posO = 1;
			int posB = 1;
			int newPosO = 0;
			int newPosB = 0;
			int timeO = 0;
			int timeB = 0;
			int time = 0;

			String[][] arr = new String[N][2];
			Queue<Integer> qO = new LinkedList<>();
			Queue<Integer> qB = new LinkedList<>();

//			전체 값 받아오기 > 배열에 저장
//			O, B의 경우 나누기 > queue에 저장
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.next();
				arr[i][1] = sc.next();
				if (arr[i][0].equals("O"))
					qO.add(Integer.parseInt(arr[i][1]));
				else
					qB.add(Integer.parseInt(arr[i][1]));
			}

//			1. 해당하는 경우의 시간 계산
//			2. 걸린 시간만큼 다른 로봇 이동시키기
			for (int i = 0; i < N; i++) {
				String turn = arr[i][0];

				if (turn.equals("O")) {
					newPosO = qO.poll();
					timeO = Math.abs(newPosO - posO);
					posO = newPosO;
					timeO++;

					if (!qB.isEmpty()) {
						newPosB = qB.peek();
						if (Math.abs(newPosB - posB) < timeO) {
							posB = newPosB;
						} else if (newPosB > posB) {
							posB += timeO;
						} else {
							posB -= timeO;
						}
					}

					time += timeO;

				} else if (turn.equals("B")) {
					newPosB = qB.poll();
					timeB = Math.abs(newPosB - posB);

					posB = newPosB;
					timeB++;

					if (!qO.isEmpty()) {
						newPosO = qO.peek();
						if (Math.abs(newPosO - posO) < timeB) {
							posO = newPosO;
						} else if (newPosO > posO) {
							posO += timeB;
						} else {
							posO -= timeB;
						}
					}

					time += timeB;
				}
			}
			System.out.println("#" + test_case + " " + time);
		}
	}
}