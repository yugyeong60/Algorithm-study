import java.util.Scanner;

class Solution {
	static int[] arr;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		arr = new int[1000000];
		for (int i = 0; i < 1000000; i++) {
			arr[i] = sc.nextInt();
		}

		mergeSort(0, 999999);
		System.out.println(arr[500000]);
	}

	static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
	}

	static void merge(int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int idx = 0;
		int[] tmp = new int[end - start + 1];;

		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				tmp[idx++] = arr[i++];
			} else {
				tmp[idx++] = arr[j++];
			}
		}

		while (j <= end)
			tmp[idx++] = arr[j++];

		while (i <= mid)
			tmp[idx++] = arr[i++];

		for (int k = start; k <= end; k++) {
			arr[k] = tmp[k - start];
		}
	}

}