import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] map = new int[N][N]; // 미로 0: 이동불가/ 1: 이동가능
        for (int i = 0; i < N; i++) {
            String srt = sc.next();
            for (int j = 0; j < N; j++)
                map[i][j] = srt.charAt(j) - '0';
        }

        ArrayList<Integer> result = new ArrayList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    map[i][j] = 0;
                    int max = 1;

                    while (!q.isEmpty()) {
                        int[] tmp = q.poll();


                        boolean moved = false;
                        for (int k = 0; k < 4; k++) {
                            int nx = tmp[0] + dx[k];
                            int ny = tmp[1] + dy[k];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                            if (map[nx][ny] == 1) {
                                q.add(new int[]{nx, ny});
                                map[nx][ny] = 0;
                                max++;
                            }
                        }
                    }

                    result.add(max);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int x : result)
            System.out.println(x);
    }

}
