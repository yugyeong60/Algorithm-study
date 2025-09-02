import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] isCnt = new int[d + 1];
		

		Queue<Integer> q = new LinkedList<>();

		int cnt = 0;
		
		for (int i = 0; i < k; i++) {
			if (isCnt[arr[i]]++ == 0)
				cnt++;
			q.add(arr[i]);
		}

		if (isCnt[c]++ == 0) cnt++;
		int max = cnt;

		for (int i = k; i < N + k; i++) {
			int out = q.poll();
			if (--isCnt[out] == 0)
				cnt--;
			if (isCnt[arr[i % N]]++ == 0)
				cnt++;
			q.add(arr[i % N]);

			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}

}
