import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Solution
{
	
	static boolean[] used;
	static int N;
	static List<LinkedList<Integer>> caseAll;
	static LinkedList<Integer> caseOne;
	static int[] oper;
	
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			
//			연산자 4개
//			+ : 0, - : 1, * : 2, / : 3
			oper = new int[N-1];
			int idx = 0;
			for (int i=0; i<4; i++) {
				int cnt = sc.nextInt();
				
				for (int j=0; j<cnt; j++) {
					oper[idx++] = i;
				}
			}
			
//			숫자
			int[] num = new int[N];
			for (int i=0; i<N; i++) {
				num[i] = sc.nextInt();
			}

//			연산자 순서 모든 경우의 수
			used = new boolean[N-1];
			caseAll = new LinkedList<>();
			caseOne = new LinkedList<>();
			dfs(0);
			
//			값 계산 후 최대/소 갱신
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (LinkedList<Integer> caseEx : caseAll) {
				idx = 0;
				int result = num[idx++];
				
				for (int i=0; i<N-1; i++) {
					int n = caseEx.removeFirst();
					if (n == 0) {
						result += num[idx++];
					} else	if (n == 1) {
						result -= num[idx++];
					} else	if (n == 2) {
						result *= num[idx++];
					} else	if (n == 3) {
						result /= num[idx++];
					}
				}
				
				min = Math.min(result, min);
				max = Math.max(result, max);
			}
			
			System.out.println("#" + test_case + " " + (max - min));
		}
		

	}
	
	static void dfs(int depth) {
		if (depth == N-1) {
			caseAll.add(new LinkedList<>(caseOne));
		    return; 
		}
		
		for (int i=0; i<N-1; i++) {
			if (used[i]) continue;
			
			if (i > 0 && oper[i] == oper[i-1] && !used[i-1]) continue;
			
			caseOne.add(oper[i]);
			used[i]=true;
			
			dfs(depth + 1);
			
			caseOne.removeLast();
			used[i]=false;
		}
	}
}