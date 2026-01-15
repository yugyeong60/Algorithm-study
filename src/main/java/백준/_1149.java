import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] costs = new int[N][3]; // 각 집의 r, g, b, 비용
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++)
                costs[i][j] = sc.nextInt();
        }

//      dp
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] += Math.min(costs[i - 1][(j + 1) % 3], costs[i - 1][(j + 2) % 3]);
            }
        }

        int min = Math.min(costs[N - 1][0], costs[N - 1][1]);
        min = Math.min(costs[N - 1][2], min);
        System.out.println(min);

    }

}
