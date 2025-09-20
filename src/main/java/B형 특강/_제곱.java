
class Solution {

	public static void main(String args[]) throws Exception {
		int pow = pow(2, 10);
        // Math.pow(2, 10)과 동일
        
        System.out.println(pow(2, 10));

	}

//	n1의 n2 제곱 구하기
	static int pow(int x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x % 1000;

		int result = pow(x, n / 2);
		result = (result * result) % 1000; // 뒷자리 1000개만

		if (n % 2 == 1) // 홀수인 경우
			result = (result * x) % 1000;

		return result;

	}
}
