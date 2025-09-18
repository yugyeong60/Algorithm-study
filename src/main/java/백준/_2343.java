import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] lectures = new int[N];
		int maxLen = 0; // 길이가 가장 긴 강의 > 추후 최소 블루레이 크기로
		long sum = 0; // 전체 강의의 길이 합 > 추후 최대 블루레이 크기로

//      값 받아오기
		for (int i = 0; i < N; i++) {
			lectures[i] = sc.nextInt();
			maxLen = Math.max(maxLen, lectures[i]);
			sum += lectures[i];
		}

		long left = maxLen; // 최소 블루레이 크기
		long right = sum; // 최대 블루레이 크기
		long result = sum;

		while (left <= right) {
			long mid = (left + right) / 2;

			int cnt = 1; // 블루레이 개수
			long tmp = 0;

			for (int len : lectures) {
				if (tmp + len > mid) {
					cnt++;
					tmp = 0;
				}
				tmp += len;
			}

			if (cnt <= M) { // 블루레이 개수 충족 → 크기 줄일 수 있음
				result = mid;
				right = mid - 1;
			} else { // 블루레이 개수 초과 → 크기 늘려야 함
				left = mid + 1;
			}
		}

		System.out.println(result);
	}
}
