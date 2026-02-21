import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static int[][] fishs;
    static int max;
    static boolean[] used;

//    ↑, ↖, ←, ↙, ↓, ↘, →, ↗
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[4][4];
        fishs = new int[17][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = sc.nextInt();
                fishs[map[i][j]][0] = i; // x
                fishs[map[i][j]][1] = j; // y
                fishs[map[i][j]][2] = sc.nextInt() - 1; // 방향
            }
        }

        used = new boolean[17]; // 물고기가 잡아먹힌 여부
        max = Integer.MIN_VALUE; // 최종 값
        int n = map[0][0];

        map[0][0] = 0;
        used[n] = true;
        dfs(0, 0, n, fishs[n][2]);

        System.out.println(max);

    }

    static void dfs(int x, int y, int sum, int dir) {
//        물고기 이동
        for (int n = 1; n <= 16; n++) {
            if (used[n]) continue;

            for (int t = 0; t < 8; t++) {
                int dirF = (fishs[n][2] + t) % 8;
                int nx = fishs[n][0] + dx[dirF];
                int ny = fishs[n][1] + dy[dirF];

                if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
                if (nx == x && ny == y) continue; // 상어 위치

                int n2 = map[nx][ny];
                map[nx][ny] = n;
                map[fishs[n][0]][fishs[n][1]] = n2;

                if (n2 != 0) {
                    fishs[n2][0] = fishs[n][0];
                    fishs[n2][1] = fishs[n][1];
                }

                fishs[n][0] = nx;
                fishs[n][1] = ny;
                fishs[n][2] = dirF;
                break;
            }
        }

//        상어 이동
        int mul = 1;
        boolean moved = false;
        while (true) {
            int nx = x + dx[dir] * mul;
            int ny = y + dy[dir] * mul;

            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) break;
            if (map[nx][ny] == 0) { mul++; continue; }

            int[][] mapBackup = new int[4][4];
            for (int i = 0; i < 4; i++) {
                System.arraycopy(map[i], 0, mapBackup[i], 0, 4);
            }

            int[][] fishsBackup = new int[17][3];
            for (int i = 0; i < 17; i++) {
                System.arraycopy(fishs[i], 0, fishsBackup[i], 0, 3);
            }

            boolean[] usedBackup = used.clone();

            int fish = map[nx][ny];
            used[fish] = true;
            map[nx][ny] = 0;

            dfs(nx, ny, sum + fish, fishs[fish][2]);
            moved = true;

            map = mapBackup;
            fishs = fishsBackup;
            used = usedBackup;

            mul++;
        }

        if (!moved) {
            max = Math.max(max, sum);
            return;
        }
    }
}
