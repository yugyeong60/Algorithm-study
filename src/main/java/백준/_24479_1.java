import java.util.*;

public class Main {

    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean[] used;
    static int[] result;
    static int order = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        // 인접 리스트 생성
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(v2);
            graph[v2].add(v1);  
        }

        // 정점 번호가 작은 것부터 방문하려면 정렬 필요
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        used = new boolean[N + 1];
        result = new int[N + 1];

        used[R] = true;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int start) {
        result[start] = order++;
        for (int next : graph[start]) {
            if (!used[next]) {
                used[next] = true;
                dfs(next);
            }
        }
    }
}
