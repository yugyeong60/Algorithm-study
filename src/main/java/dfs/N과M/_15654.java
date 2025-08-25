import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static LinkedList<Integer> arr = new LinkedList<>();
	static StringBuffer stringBuffer;
	static int[] nums;
	static boolean[] used;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		for (int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);

		used = new boolean[N];
		stringBuffer = new StringBuffer();
		
		
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
			if (!used[i]) {
				arr.add(nums[i]);
				used[i] = true;
				dfs(depth + 1);
				arr.removeLast();
				used[i] = false;
			}
		}
	}

}
