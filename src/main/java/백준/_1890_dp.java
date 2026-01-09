import java.util.Scanner;

class Main {

    static int N; // 게임판 크기
    static int[][] map; // 게임판
    static boolean[][] used;
    static int cnt; // 경로의 수
    static long[][] dp;
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt(); 

        map = new int[N][N]; 
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++)
                map[i][j] = sc.nextInt();
        }

        dp = new long[N][N];
        dp[0][0] = 1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                int tmp = map[i][j];
                if (tmp == 0)
                    continue;

                // 아래쪽
                if (i + tmp < N)
                    dp[i + tmp][j] += dp[i][j];
                
                // 오른쪽
                if (j + tmp < N)
                    dp[i][j + tmp] += dp[i][j];
            }
        }
            
        System.out.println(dp[N-1][N-1]);  
    }   
}