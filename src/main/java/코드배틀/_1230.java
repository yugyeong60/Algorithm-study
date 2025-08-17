package 코드배틀;

import java.util.LinkedList;
import java.util.Scanner;

class _1230 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			
			for (int i=0; i<N; i++) {
				list.add(sc.nextInt());
			}
			
			int x, y;
			int M = sc.nextInt();
			for (int i=0; i<M; i++) {
				String st = sc.next();
				
				if (st.equals("I")) {
					x = sc.nextInt();
					y = sc.nextInt(); 
					
					for (int j = 0; j<y; j++ ) {
						list.add(x+j, sc.nextInt());			
					}
				} else if (st.equals("D")) {
					x = sc.nextInt();
					y = sc.nextInt(); 
					
					for (int j = 0; j<y; j++ ) {
						list.remove(x);			
					}
				} else {
					y = sc.nextInt();
					for (int j = 0; j<y; j++ ) {
						list.add(sc.nextInt());			
					}
				}
				
			}
			
			StringBuffer stringBuffer = new StringBuffer();
			for (int i=0; i<10; i++) {
				stringBuffer.append(" ").append(list.get(i));
			}
			
			System.out.println("#" + test_case + " " + stringBuffer);
		}
	}
}