import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] srtP = new int[2]; // 상어 시작 위치
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    srtP[0] = i;
                    srtP[1] = j;
                }

            }
        }

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, -1, 0, 1};

        int size = 2;
        int cnt = 0;
        int time = 0;

        while (true) {
            boolean[][] moved = new boolean[N][N];
            Queue<int[]> q = new LinkedList<>();

            q.add(new int[]{srtP[0], srtP[1], 0}); // 행, 열, 거리
            moved[srtP[0]][srtP[1]] = true;

            int[] fish = new int[3]; // 행, 열, 거리
            Arrays.fill(fish, Integer.MAX_VALUE);

            while (!q.isEmpty()) { // 가장 가까문 물고기 찾기
                int[] pnt = q.poll();

                for (int t = 0; t < 4; t++) {
                    int ni = pnt[0] + di[t];
                    int nj = pnt[1] + dj[t];

                    if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
                    if (moved[ni][nj]) continue;

                    if (map[ni][nj] == size || map[ni][nj] == 0) { // 이동: O, 먹기: X
                        q.add(new int[]{ni, nj, pnt[2] + 1});
                        moved[ni][nj] = true;
                        continue;
                    }

                    if (map[ni][nj] < size && fish[2] >= pnt[2] + 1) { // 이동: O, 먹기: 0
                        if (ni < fish[0] || (ni == fish[0] && nj < fish[1])) {
                            fish[0] = ni;
                            fish[1] = nj;
                            fish[2] = pnt[2] + 1;
                            moved[ni][nj] = true;
                        }
                    }

                }

            }

            if (fish[0] == Integer.MAX_VALUE)
                break;

            cnt++;
            time += fish[2];
            if (cnt == size) {
                cnt = 0;
                size++;
            }
            map[srtP[0]][srtP[1]] = 0;
            srtP[0] = fish[0];
            srtP[1] = fish[1];
            map[fish[0]][fish[1]] = 9;
        }

        System.out.println(time);
    }
}
