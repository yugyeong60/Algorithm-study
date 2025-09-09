import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		StringBuffer sb = new StringBuffer();

		for (int test_case = 1; test_case <= T; test_case++) {

			int k = sc.nextInt();
			PriorityQueue<Integer> minQ = new PriorityQueue<>();
			PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
			HashMap<Integer, Integer> contains = new HashMap<>();
			for (int i = 0; i < k; i++) {
				String str = sc.next();
				int num = sc.nextInt();

//        		삽입
				if (str.equals("I")) {
					minQ.add(num);
					maxQ.add(num);
					if (!contains.containsKey(num))
						contains.put(num, 1);
					else
						contains.put(num, contains.get(num) + 1);
				}
//        		삭제
				else {
					if (contains.isEmpty())
						continue;
//					최댓값 삭제
					if (num == 1) {
						while (!maxQ.isEmpty()) {
							int v = maxQ.poll();
							if (contains.containsKey(v)) {
								contains.put(v, contains.get(v) - 1);
								if (contains.get(v) == 0)
									contains.remove(v);
								break;
							}
						}
					}
//					최솟값 삭제
					else if (num == -1) {
						while (!minQ.isEmpty()) {
							int v = minQ.poll();
							if (contains.containsKey(v)) {
								contains.put(v, contains.get(v) - 1);
								if (contains.get(v) == 0)
									contains.remove(v);
								break;
							}
						}
					}
				}
			}

//			힙 정리
//			최상단 값이 이미 삭제된 값이면 제거
			while (!minQ.isEmpty() && !contains.containsKey(minQ.peek()))
				minQ.poll();
			while (!maxQ.isEmpty() && !contains.containsKey(maxQ.peek()))
				maxQ.poll();

//			출력
			if (contains.isEmpty())
				sb.append("EMPTY").append("\n");
			else
				sb.append(maxQ.peek()).append(" ").append(minQ.peek()).append("\n");

		}
		System.out.println(sb);

	}

}
