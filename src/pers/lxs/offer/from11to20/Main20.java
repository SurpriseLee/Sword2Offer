package pers.lxs.offer.from11to20;

import java.util.Stack;
import org.junit.Test;

public class Main20 {
	Stack<Integer> stack = new Stack<Integer>();

	@Test
	public void test() {
		int[] array = { 4, 7, 2, 5, 5, 3, 8, 6 };

		for (int i : array) {
			push(i);
		}

		System.out.println(pop());
		System.out.println(top());
		System.out.println(min());
	}

	public void push(int node) {
		this.stack.push(Integer.valueOf(node));
	}

	public int pop() {
		return ((Integer) this.stack.pop()).intValue();
	}

	public int top() {
		return ((Integer) this.stack.peek()).intValue();
	}

	public int min() {
		Stack<Integer> temp = new Stack<Integer>();

		int min = 2147483647;

		while (!this.stack.isEmpty()) {
			int node = ((Integer) this.stack.pop()).intValue();
			min = node < min ? node : min;
			temp.push(Integer.valueOf(node));
		}

		while (!temp.isEmpty()) {
			this.stack.push((Integer) temp.pop());
		}

		return min;
	}
}