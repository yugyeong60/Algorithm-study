import java.util.ArrayList;
import java.util.Scanner;

// 계산 순서 재배열
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
        dfs(nums, opers);
        System.out.println(max);

    }

    static void dfs(ArrayList<Integer> nums, ArrayList<Character> opers) {
        if (opers.size() == 0) {
            max = Math.max(max, nums.get(0));
            return;
        }

        for (int i = 0; i < opers.size(); i++) {
            ArrayList<Integer> newNums = new ArrayList<>(nums);
            ArrayList<Character> newOpers = new ArrayList<>(opers);

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
            newNums.remove(i+1);
            newNums.remove(i);
            newNums.add(i, n);
            newOpers.remove(i);

            dfs(newNums, newOpers);


        }
    }
}
