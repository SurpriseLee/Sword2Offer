package pers.lxs.offer.from51to60;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class Main54 {
	Deque<Character> queue = new ArrayDeque<Character>();

	@Test
	public void test() {
		String str = "abcdaefbcdef";
		char[] chs = str.toCharArray();

		for (char ch : chs) {
			Insert(ch);
		}

		System.out.println(this.queue.size());

		System.out.println(FirstAppearingOnce());
	}

	public void Insert(char ch) {
		if (!this.queue.contains(Character.valueOf(ch)))
			this.queue.offerLast(Character.valueOf(ch));
		else
			this.queue.remove(Character.valueOf(ch));
	}

	public char FirstAppearingOnce() {
		return this.queue.isEmpty() ? '#' : ((Character) this.queue.peekFirst()).charValue();
	}
}
