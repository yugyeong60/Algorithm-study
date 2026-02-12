import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] tire = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String tmp = sc.next();
            for (int j = 0; j < 8; j++)
                tire[i][j] = tmp.charAt(j) - '0';
        }

        int[][] pnter = new int[4][2];
        for (int i = 0; i < 4; i++) {
            pnter[i][0] = 6; // 왼쪽
            pnter[i][1] = 2; // 오른쪽
        }

        int K = sc.nextInt();
        for (int k = 0; k < K; k++) {
            int num = sc.nextInt() - 1;
            int dir = sc.nextInt();

            boolean[] moved = new boolean[4];
            moved[num] = true;

            int[] allD = new int[4];
            allD[num] = dir;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{num, allD[num]});

//            오른쪽
            if (num != 3) {
                for (int i = num; i < 3; i++) {
                    if (moved[i] && tire[i][pnter[i][1]] != tire[i + 1][pnter[i + 1][0]]) {

                        if (allD[i] == 1) allD[i + 1] = -1;
                        else allD[i + 1] = 1;

                        q.add(new int[]{i + 1, allD[i + 1]});
                        moved[i + 1] = true;
                    } else break;
                }
            }
//            왼쪽
            if (num != 0) {
                for (int i = num; i > 0; i--) {
                    if (moved[i] && tire[i][pnter[i][0]] != tire[i - 1][pnter[i - 1][1]]) {
                        if (allD[i] == 1) allD[i - 1] = -1;
                        else allD[i - 1] = 1;

                        q.add(new int[]{i - 1, allD[i - 1]});
                        moved[i - 1] = true;
                    } else break;
                }
            }

//            실제 회전
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                int tmpN = tmp[0];
                int tmpD = tmp[1];

                int plus = 0;
                if (tmpD == 1) plus = 7;
                else plus = 1;

                for (int t = 0; t < 2; t++)
                    pnter[tmpN][t] = (pnter[tmpN][t] + plus) % 8;
            }
        }

//        12시 방향
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int dir = (pnter[i][0] + 2) % 8;
            result += (int) (tire[i][dir] * Math.pow(2, i));
        }
        System.out.println(result);
    }
}
