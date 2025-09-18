import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            sum -= arr[i];
            result += (long)arr[i] * sum;
        }

        System.out.println(result);
    }
}
