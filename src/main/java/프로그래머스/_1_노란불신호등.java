package 프로그래머스;

class Solution {
	public int solution(int[][] signals) {
		int limit = 1;
		for (int[] signal : signals) {
			int period = signal[0] + signal[1] + signal[2];
			limit = lcm(limit, period);
		}

		int[] cnt = new int[limit + 1];
		int N = 0;
		for (int[] tmp : signals) {
			N++;
			int time = tmp[0];
			while (time <= limit) {
				for (int i = 0; i < tmp[1]; i++) {
					time++;
					if (time > limit)
						break;
					cnt[time]++;
				}
				time += tmp[0] + tmp[2];
			}
		}

		int answer = -1;
		for (int i = 1; i <= limit; i++) {
			if (cnt[i] != 0 && cnt[i] == N) {
				answer = i;
				break;
			}
		}

		return answer;
	}

	int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}

}
