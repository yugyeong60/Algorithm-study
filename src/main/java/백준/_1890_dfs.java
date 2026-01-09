import java.util.Scanner;

class Main {

    static int N; // 게임판 크기
    static int[][] map; // 게임판
    static boolean[][] used;
    static int cnt; // 경로의 수
    static int[][] dp;
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt(); 

        map = new int[N][N]; 
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++)
                map[i][j] = sc.nextInt();
        }

        used = new boolean[N][N];
        dp = new int[N][N];
        cnt = 0;

        used[0][0] = true;
        dfs(0, 0);
        System.out.println(cnt);
   
    }

    static void dfs(int x, int y) {
        // 도착했을 때
        if (x == N-1 && y == N-1) {
            cnt++;
            return;
        }

        int tmp = map[x][y];
        // 아래쪽 이동
        if ((x + tmp) < N && !used[x + tmp][y]) {
            used[x + tmp][y] = true;
            dfs(x + tmp, y);
            used[x + tmp][y] = false;
        }

        // 오른쪽 이동
        if ((y + tmp) < N && !used[x][y + tmp]) {
            used[x][y + tmp] = true;
            dfs(x, y + tmp);
            used[x][y + tmp] = false;
        }
    }
}