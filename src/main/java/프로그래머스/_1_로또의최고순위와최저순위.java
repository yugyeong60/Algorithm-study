package 프로그래머스;

public class _1_로또의최고순위와최저순위 {

//    import java.util.*;
//
//    class Solution {
//        public int[] solution(int[] lottos, int[] win_nums) {
//            Set<Integer> set = new HashSet<>();
//
//            for (int x : win_nums) {
//                set.add(x);
//            }
//
//            int cnt_zero = 0;
//            for (int x : lottos) {
//                if (x == 0) cnt_zero++;
//                else set.add(x);
//            }
//
//            int min = 12 - cnt_zero - set.size();
//            int max = min + cnt_zero;
//            int[] answer = new int[2];
//
//            if (min <= 1) answer[1] = 6;
//            else if (min == 2) answer[1] = 5;
//            else if (min == 3) answer[1] = 4;
//            else if (min == 4) answer[1] = 3;
//            else if (min == 5) answer[1] = 2;
//            else if (min == 6) answer[1] = 1;
//
//            if (max <= 1) answer[0] = 6;
//            else if (max == 2) answer[0] = 5;
//            else if (max == 3) answer[0] = 4;
//            else if (max == 4) answer[0] = 3;
//            else if (max == 5) answer[0] = 2;
//            else if (max == 6) answer[0] = 1;
//
//            return answer;
//
//        }
//    }

}
