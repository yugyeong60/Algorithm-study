import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();

        int K = sc.nextInt();

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[] dx = {0, 0, 0, -1, 1}; // 동, 서, 북, 남
        int[] dy = {0, 1, -1, 0, 0};

//        주사위
//        1: 윗면, 6: 아랫면, 3: 동, 4: 서, 5: 북, 2: 남
        int[] dice = new int[7];
        for (int k = 0; k < K; k++) {
            int tmp = sc.nextInt();

            int nx = x + dx[tmp];
            int ny = y + dy[tmp];

//            바깥으로 이동시키려 하는 경우
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

//            회전
            int[] copy = Arrays.copyOf(dice, 7);
            if (tmp == 1) { // 동
                dice[1] = copy[4];
                dice[6] = copy[3];
                dice[3] = copy[1];
                dice[4] = copy[6];
            } else if (tmp == 2) { // 서
                dice[1] = copy[3];
                dice[6] = copy[4];
                dice[3] = copy[6];
                dice[4] = copy[1];
            } else if (tmp == 3) { // 북
                dice[1] = copy[2];
                dice[6] = copy[5];
                dice[5] = copy[1];
                dice[2] = copy[6];
            } else { // 남
                dice[1] = copy[5];
                dice[6] = copy[2];
                dice[5] = copy[6];
                dice[2] = copy[1];
            }

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[6];
            } else {
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }

//            좌표 갱신
            x = nx;
            y = ny;

//            윗면 출력
            System.out.println(dice[1]);

        }
    }
}
