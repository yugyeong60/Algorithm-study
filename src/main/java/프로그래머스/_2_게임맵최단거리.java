package 프로그래머스;

public class _2_게임맵최단거리 {

    //import java.util.*;
//
//    class Solution {
//        public int solution(int[][] maps) {
//
//            int answer = -1;
//            int x = maps.length;
//            int y = maps[0].length;
//
//            int[] dx = {1, -1, 0, 0};
//            int[] dy = {0, 0, 1, -1};
//
//            Queue<int[]> q = new LinkedList<>();
//            boolean[][] used = new boolean[x][y];
//            used[0][0] = true;
//            q.add(new int[] {0, 0, 1});
//            while (!q.isEmpty()) {
//                int[] pnt = q.poll();
//
//                if (pnt[0] == x-1 && pnt[1] == y-1) {
//                    answer = pnt[2];
//                    break;
//                }
//
//                for (int i=0; i<4; i++) {
//                    int nx = pnt[0] + dx[i];
//                    int ny = pnt[1] + dy[i];
//
//                    if (nx < 0 || ny < 0 || nx >= x || ny >= y) continue;
//                    if (maps[nx][ny] == 0) continue;
//
//                    if (!used[nx][ny]) {
//                        used[nx][ny] = true;
//                        q.add(new int[] {nx, ny, pnt[2] + 1});
//                    }
//                }
//            }
//
//            return answer;
//        }
//    }
    
}
