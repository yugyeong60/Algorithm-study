package 코드배틀;


import java.util.LinkedList;
import java.util.Scanner;


class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int L = sc.nextInt();
		
			LinkedList<Integer> list = new LinkedList<>();
			
			for (int i=0; i<N; i++) {
				list.add(sc.nextInt());
			}
			
			int x;
			for (int i=0; i<M; i++) {
				String st = sc.next();
				x = sc.nextInt();
				
//				입력 받는 인덱스의 위치가 존재하지 않는 불가능한 경우
				if (x >= list.size()) {
					if (!st.equals("D")) {
						sc.nextInt();
					}
				} 
//				I/D/C
				else {
					if (st.equals("I")) {
						list.add(x, sc.nextInt());	
						
					} else if (st.equals("D")) {
						list.remove(x);
						
					} else {
						list.remove(x);
						list.add(x, sc.nextInt());
					}
				}
				
			}
			
			if (list.size() < L) {
				System.out.println("#" + test_case + " " + -1);
			} else {
				System.out.println("#" + test_case + " " + list.get(L));
			}
			
		}
	}
}