import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();
        }

        int result = 0;

//        가로로 길게
        for (int i = 0; i < N; i++) {
            boolean isOk = true;
            int j = 0;
            boolean[] used = new boolean[N];

            while (j < N - 1) {
//                높이가 같을 때
                if (map[i][j] == map[i][j + 1]) {
                    j++;
                    continue;
                }
//                높이 차이가 1일 때
                if ((map[i][j] - map[i][j + 1]) == 1 && (j + L) <= (N - 1) && !used[j + 1]) {
//                    경사로를 둘 수 있는지
                    boolean isL = true;
                    for (int l = 1; l <= L; l++) {
                        if (map[i][j + 1] != map[i][j + l] || used[j + l]) {
                            isL = false;
                            break;
                        }
                    }

                    if (isL) {
                        for (int l = 1; l <= L; l++) {
                            used[j + l] = true;
                        }
                        j += L;
                    } else {
                        isOk = false;
                        break;
                    }
                }
//                높이 차이가 -1일 때
                else if ((map[i][j] - map[i][j + 1]) == -1 && (j - (L-1)) >= 0) {
                    boolean isL = true;
                    for (int l = 0; l < L; l++) {
                        if (map[i][j] != map[i][j - l] || used[j - l]) {
                            isL = false;
                            break;
                        }
                    }
                    if (isL) {
                        for (int l = 0; l < L; l++) {
                            used[j - l] = true;
                        }
                            j++;
                    } else {
                        isOk = false;
                        break;
                    }

                }
//                높이 차이가 2이상일 때
                else {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                result++;
            }
        }

//        세로로 길게
        for (int j = 0; j < N; j++) {
            boolean isOk = true;
            int i = 0;
            boolean[] used = new boolean[N];

            while (i < N - 1) {
//                높이가 같을 때
                if (map[i][j] == map[i + 1][j]) {
                    i++;
                    continue;
                }
//                높이 차이가 1일 때
                if ((map[i][j] - map[i + 1][j]) == 1 && (i + L) <= (N - 1) && !used[i + 1]) {
//                    경사로를 둘 수 있는지
                    boolean isL = true;
                    for (int l = 1; l <= L; l++) {
                        if (map[i + 1][j] != map[i + l][j] || used[i + l]) {
                            isL = false;
                            break;
                        }
                    }

                    if (isL) {
                        for (int l = 1; l <= L; l++) {
                            used[i + l] = true;
                        }
                        i += L;
                    } else {
                        isOk = false;
                        break;
                    }
                }
//                높이 차이가 -1일 때
                else if ((map[i][j] - map[i + 1][j]) == -1 && (i - (L-1)) >= 0) {
                    boolean isL = true;
                    for (int l = 0; l < L; l++) {
                        if (map[i][j] != map[i - l][j] || used[i - l]) {
                            isL = false;
                            break;
                        }
                    }

                    if (isL) {
                        for (int l = 0; l < L; l++) {
                            used[i - l] = true;
                        }
                        i++;
                    } else {
                        isOk = false;
                        break;
                    }

                }
//                높이 차이가 2이상일 때
                else {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                result++;
            }
        }

        System.out.println(result);
    }
}
