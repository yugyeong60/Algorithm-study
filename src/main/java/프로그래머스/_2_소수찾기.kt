package 프로그래머스

class _2_소수찾기 {

//    import java.util.*;
//
//    class Solution {
//
//        static int len;
//        static Set<Integer> set;
//
//
//        public int solution(String numbers) {
//
//            len = numbers.length();
//            set = new HashSet<>();
//
//            int[] order = new int[len];
//            boolean[] used = new boolean[len];
//
//            dfs(0, order, numbers, used);
//
//            int answer = set.size();
//            return answer;
//        }
//
//
//        //    순열
//        static void dfs(int depth, int[] order, String numbers, boolean[] used) {
//            if (depth > 0) {
////            숫자로 변환
//                int num = 0;
//                for (int i = 0; i < depth; i++) {
//                    int n = numbers.charAt(order[i]) - '0';
//                    num = num * 10 + n;
//                }
//
////            소수 판별
//                boolean isOk = num >= 2;
//                for (int i = 2; i < num; i++) {
//                    if (num % i == 0) {
//                        isOk = false;
//                        break;
//                    }
//                }
//
//                if (isOk) {
//                    set.add(num);
//                }
//            }
//
//            if (depth == len) {
//                return;
//            }
//
//            for (int i = 0; i < len; i++) {
//                if (used[i]) continue;
//                if (numbers.charAt(i) == '0' && depth == 0) continue;
//
//                order[depth] = i;
//                used[i] = true;
//                dfs(depth + 1, order, numbers, used);
//                used[i] = false;
//            }
//        }
//    }

}