import java.util.Scanner;
 
class Solution {
 
    static int N;
    static boolean[] diagUp;
    static boolean[] diagDwn;
    static boolean[] cols;
 
    static int sum;
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
 
            diagUp = new boolean[2 * N - 1];
            diagDwn = new boolean[2 * N - 1];
            cols = new boolean[N];
         
            sum = 0;
            dfs(0);
 
            System.out.println("#" + test_case + " " + sum);
        }
    }
 
    static void dfs(int row) {
        if (row == N) {
            sum++;
            return;
        }
 
        for (int col = 0; col < N; col++) {
            if (!diagUp[row + col] && !diagDwn[row - col + N - 1] && !cols[col]) {
                diagUp[row + col] = true;
                diagDwn[row - col + N - 1] = true;
                cols[col] = true;
 
                dfs(row + 1);
 
                diagUp[row + col] = false;
                diagDwn[row - col + N - 1] = false;
                cols[col] = false;
 
 
            }
        }
 
    }
}