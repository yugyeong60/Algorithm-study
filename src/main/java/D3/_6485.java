package D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class _6485
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			
//			Ai, Bi
			int[][] bus = new int[N][2];
			
			for (int i=0; i<N; i++) {
				bus[i][0] = sc.nextInt();
				bus[i][1] = sc.nextInt();
			}
			
//			각 정류장에 버스노선 수 계산
			int[] station = new int[5001];
			for (int i=0; i<N; i++) {
				for (int j = bus[i][0]; j<= bus[i][1]; j++ ) {
					station[j]++;
				}
			}
			
//			출력할 정류장 번호
			int P = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			
			for (int i=0; i<P; i++) {
				q.add(sc.nextInt());
			}
			
//			출력 값 정리 및 출력
			StringBuffer stringBuffer = new StringBuffer();
			while (!q.isEmpty()) {
				stringBuffer.append(" ") .append(station[q.poll()]);
			}
			
			System.out.println("#" + test_case + stringBuffer);
		}
		
	}
}