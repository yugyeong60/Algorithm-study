package 프로그래머스.고득점Kit.완전탐색;

public class _2_피로도 {

    class Solution {

//        static int len;
//        static int result;
//
//        public int solution(int k, int[][] dungeons) {
//
//            len = dungeons.length;
//            result = Integer.MIN_VALUE;
//
//            boolean[] used = new boolean[len];
//            dfs(dungeons, 0, used, k);
//
//            return result;
//
//        }
//
//        static void dfs(int[][] dungeons ,int depth, boolean[] used, int fatigue ) {
//            if (depth == len) {
//                result = Integer.max(depth, result);
//                return;
//            }
//
//            boolean isOk = false;
//            for (int i = 0; i < len; i++) {
//                if (used[i]) continue;
//                if (fatigue < dungeons[i][0]) continue;
//
//                used[i] = true;
//                isOk = true;
//                fatigue -= dungeons[i][1];
//                dfs(dungeons, depth + 1, used, fatigue);
//                used[i] = false;
//                fatigue += dungeons[i][1];
//            }
//
//            if (!isOk) {
//                if (result < depth) {
//                    result = Integer.max(depth, result);
//                    return;
//                }
//            }
//
//        }
//
//
//    }

}
