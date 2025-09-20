import java.util.Scanner;

class Solution {
    static int D, W, K;
    static int[][] map;
    static int answer;
    
//    각 행을 그냥 두기/A로 바꾸기/B로 바꾸기 >> 검사

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();

            map = new int[D][W];
            for (int i = 0; i < D; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            answer = K; // 최악의 경우 K줄 모두 바꿔야 함

            if (check(map)) {
                answer = 0; // 약품을 넣을 필요가 없을 때
            } else {
                dfs(0, 0);
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    // row번째 행을 어떻게 처리할지 결정
    static void dfs(int row, int cnt) {
        if (cnt >= answer) return; // 이미 최소 답보다 크면 중단
        
        if (row == D) { // 끝까지 왔을 때
            if (check(map)) answer = Math.min(answer, cnt);
            return;
        }

        // 원본 복사
        int[] backup = map[row].clone();

        // 1) 그대로 둠
        dfs(row + 1, cnt);

        // 2) A(0)로 덮음
        for (int c = 0; c < W; c++) map[row][c] = 0;
        dfs(row + 1, cnt + 1);

        // 3) B(1)로 덮음
        for (int c = 0; c < W; c++) map[row][c] = 1;
        dfs(row + 1, cnt + 1);

        // 원복
        for (int c = 0; c < W; c++) map[row][c] = backup[c];
    }

    // 성능검사
    static boolean check(int[][] board) {
        for (int c = 0; c < W; c++) {
            boolean pass = false;
            for (int r = 0; r <= D - K; r++) {
                int val = board[r][c];
                boolean ok = true;
                for (int t = 1; t < K; t++) {
                    if (board[r + t][c] != val) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    pass = true;
                    break;
                }
            }
            if (!pass) return false;
        }
        return true;
    }
}
