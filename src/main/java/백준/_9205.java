import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt(); // 편의점 개수
            
            // 출발 지점 (집)
            int srtX = sc.nextInt();
            int srtY = sc.nextInt();
            
            // 편의점
            int[][] xy = new int[N][2];
            for (int i=0; i<N; i++){
                xy[i][0] = sc.nextInt();
                xy[i][1] = sc.nextInt();
            }
            
            // 도착 지점 (페스티벌)
            int endX = sc.nextInt();
            int endY = sc.nextInt();

            int beer = 20;
            boolean isOK = false;
            boolean[] used = new boolean[N];

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {srtX, srtY, beer});
            while (!q.isEmpty()) {
                int[] nxy = q.poll();
                
                // 남은 맥주로 도달할 수 있으면
                if (Math.abs(nxy[0] - endX) + Math.abs(nxy[1] - endY) <= 50*nxy[2]) {
                    isOK = true;
                    break;
                }

                // 편의점으로 갈 수 있으면
                for (int i=0; i<N; i++){
                    if (!used[i] && Math.abs(nxy[0] - xy[i][0]) + Math.abs(nxy[1] - xy[i][1]) <= 50*nxy[2]){
                        used[i] = true;
                        q.add(new int[] {xy[i][0], xy[i][1], 20});
                    }
                }   
            }

            if (isOK)
                System.out.println("happy");
            else System.out.println("sad");

		}
	}
}