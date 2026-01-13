import java.util.Scanner;

class Main {

    static int[][] map; // 10x10 색종이
    static int[] cnt; // 사용수
    static int min;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                map[i][j] = sc.nextInt();
        }

        cnt = new int[6];
        min = Integer.MAX_VALUE;
        dfs(0, 0);

        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void dfs(int x, int y) {
        // 도달했을 때
        if (x == 0 && y == 10) {
            int sum = 0;
            for (int n : cnt)
                sum += n;

            min = Math.min(min, sum);
            return;
        }

        // 0일 때
        if (map[x][y] == 0) {
            if (x == 9)
                dfs(0, y + 1);
            else
                dfs(x + 1, y);
        }

        // 1일 때
        if (map[x][y] == 1) {

            int max = -1;

            for (int tmp = 5; tmp >= 1; tmp--) {

                // 가능 여부 확인
                boolean isOk2 = true;
                for (int dx = 0; dx < tmp; dx++) { // x
                    boolean isOk1 = true;
                    for (int dy = 0; dy < tmp; dy++) { // y
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 10 || ny >= 10 || map[nx][ny] == 0) {
                            isOk1 = false;
                            break;
                        }
                    }

                    if (!isOk1) {
                        isOk2 = false;
                        break;
                    }
                }

                // 성공시
                if (isOk2 && cnt[tmp] < 5) {
                    max = tmp;
                    for (int dx = 0; dx < max; dx++) {
                        for (int dy = 0; dy < max; dy++) {
                            int nx = dx + x;
                            int ny = dy + y;

                            map[nx][ny] = 0;
                        }
                    }
                    cnt[max]++;

                    if (x == 9)
                        dfs(0, y + 1);
                    else
                        dfs(x + 1, y);

                    for (int dx = 0; dx < max; dx++) {
                        for (int dy = 0; dy < max; dy++) {
                            int nx = dx + x;
                            int ny = dy + y;

                            map[nx][ny] = 1;
                        }
                    }
                    cnt[max]--;
                }
            }

            // 불가능시
            if (max == -1) {
                return;
            }

        }

    }
}