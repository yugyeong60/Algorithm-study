import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int maxA = 0; // aj의 최대
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
            maxA = Math.max(maxA, arr[i]);
        }

//        시간 이분탐색
        long minT = 0; // 최소 시간
        long maxT = (long) (N - 1) * maxA; // 최대 시간

        while (minT < maxT) {
            long midT = (minT + maxT) / 2;

//            midT 안에 모든 소를 녹일 수 있는지 확인
            boolean isOk = true;
//            최종 교집합 히터 위치
            long L = 0;
            long R = N-1;

            for (int j=0; j<N; j++) { // 모든 소의 위치
//                해당 소(j)가 시간안(midT)에 녹을 수 있는
//                히터의 위치 구간[l, r] 찾기
                long Taj = midT / arr[j];

                long l = j - Taj;
                long r = j + Taj;

                if (l < 0) l = 0;
                if (r >= N) r = N-1;

                L = Math.max(L, l);
                R = Math.min(R, r);

                if (L > R) { // 모든 소가 만족하는 히더의 위치가 없다면
                    isOk = false;
                    break;
                }
            }

            if (isOk) { // 시간 안에 가능 > 줄이기
                maxT = midT;
            } else { //  시간 안에 불가능 > 늘리기
                minT = midT + 1;
            }

        }

        System.out.println(minT);
    }
}
