import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();
        }

        int[] di = {1, -1, 0, 0};
        int[] dj = {0, 0, 1, -1};

        int result = 0;

        while (true) {
            boolean[][] checked = new boolean[N][N];
            boolean isChange = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (checked[i][j]) continue;

                    Queue<int[]> q = new LinkedList<>();
                    ArrayList<int[]> pnt = new ArrayList<>();

                    q.add(new int[]{i, j});
                    pnt.add(new int[]{i, j}); // 연합 나라 위치
                    int sum = map[i][j]; // 연합 인구수
                    checked[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] p = q.poll();

                        for (int t = 0; t < 4; t++) {
                            int ni = p[0] + di[t];
                            int nj = p[1] + dj[t];

                            if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;

                            if (!checked[ni][nj] && Math.abs(map[p[0]][p[1]] - map[ni][nj]) >= L && Math.abs(map[p[0]][p[1]] - map[ni][nj]) <= R) {
                                q.add(new int[]{ni, nj});
                                pnt.add(new int[]{ni, nj});
                                sum += map[ni][nj];
                                checked[ni][nj] = true;
                            }
                        }
                    }

                    if (pnt.size() > 1) {
                        isChange = true;
                    }
                    int num = sum / pnt.size();
                    for (int[] p : pnt)
                        map[p[0]][p[1]] = num;
                }
            }
            if (!isChange) break;
            result++;

        }
        System.out.println(result);
    }
}
