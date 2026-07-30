package 프로그래머스;

public class _3_네트워크 {

//    class Solution {
//
//        static boolean[] used;
//
//        public int solution(int n, int[][] computers) {
//            used = new boolean[n];
//            int result = 0;
//            for (int i=0; i<n; i++) {
//                if (!used[i]) {
//                    result++;
//                    used[i] = true;
//                    dfs(i, n, computers);
//                }
//            }
//            return result;
//        }
//
//        static void dfs(int target, int n, int[][] computers) {
//            if (target == n) return;
//
//            for (int i = 0; i < n; i++) {
//                if (!used[i] && computers[target][i] == 1) {
//                    used[i] = true;
//                    dfs(i, n, computers);
//                }
//            }
//        }
//    }
}
