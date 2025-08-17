package 코드배틀;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt();
            Set<Integer> num = new HashSet<>();

            int x = 1;
            while (num.size() < 10) {
                int tmpNum = N * x;
                String tmpString = Integer.toString(tmpNum);

                for (int i = 0; i < tmpString.length(); i++) {
                    int number = tmpString.charAt(i) - '0';
                    num.add(number);
                }
                x++;
            }

            System.out.println("#" + test_case + " " + (N * (x - 1)));
        }
    }
}
