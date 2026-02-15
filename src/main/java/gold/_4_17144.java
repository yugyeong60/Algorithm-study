import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();

        int[] purifier = new int[2]; // 위 행, 아래 행
        Arrays.fill(purifier, -1);
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) {
                    if (purifier[0] == -1) purifier[0] = i;
                    else purifier[1] = i;
                }
            }
        }

        int[] di = {1, -1, 0, 0};
        int[] dj = {0, 0, 1, -1};

        for (int t = 0; t < T; t++) {
//            1. 미세먼지 확장
            int[][] tmp = new int[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == -1 || map[i][j] == 0 || map[i][j] < 5) continue;

                    int cnt = 0;

                    for (int k = 0; k < 4; k++) { //  상하좌우 확장
                        int ni = i + di[k];
                        int nj = j + dj[k];

                        if (ni < 0 || ni >= R || nj < 0 || nj >= C) continue;
                        if (map[ni][nj] == -1) continue;

                        tmp[ni][nj] += (map[i][j] / 5);
                        cnt++;
                    }

//                    (r, c)에 남은 미세먼지 양
                    tmp[i][j] -= ((map[i][j] / 5) * cnt);

                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++)
                    map[i][j] += tmp[i][j];
            }

//            2. 공기청정기 작동
//            -1) 반시계반향 회전
            for (int i = purifier[0] - 1; i > 0; i--)
                map[i][0] = map[i - 1][0];
            for (int j = 0; j < C - 1; j++)
                map[0][j] = map[0][j + 1];
            for (int i = 0; i < purifier[0]; i++)
                map[i][C - 1] = map[i + 1][C - 1];
            for (int j = C - 1; j > 1; j--)
                map[purifier[0]][j] = map[purifier[0]][j - 1];
            map[purifier[0]][1] = 0;

//            -2) 시계방향 회전
            for (int i = purifier[1] + 1; i < R - 1; i++)
                map[i][0] = map[i + 1][0];
            for (int j = 0; j < C - 1; j++)
                map[R - 1][j] = map[R - 1][j + 1];
            for (int i = R - 1; i > purifier[1]; i--)
                map[i][C - 1] = map[i - 1][C - 1];
            for (int j = C - 1; j > 1; j--)
                map[purifier[1]][j] = map[purifier[1]][j - 1];
            map[purifier[1]][1] = 0;

            map[purifier[0]][0] = -1;
            map[purifier[1]][0] = -1;
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                result += map[i][j];
        }
        System.out.println(result + 2);
    }
}
