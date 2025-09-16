import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int price = sc.nextInt(); // 지불할 돈
		int money = 1000 - price; // 거스름 돈
		int[] change = { 500, 100, 50, 10, 5, 1 }; // 잔돈
		int cnt = 0; // 잔돈 개수

		for (int i = 0; i < 6; i++) {
			while (money >= change[i]) {
				money -= change[i];
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
