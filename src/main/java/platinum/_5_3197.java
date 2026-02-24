import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();

        int[] srt = new int[2];
        srt[0] = -1;
        int[] end = new int[2];

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String row = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'L') {
                    if (srt[0] == -1) {
                        srt[0] = i;
                        srt[1] = j;
                    } else {
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int cnt = 0;

//        물
        Queue<int[]> waterQ = new ArrayDeque<>();
        Queue<int[]> nextWaterQ = new ArrayDeque<>();
        boolean[][] usedIce = new boolean[R][C];

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] != 'X') {
                    waterQ.add(new int[]{x, y});
                    usedIce[x][y] = true;
                }
            }
        }

//        백조
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> nextQ = new LinkedList<>();
        boolean[][] used = new boolean[R][C];

        q.add(new int[]{srt[0], srt[1]});
        used[srt[0]][srt[1]] = true;

        while (true) { // 도달 여부

//            건너기
            boolean isOk = false;

            while (!q.isEmpty()) {
                int[] tmp = q.poll();

                if (tmp[0] == end[0] && tmp[1] == end[1]) { // 도달
                    isOk = true;
                    break;
                }

                for (int t = 0; t < 4; t++) {
                    int nx = tmp[0] + dx[t];
                    int ny = tmp[1] + dy[t];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if (used[nx][ny]) continue;

                    used[nx][ny] = true;

                    if (map[nx][ny] == 'X') {
                        nextQ.add(new int[]{nx, ny}); // 내일
                    } else {
                        q.add(new int[]{nx, ny}); // 오늘
                    }
                }
            }

            if (isOk) {
                System.out.println(cnt);
                break;
            }

//            녹이기
            while (!waterQ.isEmpty()) {
                int[] tmp = waterQ.poll();

                for (int t = 0; t < 4; t++) {
                    int nx = tmp[0] + dx[t];
                    int ny = tmp[1] + dy[t];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if (usedIce[nx][ny]) continue;

                    usedIce[nx][ny] = true;

                    if (map[nx][ny] == 'X') {
                        map[nx][ny] = '.'; // 다음 날부터 물
                        nextWaterQ.add(new int[]{nx, ny});
                    } else {
                        waterQ.add(new int[]{nx, ny});
                    }
                }
            }

//            갱신
            q = nextQ;
            nextQ = new LinkedList<>();

            waterQ = nextWaterQ;
            nextWaterQ = new LinkedList<>();

            cnt++;
        }
    }
}