import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {

	static int N;
	static int min;
	static boolean[][][] used;
	static Map<Integer, int[]> map;
	static int endX;
	static int endY;
	static int director;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();

			map = new HashMap<>();
			map.put(0,  new int[] { 0, 0 });
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int apple = sc.nextInt();

					if (apple != 0) {
						map.put(apple, new int[] { i, j });
					}
				}
			}
			
			int result = 0;
			director = 0;
			
			for (int i=0; i<map.size()-1; i++ ) {
				used = new boolean[N][N][4];
				min = Integer.MAX_VALUE;
				int startX = map.get(i)[0];
				int startY = map.get(i)[1];
				
				endX = map.get(i+1)[0];
				endY = map.get(i+1)[1];
				
				dfs(startX, startY, director, 0);
				result += min;
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

	static void dfs(int x, int y, int dir, int turn) {
		if (x == endX && y == endY) {
			min = Math.min(min, turn);
			director = dir;
			return;
		}
		
		if (turn >= min) return;


		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
//		단순 직진
		int dirN = dir;
		int nx = x + dx[dirN];
		int ny = y + dy[dirN];
		
		if (nx >= 0 && nx < N && ny >= 0 && ny < N && !used[nx][ny][dirN]) {
			used[nx][ny][dirN] = true;
		    dfs(nx, ny, dirN, turn);
		    used[nx][ny][dirN] = false;
		}

//		회전 후 직진
		int dirY = (dir + 1) % 4;
		nx = x + dx[dirY];
		ny = y + dy[dirY];
		if (nx >= 0 && nx < N && ny >= 0 && ny < N && !used[nx][ny][dirY]) {
		    used[nx][ny][dirY] = true;
		    dfs(nx, ny, dirY, turn + 1);
		    used[nx][ny][dirY] = false;
		}

	}

}
