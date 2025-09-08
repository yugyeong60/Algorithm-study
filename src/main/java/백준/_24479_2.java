import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int N;
	static int M;
	static int[][] graph;
	static boolean[] used;
	static Stack<Integer> stack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();

//		간선 여부 그래프로 표현
		graph = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = 1;
		}

//		dfs 탐색 순서 stack에 저장
		stack = new Stack<>();
		used = new boolean[N + 1];
		stack.add(R);
		used[R] = true;
		dfs(R);

//		해당 정점이 방문되는 순서 result에 저장
		int[] result = new int[N + 1];
		int order = stack.size();
		while (!stack.isEmpty()) {
			int v = stack.pop();
			result[v] = order--;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= N; i++)
			sb.append(result[i]).append("\n");
		System.out.println(sb);

	}

//	dfs
	static void dfs(int start) {
		for (int end = 1; end < N + 1; end++) {
			if (graph[start][end] == 1 && !used[end]) {
				stack.add(end);
				used[end] = true;
				dfs(end);
			}
		}

	}

}