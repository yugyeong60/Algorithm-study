import java.util.*;

public class Main {

    static  int[][] map;
    static ArrayList<int[]> home;
    static ArrayList<int[]> chiken;
    static int[][] distAll;
    static boolean[] deleted;
    static int delete;
    static int min;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        home = new ArrayList<>();
        chiken = new ArrayList<>();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1)  // 집
                    home.add(new int[]{i, j});
                else if (map[i][j] == 2)  // 치킨집
                    chiken.add(new int[]{i, j});
            }
        }

//        집에서 치킨집 까지의 거리 모두 구해두기
        distAll = new int[home.size()][chiken.size()];
        for (int i=0; i<home.size(); i++) {
            for (int j=0; j<chiken.size(); j++)
                distAll[i][j] = Math.abs(home.get(i)[0] - chiken.get(j)[0]) + Math.abs(home.get(i)[1] - chiken.get(j)[1]);
        }



        delete = chiken.size() - M;
        min = Integer.MAX_VALUE;
        deleted = new boolean[chiken.size()];
        dfs(0, 0);

        System.out.println(min);
    }

    static void dfs(int depth, int start){
        if (depth == delete) { // 거리 계산
            int sum = 0;
            for (int i=0; i<home.size(); i++) {
                int dist = Integer.MAX_VALUE;
                for (int j=0; j<chiken.size(); j++) {
                    if (!deleted[j])
                        dist = Math.min(dist, distAll[i][j]);
                }
                sum += dist;
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i=start; i<chiken.size(); i++) {
            if (!deleted[i]) {
                deleted[i] = true;
                dfs(depth + 1, i+1);
                deleted[i] = false;
            }
        }
    }
}
