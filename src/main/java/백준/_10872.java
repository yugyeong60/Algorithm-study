import java.util.*;

public class Main {
    static int n; // 재료 개수
    static int[][][] effects; // [재료번호][4][4]
    static char[][][] colors; // [재료번호][4][4]
    static int maxScore = Integer.MIN_VALUE;

    static int[][] furnaceQ; // 5x5 품질
    static char[][] furnaceC; // 5x5 색상

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        effects = new int[n][4][4];
        colors = new char[n][4][4];

        // 입력
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    effects[k][i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    colors[k][i][j] = sc.next().charAt(0);
                }
            }
        }

        // 3개 선택 (순서 있음)
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (b == a) continue;
                for (int c = 0; c < n; c++) {
                    if (c == a || c == b) continue;

                    // 초기화
                    furnaceQ = new int[5][5];
                    furnaceC = new char[5][5];
                    for (int i = 0; i < 5; i++) Arrays.fill(furnaceC[i], 'W');

                    // 3개 재료를 배치 시도
                    dfsApply(new int[]{a, b, c}, 0);
                }
            }
        }

        System.out.println(maxScore);
    }

    // 색상 업데이트
    static char updateColor(char oldColor, char newColor) {
        if (newColor == 'W') return oldColor;
        return newColor;
    }

    // 재료 적용
    static void applyMaterial(int matIdx, int rotate, int x, int y) {
        int[][] matQ = rotateMatrix(effects[matIdx], rotate);
        char[][] matC = rotateMatrixChar(colors[matIdx], rotate);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int ni = x + i;
                int nj = y + j;

                // 품질 갱신
                furnaceQ[ni][nj] += matQ[i][j];
                if (furnaceQ[ni][nj] < 0) furnaceQ[ni][nj] = 0;
                if (furnaceQ[ni][nj] > 9) furnaceQ[ni][nj] = 9;

                // 색상 갱신
                furnaceC[ni][nj] = updateColor(furnaceC[ni][nj], matC[i][j]);
            }
        }
    }

    // 원래 상태 복원용 깊은 복사
    static int[][] copyInt(int[][] arr) {
        int[][] res = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) res[i] = arr[i].clone();
        return res;
    }

    static char[][] copyChar(char[][] arr) {
        char[][] res = new char[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) res[i] = arr[i].clone();
        return res;
    }

    // 3개 재료 배치 (DFS 느낌)
    static void dfsApply(int[] mats, int depth) {
        if (depth == 3) {
            maxScore = Math.max(maxScore, calcScore());
            return;
        }

        int matIdx = mats[depth];
        int[][] backupQ = copyInt(furnaceQ);
        char[][] backupC = copyChar(furnaceC);

        for (int rot = 0; rot < 4; rot++) {
            for (int x = 0; x <= 1; x++) {
                for (int y = 0; y <= 1; y++) {
                    applyMaterial(matIdx, rot, x, y);
                    dfsApply(mats, depth + 1);
                    furnaceQ = copyInt(backupQ);
                    furnaceC = copyChar(backupC);
                }
            }
        }
    }

    // 점수 계산
    static int calcScore() {
        int R = 0, B = 0, G = 0, Y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                switch (furnaceC[i][j]) {
                    case 'R': R += furnaceQ[i][j]; break;
                    case 'B': B += furnaceQ[i][j]; break;
                    case 'G': G += furnaceQ[i][j]; break;
                    case 'Y': Y += furnaceQ[i][j]; break;
                }
            }
        }
        return 7*R + 5*B + 3*G + 2*Y;
    }

    // 회전 함수 (효능)
    static int[][] rotateMatrix(int[][] mat, int rot) {
        int[][] res = new int[4][4];
        for (int r = 0; r < rot; r++) {
            int[][] tmp = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    tmp[j][3-i] = mat[i][j];
                }
            }
            mat = tmp;
        }
        return mat;
    }

    // 회전 함수 (색상)
    static char[][] rotateMatrixChar(char[][] mat, int rot) {
        char[][] res = new char[4][4];
        for (int r = 0; r < rot; r++) {
            char[][] tmp = new char[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    tmp[j][3-i] = mat[i][j];
                }
            }
            mat = tmp;
        }
        return mat;
    }
}
