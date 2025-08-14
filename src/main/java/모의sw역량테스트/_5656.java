package 모의sw역량테스트;

import java.util.ArrayDeque;
import java.util.Scanner;

class _5656 {

	static int W;
	static int H;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();

			int[][] arr = new int[H][W];

			for (int row = 0; row < H; row++) {
				for (int col = 0; col < W; col++) {
					arr[row][col] = sc.nextInt();
				}
			}

			int min = Integer.MAX_VALUE;

			if (N == 1) {
				for (int col = 0; col < W; col++) {
					int[][] copy = copyArray(arr);
					copy = totalBreakBlock(copy, col);
					min = Math.min(min, countBlock(copy));
				}
			} else if (N == 2) {
				for (int col1 = 0; col1 < W; col1++) {
					for (int col2 = 0; col2 < W; col2++) {
						int[][] copy = copyArray(arr);
						copy = totalBreakBlock(copy, col1);
						copy = totalBreakBlock(copy, col2);
						min = Math.min(min, countBlock(copy));
					}
				}
			} else if (N == 3) {
				for (int col1 = 0; col1 < W; col1++) {
					for (int col2 = 0; col2 < W; col2++) {
						for (int col3 = 0; col3 < W; col3++) {
							int[][] copy = copyArray(arr);
							copy = totalBreakBlock(copy, col1);
							copy = totalBreakBlock(copy, col2);
							copy = totalBreakBlock(copy, col3);
							min = Math.min(min, countBlock(copy));
						}
					}
				}
			} else if (N == 4) {
				for (int col1 = 0; col1 < W; col1++) {
					for (int col2 = 0; col2 < W; col2++) {
						for (int col3 = 0; col3 < W; col3++) {
							for (int col4 = 0; col4 < W; col4++) {
								int[][] copy = copyArray(arr);
								copy = totalBreakBlock(copy, col1);
								copy = totalBreakBlock(copy, col2);
								copy = totalBreakBlock(copy, col3);
								copy = totalBreakBlock(copy, col4);
								min = Math.min(min, countBlock(copy));
							}
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + min);
		}
	}

	public static int[][] breaks(int[][] arr, int row, int col) {
	    if (row < 0 || row >= H || col < 0 || col >= W) return arr;
	    if (arr[row][col] == 0) return arr;

	    ArrayDeque<int[]> queue = new ArrayDeque<>();
	    queue.add(new int[]{row, col, arr[row][col]});
	    arr[row][col] = 0; // 시작 벽돌 제거

	    int[] dr = {-1, 1, 0, 0};
	    int[] dc = {0, 0, -1, 1};

	    while (!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        int r = cur[0], c = cur[1], power = cur[2];

	        for (int d = 0; d < 4; d++) {
	            for (int dist = 1; dist < power; dist++) {
	                int nr = r + dr[d] * dist;
	                int nc = c + dc[d] * dist;
	                if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
	                if (arr[nr][nc] == 0) continue;
	                queue.add(new int[]{nr, nc, arr[nr][nc]});
	                arr[nr][nc] = 0;
	            }
	        }
	    }

	    return arr;
	}

	public static int[][] gravity(int[][] arr) {
	    for (int col = 0; col < W; col++) {
	        int writeRow = H - 1;
	        for (int row = H - 1; row >= 0; row--) {
	            if (arr[row][col] != 0) {
	                arr[writeRow][col] = arr[row][col];
	                if (writeRow != row) arr[row][col] = 0;
	                writeRow--;
	            }
	        }
	        while (writeRow >= 0) {
	            arr[writeRow][col] = 0;
	            writeRow--;
	        }
	    }
	    return arr;
	}

	public static int countBlock(int[][] arr) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (arr[i][j] != 0) {
					count++;
				}
			}
		}
		return count;
	}

//	전체 로직
	public static int[][] totalBreakBlock(int[][] arr, int col) {
//		공의 시작위치 찾기
		int row = 0;
		while (row < H && arr[row][col] == 0) {
			row++;
		}

//		벽돌 부수기, 아래로 내리기
        if (row < H) {
            arr = breaks(arr, row, col);
            arr = gravity(arr);
        }

		return arr;

	}

	public static int[][] copyArray(int[][] src) {
		int[][] newArr = new int[H][W];
		for (int i = 0; i < H; i++) {
			System.arraycopy(src[i], 0, newArr[i], 0, W);
		}
		return newArr;
	}

}