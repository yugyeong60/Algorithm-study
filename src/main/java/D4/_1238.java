import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

	static int[][] edges;
	static int[] depths;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			int dataL = sc.nextInt(); // 입력 받는 데이터 길이
			int start = sc.nextInt(); // 시작점

//			유향 간선 확인 배열
			edges = new int[101][101];
			for (int i = 0; i < dataL / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				edges[from][to] = 1;
			}

//			시작점에서 해당 점 까지의 깊이 확인  + 해당 점의 사용여부 확인 배열
			depths = new int[101];

			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			depths[start] = 1;

			while (!q.isEmpty()) {
				int from = q.poll();
				for (int to = 1; to <= 100; to++) {
					if (edges[from][to] == 1 && depths[to] == 0) {
						q.add(to);
						depths[to] = depths[from] + 1;
					}
				}
			}

//			마지막에 연락 받은 사람 중 가장 큰 번호 찾기
			int idx = 0;
			int max = 1;
			for (int i = 1; i <= 100; i++) {
				if (depths[i] >= max) {
					idx = i;
					max = depths[i];
				}
			}
			System.out.println("#" + test_case + " " + idx);
		}
	}

}