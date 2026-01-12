import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 가수의 수
        int M = sc.nextInt(); // 보조 PD의 수

        int[] cnt = new int[N + 1]; // 집입차수 수
        ArrayList<Integer>[] edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int n = sc.nextInt(); // 보조 PD가 담당한 가수의 수
            int srt = sc.nextInt();
            for (int j = 0; j < n - 1; j++) {
                int end = sc.nextInt();
                edges[srt].add(end);
                cnt[end]++;
                srt = end;
            }
        }

        StringBuffer sb = new StringBuffer(); // 결과
        Queue<Integer> q = new LinkedList<>();
        boolean[] used = new boolean[N + 1];
        used[0] = true;
        for (int i = 1; i <= N; i++) {
            if (!used[i] && cnt[i] == 0) {
                q.add(i);
                used[i] = true;
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append("\n");

            for (int y : edges[x]) {
                cnt[y]--;
                
                if (cnt[y] == 0){
                    q.add(y);
                    used[y] = true;
                }
            }
        }

        boolean isOk = true;
        for (boolean tf : used) {
            if (!tf) {
                isOk = false;
                break;
            }
        }

        if (isOk)
            System.out.println(sb);
        else
            System.out.println(0);
    }

}