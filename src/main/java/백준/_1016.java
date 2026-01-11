import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long min = sc.nextLong();
		long max = sc.nextLong();

		int len = (int) (max - min + 1);
		boolean[] isNot = new boolean[len];

		for (long i = 2; i <= Math.sqrt(max); i++) {
			long mul = min / (i * i);
			if(min % (i * i) != 0)
				mul++;
			
			while (i * i * mul <= max) {
				isNot[(int) (i * i * mul - min)] = true;
				mul++;
			}
		}
		
		long cnt = 0;
		for (boolean tf: isNot) {
			if (!tf)
				cnt++;
		}
		
		System.out.println(cnt);
			

	}

}
