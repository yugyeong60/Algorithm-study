import java.util.Scanner;

class Solution {

	static int dayPrice;
	static int monthPrice;
	static int month3Price;
	static int yearPrice;
	static int[] plan;
	static int price;
	static int min;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			dayPrice = sc.nextInt();
			monthPrice = sc.nextInt();
			month3Price = sc.nextInt();
			yearPrice = sc.nextInt();
			plan = new int[13];

			for (int i = 1; i <= 12; i++) {
				plan[i] = sc.nextInt();
			}

			min = yearPrice;
			dfs(1);
			System.out.println("#" + test_case + " " + min);
		}

	}

	static void dfs(int month) {
		if (month > 12) {
			min = Math.min(min, price);
			return;
		}

//		1일권
		price += (plan[month] * dayPrice);
		dfs(month + 1);
		price -= (plan[month] * dayPrice);

//		1달권
		price += monthPrice;
		dfs(month + 1);
		price -= monthPrice;

//		3달권
		price += month3Price;
		dfs(month + 3);
		price -= month3Price;

	}

}