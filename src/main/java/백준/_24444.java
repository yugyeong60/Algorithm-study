import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		ArrayList<Integer>[] edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			edges[from].add(to);
			edges[to].add(from);
		}

		// 정점 번호가 작은 것부터 방문해야 하므로 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(edges[i]);
		}

		Queue<Integer> q = new LinkedList<>();
		boolean[] used = new boolean[N + 1];
		int[] orders = new int[N + 1];
		int order = 1;

		q.add(R);
		used[R] = true;
		while (!q.isEmpty()) {
			int from = q.poll();
			orders[from] = order++;

			for (int to : edges[from]) {
				if (!used[to]) {
					q.add(to);
					used[to] = true;
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			sb.append(orders[i]).append("\n");
		}
		System.out.println(sb);
	}

}
