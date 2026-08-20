package 프로그래머스.고득점Kit.DFS_BFS;

public class _2_단어변환 {

//    import java.util.*;
//
//    class Solution {
//        public int solution(String begin, String target, String[] words) {
//
//            int len = words.length;
//            int len_word = target.length();
//            boolean[] used = new boolean[len];
//
//            Queue<int[]> q = new LinkedList<>();
//            int result = 0;
//
////        초기
//            for (int i = 0; i < len; i++) {
//                String new_word = words[i];
//
//                int cnt = 0;
//                for (int j = 0; j < len_word; j++) {
//                    if (begin.charAt(j) != new_word.charAt(j)) cnt++;
//                }
//
//                if (cnt == 1) {
//                    q.add(new int[]{i, 1});
//                    used[i] = true;
//                }
//            }
//
////        bfs
//            while (!q.isEmpty()) {
//                int[] tmp = q.poll();
//                String word = words[tmp[0]];
//                int n = tmp[1];
//
//                boolean isOk = true;
//                for (int j = 0; j < len_word; j++) {
//                    if (word.charAt(j) != target.charAt(j)) {
//                        isOk = false;
//                        break;
//                    }
//                }
//
//                if (isOk) {
//                    result = n;
//                    break;
//                }
//
//                for (int i = 0; i < len; i++) {
//                    if (used[i]) continue;
//
//                    String new_word = words[i];
//
//                    int cnt = 0;
//                    for (int j = 0; j < len_word; j++) {
//                        if (word.charAt(j) != new_word.charAt(j)) cnt++;
//                    }
//
//                    if (cnt == 1) {
//                        q.add(new int[]{i, n + 1});
//                        used[i] = true;
//                    }
//                }
//            }
//
//            return result;
//        }
//    }

}
