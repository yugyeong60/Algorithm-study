import java.util.Arrays;
import java.util.Scanner;

class Solution {
	static int N; // 섬 개수
	static long[] x; // 섬의 x 좌표들
	static long[] y; // 섬의 y 좌표들
	static double E; // 환경 부담 세율 실수

	static int idx;
	static Edge[] edges;
	static int[] p;

	static class Edge implements Comparable<Edge> {
		int v1, v2;
		long len;

		public Edge(int v1, int v2, long len) {
			this.v1 = v1;
			this.v2 = v2;
			this.len = len;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.len, o.len);
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

//			값 받아오기
			N = sc.nextInt();

			x = new long[N];
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
			}

			y = new long[N];
			for (int i = 0; i < N; i++) {
				y[i] = sc.nextInt();
			}

			E = sc.nextDouble();

//			모든 조합의 edge에 대한 길이 저장
			int caseN = N * (N - 1) / 2;
			idx = 0;
			edges = new Edge[caseN];
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					long len = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
					edges[idx++] = new Edge(i, j, len);
				}
			}
			Arrays.sort(edges);

//			조합 생성
			p = new int[N];
			for (int i = 0; i < N; i++)
				p[i] = i;

//			간선 정하기
			int edgeN = 0;
			idx = 0;
			double cost = 0;
			while (edgeN < N - 1) {
				int px = findSet(edges[idx].v1);
				int py = findSet(edges[idx].v2);

				if (px != py) {
					p[px] = py;
					edgeN++;
					cost += (edges[idx].len * E);
				}
				idx++;

			}

			System.out.println("#" + test_case + " " + Math.round(cost));

		}
	}

//	원소의 부모 찾기
	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}
}