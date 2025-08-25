import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Main {

	static int N;
	static int M;
	static LinkedList<Integer> arr;
	static int[] nums;
	static StringBuffer stringBuffer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		
		stringBuffer = new StringBuffer();
		arr = new LinkedList<>();
		dfs(0);
		
		System.out.println(stringBuffer);
	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int x : arr) {
				stringBuffer.append(x).append(" ");
			}
			stringBuffer.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			arr.add(nums[i]);
			dfs(depth + 1);
			arr.removeLast();
		}
	}

}