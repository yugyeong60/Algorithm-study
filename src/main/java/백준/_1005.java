import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test = 1; test <= T; test++) {

            int N = sc.nextInt(); // 건물의 수
            int K = sc.nextInt(); // 건물간의 건설순서 규칙의 총 개수

            int[] time = new int[N + 1]; // 건물당 건설에 걸리는 시간
            for (int i = 1; i <= N; i++)
                time[i] = sc.nextInt();

            ArrayList<Integer>[] edges = new ArrayList[N + 1]; // 건설 순서
            for (int i = 1; i <= N; i++)
                edges[i] = new ArrayList<>();

            int[] cnt = new int[N + 1]; // 선행되는 건설 수
            for (int i = 0; i < K; i++) {
                int srt = sc.nextInt();
                int end = sc.nextInt();
                edges[srt].add(end);
                cnt[end]++;
            }

            int W = sc.nextInt(); // 건설해야 하 건물의 번호

            Queue<Integer> q = new LinkedList<>();
            int[] dp = new int[N + 1];

            // 시작
            for (int i = 1; i <= N; i++) {
                if (cnt[i] == 0) {
                    q.add(i);
                    dp[i] = time[i];
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next : edges[cur]) {
                    dp[next] = Integer.max(dp[next], time[next] + dp[cur]);

                    cnt[next]--;
                    if (cnt[next] == 0)
                        q.add(next);

                }
            }

            System.out.println(dp[W]);
        }
    }

}