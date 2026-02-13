import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int H = sc.nextInt();
        int W = sc.nextInt();
        int[] S = {sc.nextInt(), sc.nextInt()};
        int[] F = {sc.nextInt(), sc.nextInt()};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] used = new boolean[N + 1][M + 1];

        q.add(new int[]{S[0], S[1], 0});
        used[S[0]][S[1]] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int result = -1;

        while (!q.isEmpty()) {
            int[] pnt = q.poll();

            if (pnt[0] == F[0] && pnt[1] == F[1]) {
                result = pnt[2];
                break;
            }

            for (int t = 0; t < 4; t++) {
                int nx = pnt[0] + dx[t];
                int ny = pnt[1] + dy[t];

                if (nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if (nx + H - 1 > N || ny + W - 1 > M) continue;
                if (used[nx][ny]) continue;

                boolean isOk = true;
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (map[nx + i][ny + j] == 1) {
                            isOk = false;
                            break;
                        }
                    }
                    if (!isOk) break;
                }

                if (isOk) {
                    q.add(new int[]{nx, ny, pnt[2] + 1});
                    used[nx][ny] = true;
                }


            }

        }
        System.out.println(result);
    }
}
