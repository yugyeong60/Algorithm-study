import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N;
    static ArrayList<Character> opers;
    static ArrayList<Integer> nums;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        opers = new ArrayList<>();
        nums = new ArrayList<>();
        String s = sc.next();
        for (int i = 0; i < N - 1; i += 2) {
            nums.add(s.charAt(i) - '0');
            opers.add(s.charAt(i + 1));
        }
        nums.add(s.charAt(N - 1) - '0');

        max = Integer.MIN_VALUE;
        boolean[] used = new boolean[opers.size()];
        dfs(0, used);
        System.out.println(max);

    }

    static void dfs(int depth, boolean[] used ) {
        if (depth == opers.size()) {
            ArrayList<Integer> newNums = new ArrayList<>(nums);
            ArrayList<Character> newOpers = new ArrayList<>(opers);

            for (int i= used.length-1; i >= 0; i--) {
                if (!used[i]) continue;

                int a = newNums.get(i);
                int b = newNums.get(i + 1);
                char op = newOpers.get(i);

                int n = 0;
                if (op == '+') {
                    n = a + b;
                } else if (op == '-') {
                    n = a - b;
                } else if (op == '*') {
                    n = a * b;
                }

                newNums.remove(i + 1);
                newNums.remove(i);
                newNums.add(i, n);
                newOpers.remove(i);
            }

            int size = newOpers.size();
            for (int i=0; i<size; i++) {
                int a = newNums.get(0);
                int b = newNums.get(1);
                char op = newOpers.get(0);

                int n = 0;
                if (op == '+') {
                    n = a + b;
                } else if (op == '-') {
                    n = a - b;
                } else if (op == '*') {
                    n = a * b;
                }
                newNums.remove(1);
                newNums.remove(0);
                newNums.add(0, n);
                newOpers.remove(0);
            }

            max = Math.max(max, newNums.get(0));
            return;
        }

        if (depth == 0 || !used[depth-1]) { // 괄호 O
            used[depth] = true;
            dfs(depth+1, used);
            used[depth] = false;
        }

        dfs(depth + 1, used); // 괄호 X

    }
}
