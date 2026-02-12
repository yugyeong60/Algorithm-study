import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static ArrayList<int[]> cctv;
    static int min;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        cctv = new ArrayList<>(); // cctv: 행, 열, 번호
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] >= 1 && map[i][j] <= 5)
                    cctv.add(new int[]{i, j, map[i][j]});
            }
        }

        min = Integer.MAX_VALUE;
        dfs(0, map);
        System.out.println(min);
    }

    static void dfs(int depth, int[][] map) {
        if (depth == cctv.size()) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) cnt++;
                }
            }
            min = Math.min(min, cnt);
            return;
        }

        int[] tmp = cctv.get(depth); // 0: 행, 1: 열, 2: 번호

        if (tmp[2] == 1) { // 1번 cctv
            for (int i = 0; i < 4; i++) { // case 4개
                int[][] mapCopy = copy(map);
                int ni = tmp[0];
                int nj = tmp[1];

                while (true) {
                    ni += di[i];
                    nj += dj[i];

                    if (ni < 0 || ni >= N || nj < 0 || nj >= M) break;

                    if (mapCopy[ni][nj] == 0) mapCopy[ni][nj] = 8;
                    else if (mapCopy[ni][nj] == 6) break;
                }

                dfs(depth + 1, mapCopy);
            }
        } else if (tmp[2] == 2) { // 2번 cctv
            for (int i = 0; i < 2; i++) { // case 2개
                int[][] mapCopy = copy(map);
                for (int k = 0; k < 4; k += 2) {
                    int ni = tmp[0];
                    int nj = tmp[1];

                    while (true) {
                        int i1 = (i + k) % 4;
                        ni += di[i1];
                        nj += dj[i1];

                        if (ni < 0 || ni >= N || nj < 0 || nj >= M) break;

                        if (mapCopy[ni][nj] == 0) mapCopy[ni][nj] = 8;
                        else if (mapCopy[ni][nj] == 6) break;
                    }

                }
                dfs(depth + 1, mapCopy);
            }
        } else if (tmp[2] == 3) { // 3번 cctv
            for (int i = 0; i < 4; i++) { // case 4개
                int[][] mapCopy = copy(map);
                for (int k = 0; k < 2; k++) {
                    int ni = tmp[0];
                    int nj = tmp[1];

                    while (true) {
                        int i1 = (i + k) % 4;
                        ni += di[i1];
                        nj += dj[i1];

                        if (ni < 0 || ni >= N || nj < 0 || nj >= M) break;

                        if (mapCopy[ni][nj] == 0) mapCopy[ni][nj] = 8;
                        else if (mapCopy[ni][nj] == 6) break;
                    }

                }
                dfs(depth + 1, mapCopy);
            }

        } else if (tmp[2] == 4) { // 4번 cctv
            for (int i = 0; i < 4; i++) { // case 4개
                int[][] mapCopy = copy(map);
                for (int k = 0; k < 3; k++) {
                    int ni = tmp[0];
                    int nj = tmp[1];

                    while (true) {
                        int i1 = (i + k) % 4;
                        ni += di[i1];
                        nj += dj[i1];

                        if (ni < 0 || ni >= N || nj < 0 || nj >= M) break;

                        if (mapCopy[ni][nj] == 0) mapCopy[ni][nj] = 8;
                        else if (mapCopy[ni][nj] == 6) break;
                    }
                }
                dfs(depth + 1, mapCopy);
            }
        } else { // 5번 cctv
            int[][] mapCopy = copy(map);
            for (int i = 0; i < 4; i++) {
                int ni = tmp[0];
                int nj = tmp[1];

                while (true) {
                    ni += di[i];
                    nj += dj[i];

                    if (ni < 0 || ni >= N || nj < 0 || nj >= M) break;

                    if (mapCopy[ni][nj] == 0) mapCopy[ni][nj] = 8;
                    else if (mapCopy[ni][nj] == 6) break;
                }
            }
            dfs(depth + 1, mapCopy);
        }
    }

    static int[][] copy(int[][] src){
        int[][] dst = new int[N][M];
        for(int i=0;i<N;i++) dst[i] = src[i].clone();
        return dst;
    }

}
