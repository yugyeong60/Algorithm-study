package 코드배틀;

import java.util.Scanner;

class _10726 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
//			받아온 수를 이진수로 저장
			String binaryM = Integer.toBinaryString(M);
			int len = binaryM.length();
			
			boolean is1 = true;
			String result = "ON";
			
//			마지막 N개의 비트가 1인지 확인
//			길이가 작음 > 무조건 0포함 > OFF
			if (len < N) is1 = false;
			else {
				for (int i= len-1; i>=len-N; i--) {
					if (binaryM.charAt(i) != '1') {
						is1 = false;
						break;
					}
				}
			}
			
			if (!is1) result = "OFF";
			System.out.println("#" + test_case + " " + result );
		}
	}
}