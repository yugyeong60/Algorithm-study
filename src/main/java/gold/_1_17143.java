import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();

        if (M == 0) {
            System.out.println(0);
            return;
        }

        List<int[]> fishs = new ArrayList<>();
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int m = 0; m < M; m++) {
//            r, c, s(속력), d(방향), z(크기)
            int[] fish = {sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt(), sc.nextInt(), sc.nextInt()};
            fishs.add(fish);
            map[fish[0]][fish[1]] = m;
        }

        boolean[][] moved = new boolean[R][C];
        int sum = 0;
        int[] dr = {0, -1, 1, 0, 0};
        int[] dc = {0, 0, 0, 1, -1};
        boolean[] eat = new boolean[M];

        for (int c = 0; c < C; c++) {
//            1. 낚시왕 이동 (for문)

//            2. 상어 잡아먹기
            for (int r = 0; r < R; r++) {
                if (map[r][c] != -1) {
                    int m = map[r][c];
                    sum += fishs.get(m)[4];
                    map[r][c] = -1;
                    eat[m] = true;
                    break;
                }
            }

            int[][] newMap = new int[R][C];
            for (int i = 0; i < R; i++) {
                Arrays.fill(newMap[i], -1);
            }

//            3. 상어 이동
            moved = new boolean[R][C];
            for (int m = 0; m < M; m++) {
                if (eat[m]) continue;

                int[] fish = fishs.get(m);

                int speed = fish[2];
                if (fish[3] == 1 || fish[3] == 2) {
                    if (R > 1) speed %= (2 * (R - 1));
                    else speed = 0;
                } else {
                    if (C > 1) speed %= (2 * (C - 1));
                    else speed = 0;
                }

                for (int d = 0; d < speed; d++) {
                    if (fish[0] == 0 && fish[3] == 1) fish[3] = 2;
                    else if (fish[0] == R - 1 && fish[3] == 2) fish[3] = 1;
                    else if (fish[1] == C - 1 && fish[3] == 3) fish[3] = 4;
                    else if (fish[1] == 0 && fish[3] == 4) fish[3] = 3;

                    fish[0] += dr[fish[3]];
                    fish[1] += dc[fish[3]];
                }

//                한 자리에 2마리가 있다면
                if (newMap[fish[0]][fish[1]] == -1) {
                    newMap[fish[0]][fish[1]] = m;
                } else {
                    int tmp = newMap[fish[0]][fish[1]];
                    if (fishs.get(tmp)[4] < fish[4]) {
                        eat[tmp] = true;
                        newMap[fish[0]][fish[1]] = m;
                    } else {
                        eat[m] = true;
                    }
                }
            }
            map = newMap;
        }

        System.out.println(sum);
    }
}