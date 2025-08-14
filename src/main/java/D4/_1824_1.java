package D4;

//	1. 상태(state) 정의
//		- 좌표: (row, col)
//		- 현재 방향: dir
//		- 메모리 값: num
//			이렇게 세 가지를 묶어서 한 번에 관리
//
//	2. 큐(BFS) 혹은 스택(DFS)에 상태를 넣음
//		- 시작점 (0,0, >, 0) 을 큐/스택에 넣고 시작
//		- 상태를 꺼내서 이동 → 새로운 상태를 또 큐/스택에 넣음
//	3. ?에서 처리
//		- ?를 만나면 4방향으로 모두 이동할 수 있으므로, 현재 상태에서 4개의 새로운 상태를 각각 큐/스택에 넣음
//		- 이렇게 하면 랜덤 선택 없이 모든 경로를 탐색할 수 있음
//	4. 방문 체크
//		- visited[row][col][dirIndex][num]
//		- 이미 방문한 상태는 다시 탐색하지 않음 → 무한 루프 방지

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class _1824_1 {
    static class State {
        int row, col, dir, num;
        State(int r, int c, int d, int n) { row = r; col = c; dir = d; num = n; }
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int R = sc.nextInt();
            int C = sc.nextInt();

            char[][] strings = new char[R][C];
            for (int i = 0; i < R; i++) {
                String string = sc.next();
                for (int j = 0; j < C; j++) {
                    strings[i][j] = string.charAt(j);
                }
            }

            boolean result = false;
            boolean[][][][] visited = new boolean[R][C][4][16];
            int[] dr = {-1, 0, 1, 0}; // ^ > v <
            int[] dc = {0, 1, 0, -1};

            Queue<State> q = new LinkedList<>();
            int startNum = 0;
            if (Character.isDigit(strings[0][0])) startNum = strings[0][0] - '0';
            q.add(new State(0, 0, 1, startNum)); // 시작은 오른쪽

            while (!q.isEmpty()) {
                State cur = q.poll();
                int row = cur.row, col = cur.col, dir = cur.dir, num = cur.num;
                char state = strings[row][col];

                if (state == '@') {
                    result = true;
                    break;
                }

                if (Character.isDigit(state)) num = state - '0';
                if (visited[row][col][dir][num]) continue;
                visited[row][col][dir][num] = true;

                int nextDir = dir;
                int nextNum = num;

                switch (state) {
                    case '<': nextDir = 3; break;
                    case '>': nextDir = 1; break;
                    case '^': nextDir = 0; break;
                    case 'v': nextDir = 2; break;
                    case '_': nextDir = (num == 0) ? 1 : 3; break;
                    case '|': nextDir = (num == 0) ? 2 : 0; break;
                    case '+': nextNum = (num == 15) ? 0 : num + 1; break;
                    case '-': nextNum = (num == 0) ? 15 : num - 1; break;
                    case '?':
                        // 네 방향 모두 시도
                        for (int d = 0; d < 4; d++) {
                            int nr = (row + dr[d] + R) % R;
                            int nc = (col + dc[d] + C) % C;
                            if (!visited[nr][nc][d][num]) q.add(new State(nr, nc, d, num));
                        }
                        continue; // 아래 이동은 건너뜀
                }

                int nr = (row + dr[nextDir] + R) % R;
                int nc = (col + dc[nextDir] + C) % C;
                if (!visited[nr][nc][nextDir][nextNum])
                    q.add(new State(nr, nc, nextDir, nextNum));
            }

            System.out.println("#" + test_case + " " + (result ? "YES" : "NO"));
        }
    }
}
