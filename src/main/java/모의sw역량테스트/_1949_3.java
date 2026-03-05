
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    static int N;
    static int K;
    static int[][] map;
    static int max;
    static int result;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            map = new int[N][N];
            max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    max = Math.max(max, map[i][j]);
                }
            }

            ArrayList<int[]> start = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max)
                        start.add(new int[]{i, j});
                }
            }

            result = 1;
            for (int[] p : start) {
                boolean[][] used = new boolean[N][N];
                used[p[0]][p[1]] = true;
                dfs(1, false, p[0], p[1], used);
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

    static void dfs(int depth, boolean useK, int x, int y, boolean[][] used) {
        boolean moved = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (used[nx][ny]) continue;

            if (map[nx][ny] < map[x][y]) {
                used[nx][ny] = true;

                dfs(depth + 1, useK, nx, ny, used);

                used[nx][ny] = false;
                moved = true;
            } else {
                if (!useK && map[nx][ny] - K < map[x][y]) {
                    used[nx][ny] = true;
                    int tmp = map[nx][ny];
                    map[nx][ny] = map[x][y] - 1;

                    dfs(depth + 1, true, nx, ny, used);

                    used[nx][ny] = false;
                    map[nx][ny] = tmp;
                    moved = true;
                }
            }
        }

        if (!moved) {
            result = Math.max(result, depth);
            return;
        }

    }
}