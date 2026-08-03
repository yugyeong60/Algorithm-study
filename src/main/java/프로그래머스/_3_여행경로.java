package 프로그래머스;

public class _3_여행경로 {

//    import java.util.*;
//
//    class Solution {
//
//        static int len;
//        static String[] result;
//        static Map<String, List<String>> list;
//
//        public String[] solution(String[][] tickets) {
//            list = new LinkedHashMap<>();
//            for (String[] ticket : tickets) {
//                list.computeIfAbsent(ticket[0], key -> new ArrayList<>())
//                        .add(ticket[1]);
//            }
//            len = tickets.length;
//            result = new String[len + 1];
//
//            boolean[] used = new boolean[len];
//            String[] re = new String[len + 1];
//
//            for (int i = 0; i < len; i++) {
//
//                if (!tickets[i][0].equals("ICN")) continue;
//
//                used[i] = true;
//                re[0] = tickets[i][0];
//                re[1] = tickets[i][1];
//
//                dfs(2, used, tickets[i][1], tickets, re);
//
//                used[i] = false;
//            }
//
//            return result;
//        }
//
//        static void dfs(int depth, boolean[] used, String start, String[][] tickets, String[] re) {
//            if (depth == len + 1) {
//                if (result[0] == null) {
//                    result = re.clone();
//                    return;
//                }
//
//                for (int i = 0; i < len + 1; i++) {
//                    if (result[i].compareTo(re[i]) > 0) {
//                        result = re.clone();
//                        break;
//                    } else if (result[i].compareTo(re[i]) < 0)
//                        break;
//                }
//                return;
//            }
//
//            for (int i = 0; i < len; i++) {
//                if (used[i]) continue;
//
//                if (start.equals(tickets[i][0])) {
//                    used[i] = true;
//                    re[depth] = tickets[i][1];
//
//                    dfs(depth + 1, used, tickets[i][1], tickets, re);
//
//                    used[i] = false;
//                }
//            }
//
//        }
//    }

}
