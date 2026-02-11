import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int min = Integer.MAX_VALUE; // 가장 낮은 곳
        int max = Integer.MIN_VALUE; // 가장 높은 곳

        int[][] map = new int[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int result = 1;
        int[] di = {1, -1, 0, 0};
        int[] dj = {0, 0, 1, -1};
        for (int t=min; t< max; t++){ // 잠긴 곳 높이

            boolean[][] used = new boolean[N][N];
            Queue<int[]> q = new LinkedList<>();
            int cnt = 0;

            for (int i=0; i<N; i++) { // 전체를 돌며
                for (int j=0; j<N; j++) {

                    if (!used[i][j] && map[i][j] > t) { // 잠긴 곳보다 높으면
                        q.add(new int[]{i, j});
                        used[i][j] = true;
                        cnt++;

                        while (!q.isEmpty()) {
                            int[] tmp = q.poll();
                            for (int k=0; k<4; k++) {
                                int ni = tmp[0] + di[k];
                                int nj = tmp[1] + dj[k];

                                if (ni < 0 || ni >= N || nj < 0 || nj >= N)
                                    continue;

                                if (!used[ni][nj] && map[ni][nj] > t){
                                    q.add(new int[]{ni, nj});
                                    used[ni][nj] = true;
                                }
                            }
                        }
                    }
                }
            }

            result = Math.max(cnt, result);
        }

        System.out.println(result);
    }

}
