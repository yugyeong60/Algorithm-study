import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// 0-1 bfs

class Main {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            for (int j = 0; j < M; j++)
                map[i][j] = tmp.charAt(j) - '0';
        }

        int[] di = { 1, -1, 0, 0 };
        int[] dj = { 0, 0, 1, -1 };

        long[][] cnt = new long[N][M];
        for (int i = 0; i < N; i++)
            Arrays.fill(cnt[i], Integer.MAX_VALUE);
        cnt[0][0] = 0;

        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });

        while (!q.isEmpty()) {
            int[] ij = q.poll();

            for (int k = 0; k < 4; k++) {
                int ni = di[k] + ij[0];
                int nj = dj[k] + ij[1];

                if (ni < 0 || ni >= N || nj < 0 || nj >= M)
                    continue;

                if (cnt[ni][nj] > cnt[ij[0]][ij[1]] + map[ni][nj]) {
                    cnt[ni][nj] = cnt[ij[0]][ij[1]] + map[ni][nj];

                    // 빈방
                    if (map[ni][nj] == 0)
                        q.addFirst(new int[] { ni, nj });
                    // 벽
                    else
                        q.addLast(new int[] { ni, nj });
                }

            }

        }

        System.out.println(cnt[N - 1][M - 1]);

    }
}