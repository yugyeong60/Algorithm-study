import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

//			숫자로 값 받아오기
			String str = sc.next();
			int[] arr = new int[N + N / 4];
			for (int i = 0; i < N; i++) {
				if (str.charAt(i) == 'A')
					arr[i] = 10;
				else if (str.charAt(i) == 'B')
					arr[i] = 11;
				else if (str.charAt(i) == 'C')
					arr[i] = 12;
				else if (str.charAt(i) == 'D')
					arr[i] = 13;
				else if (str.charAt(i) == 'E')
					arr[i] = 14;
				else if (str.charAt(i) == 'F')
					arr[i] = 15;
				else
					arr[i] = str.charAt(i) - '0';
			}

//			회전할 만큼 추가
			for (int i = 0; i < N / 4; i++)
				arr[N + i] = arr[i];

//			10진수로 바꾼 수 저장
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) { // 시작 pnt
				int num = 0;
				for (int j = 0; j < N / 4; j++)
					num = num * 16 + arr[i + j];

				if (!list.contains(num))
					list.add(num);
			}
//			오름차순 정
			Collections.sort(list);

			System.out.println("#" + test_case + " " + list.get(list.size() - K));

		}
	}
}