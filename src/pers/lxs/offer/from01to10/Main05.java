package pers.lxs.offer.from01to10;

import java.util.Stack;
import org.junit.Test;

public class Main05 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	@Test
	public void test() {
		int[] a = { 1, 2, 4, 7, 3, 5, 8, 6 };

		for (int i = 0; i < a.length; i++) {
			push(a[i]);
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(pop() + " ");
		}
		System.out.println();
	}

	public void push(int node) {
		this.stack1.push(Integer.valueOf(node));
	}

	public int pop() {
		while (!this.stack1.isEmpty()) {
			this.stack2.push((Integer) this.stack1.pop());
		}

		int result = ((Integer) this.stack2.pop()).intValue();

		while (!this.stack2.isEmpty()) {
			this.stack1.push((Integer) this.stack2.pop());
		}

		return result;
	}
}