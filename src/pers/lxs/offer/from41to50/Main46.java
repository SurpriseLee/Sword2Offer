package pers.lxs.offer.from41to50;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class Main46 {
	@Test
	public void test() {
		int n = 5;
		int m = 3;

		System.out.println(LastRemaining_Solution(n, m));
	}

	public int LastRemaining_Solution(int n, int m) {
		if ((n <= 0) || (m <= 0)) {
			return -1;
		}

		Deque<Integer> queue = new ArrayDeque<Integer>();

		int index = 0;
		while (index < n) {
			queue.offerLast(Integer.valueOf(index++));
		}

		index = 0;
		while (queue.size() > 1) {
			int temp = ((Integer) queue.pollFirst()).intValue();

			if (index == m - 1) {
				index = 0;
			} else {
				queue.offerLast(Integer.valueOf(temp));
				index++;
			}
		}

		return ((Integer) queue.pollFirst()).intValue();
	}
}