import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class Solution {
	
	static int[] p;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			p = new int[N+1];
			for (int i=1; i<=N; i++) {
				p[i] = i;
			}
			
			for (int i=0; i<M; i++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				
				if (findSet(v1) != findSet(v2)) {
					p[findSet(v1)] = findSet(v2);
				}
			}
			
			Set<Integer> set = new HashSet<>();
			for (int i=1; i<=N; i++) {
				set.add(findSet(i));
			}
			
			System.out.println("#" + test_case + " " + set.size());
		}
	}
	
	static int findSet(int x) {
		if (p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
}