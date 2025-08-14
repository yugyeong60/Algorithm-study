package D4;

import java.util.Scanner;
import java.util.Random;

class _1824_2 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

//			값 받아와서 저장하기
			int R = sc.nextInt();
			int C = sc.nextInt();

			char[][] strings = new char[R][C];

			for (int i = 0; i < R; i++) {
				String string = sc.next();
				for (int j = 0; j < string.length(); j++) {
					strings[i][j] = string.charAt(j);
				}
			}

//			메모리, 진행방향, 현재 위치의 명령/행/열, 정지가능여부 
			int num = 0; 
			char dir = '>';
			int row = 0;
			int col = 0;
			char state = strings[row][col];
			String result = "YES";
			
//			시작 칸이 숫자일 떄
			if (Character.isDigit(state)) {
			    num = state - '0';
			}			

			// 무한 루프 방지용 visited[row][col][dirIndex][num]
			boolean[][][][] visited = new boolean[R][C][4][16];

			// 방향 인덱스 변환 함수
			java.util.Map<Character, Integer> dirMap = new java.util.HashMap<>();
			dirMap.put('^', 0);
			dirMap.put('>', 1);
			dirMap.put('v', 2);
			dirMap.put('<', 3);

//			@가 나올 때까지 무한 루프
			while (state != '@') {

				int dirIndex = dirMap.get(dir);

				if (visited[row][col][dirIndex][num]) {
					result = "NO"; // 같은 상태 반복 → 무한 루프
					break;
				}
				visited[row][col][dirIndex][num] = true;

				switch (state) {
				case '<':
					dir = '<';
					if (col == 0)
						col = C - 1;
					else
						col--;
					state = strings[row][col];
					break;

				case '>':
					dir = '>';
					if (col == C - 1)
						col = 0;
					else
						col++;
					state = strings[row][col];
					break;

				case '^':
					dir = '^';
					if (row == 0)
						row = R - 1;
					else
						row--;
					state = strings[row][col];
					break;

				case 'v':
					dir = 'v';
					if (row == R - 1)
						row = 0;
					else
						row++;
					state = strings[row][col];
					break;

				case '_':
					if (num == 0) {
						dir = '>';
						state = '>';
					} else {
						dir = '<';
						state = '<';
					}
					break;

				case '|':
					if (num == 0) {
						dir = 'v';
						state = 'v';
					} else {
						dir = '^';
						state = '^';
					}
					break;

				case '?':
					// 0~3 중 하나 랜덤 선택
					int r = rand.nextInt(4);
					if (r == 0) {
						dir = '^';
						state = '^';
					} else if (r == 1) {
						dir = '>';
						state = '>';
					} else if (r == 2) {
						dir = 'v';
						state = 'v';
					} else {
						dir = '<';
						state = '<';
					}
					break;

				case '.':
				    if (dir == '>') col = (col + 1) % C;
				    else if (dir == '<') col = (col - 1 + C) % C;
				    else if (dir == 'v') row = (row + 1) % R;
				    else if (dir == '^') row = (row - 1 + R) % R;
				    state = strings[row][col];
				    if (Character.isDigit(state)) num = state - '0';
				    break;

				case '+':
					if (num == 15) num = 0;
                   else num++;
					state = dir;
					break;

				 case '-':
                    if (num == 0) num = 15;
                    else num--;
                    state = dir;
                    break;
            }
			}

			System.out.println("#" + test_case + " " + result);

		}
	}
}