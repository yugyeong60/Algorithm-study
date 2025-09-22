import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer>[] edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges[from].add(to);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] used = new boolean[N + 1];

        // 진입차수가 0인 노드(루트) 찾기
        int[] indegree = new int[N + 1];
        for (int from = 1; from <= N; from++) {
            for (int to : edges[from]) {
                indegree[to]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                used[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int from = q.poll();
            sb.append(from).append(" ");

            for (int to : edges[from]) {
                indegree[to]--;
                if (indegree[to] == 0 && !used[to]) {
                    q.add(to);
                    used[to] = true;
                }
            }
        }

        System.out.println(sb);
    }
}
