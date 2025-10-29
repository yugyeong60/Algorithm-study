import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] p = new int[N + 1];
			for (int i = 2; i <= N; i++)
				p[i] = sc.nextInt();

//			bfs 순서 저장
			Queue<Integer> q = new LinkedList<>();
			Queue<Integer> tmp = new LinkedList<>();
			tmp.add(1);
			while (!tmp.isEmpty()) {
				int par = tmp.poll();

				for (int j = 2; j <= N; j++) {
					if (p[j] == par) {
						q.add(j);
						tmp.add(j);
					}
				}
			}

			int n1 = 1;
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				int n2 = q.poll();

//				노드의 부모 찾기
				int idx = n1;
				ArrayList<Integer> n1p = new ArrayList<>();
				n1p.add(n1);
				while (p[idx] != 0) {
					n1p.add(p[idx]);
					idx = p[idx];
				}

				idx = n2;
				ArrayList<Integer> n2p = new ArrayList<>();
				n2p.add(n2);
				while (p[idx] != 0) {
					n2p.add(p[idx]);
					idx = p[idx];
				}

//				이동거리 구하기
				int min = Integer.MAX_VALUE;
				for (int idx1 = 0; idx1 < n1p.size(); idx1++) {
					for (int idx2 = 0; idx2 < n2p.size(); idx2++) {
						if (n1p.get(idx1) == n2p.get(idx2))
							min = Math.min(min, idx1 + idx2);
					}
				}

				sum += min;
				n1 = n2;
			}

			System.out.println("#" + test_case + " " + sum);

		}
	}
}