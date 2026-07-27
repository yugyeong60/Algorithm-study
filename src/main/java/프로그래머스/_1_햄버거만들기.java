package 프로그래머스;

public class _1_햄버거만들기 {
}
//import java.util.*;
//
//class Solution {
//    public int solution(int[] ingredient) {
//
//        int answer = 0;
//
//        int[] stack = new int[ingredient.length];
//        int size = 0;
//
//        for (int x : ingredient) {
//            stack[size++] = x;
//
//            if (size >= 4
//                    && stack[size - 1] == 1
//                    && stack[size - 2] == 3
//                    && stack[size - 3] == 2
//                    && stack[size - 4] == 1) {
//
//                size -= 4;
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//}