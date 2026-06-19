class Solution {
    public int solution(int n, int w, int num) {
        
        int ra = ((n - 1) / w) + 1;
        int rb = ((num - 1) / w) + 1;
        int answer = ra - rb + 1;
        
        if (w == 1) return answer;

        int[] map = new int[w];
        int t = n % w;
        if (t == 0) {
            for (int i=0; i<w; i++) map[i] = 1; 
        }
        
        if (ra % 2 == 0) { // 짝수 
            for (int i=0; i<t; i++) map[w - 1 - i] = 1;
        } else { // 홀수
            for (int i=0; i<t; i++) map[i] = 1;
        }
        
        t = num % w;
        if (rb % 2 == 0) { // 짝수 
            if (t == 0 && map[0] != 1 ) answer--;
            else if (t != 0 && map[w - t] != 1) answer--;
        } else { // 홀수
            if (t == 0 && map[w - 1] != 1) answer--;
            else if (t != 0 && map[t - 1] != 1) answer--;   
        }
        
        return answer;
    }
}