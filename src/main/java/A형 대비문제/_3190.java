import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] map = new int[N + 1][N + 1]; // 인덱스 1부터 사용
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r][c] = 1; // 사과 표시
        }

        int L = sc.nextInt();
        int[] moveS = new int[L + 1];
        String[] moveD = new String[L + 1];
        for (int i = 1; i <= L; i++) {
            moveS[i] = sc.nextInt();
            moveD[i] = sc.next();
        }

        int[] dr = {0, 1, 0, -1}; // 동, 남, 서, 북
        int[] dc = {1, 0, -1, 0};

        int time = 0;
        int nr = 1, nc = 1;
        int dir = 0;
        int cur = 1; // 현재 방향 전환 인덱스

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1, 1}); // 시작점

        while (true) {
            time++;
            nr += dr[dir];
            nc += dc[dir];

            // 벽 부딪힘
            if (nr <= 0 || nr > N || nc <= 0 || nc > N) break;

            // 자기 몸 부딪힘
            for (int[] s : snake) {
                if (s[0] == nr && s[1] == nc) {
                    System.out.println(time);
                    return;
                }
            }

            // 사과 확인
            if (map[nr][nc] == 1) {
                map[nr][nc] = 0; // 사과 먹음
                snake.addFirst(new int[]{nr, nc}); // 길이 증가
            } else {
                snake.addFirst(new int[]{nr, nc}); // 머리 추가
                snake.pollLast(); // 꼬리 제거
            }

            // 방향 전환 시점 확인
            if (cur <= L && time == moveS[cur]) {
                if (moveD[cur].equals("D")) dir = (dir + 1) % 4;
                else dir = (dir + 3) % 4;
                cur++;
            }
        }
        System.out.println(time);
    }
}
