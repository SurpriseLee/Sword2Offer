package pers.lxs.offer.from21to30;

import org.junit.Test;

public class Main25 {
	@Test
	public void test() {
		int[] array = { 1, 2, 3, 4, 5, 3, 5, 101, 2, 102 };

		RandomListNode pHead = null;

		if (array.length > 0) {
			pHead = new RandomListNode(array[0]);
		}
		RandomListNode curr = pHead;
		for (int i = 1; i < array.length; i++) {
			curr.next = new RandomListNode(array[i]);
			curr = curr.next;
		}
		curr = pHead;
		while (curr != null) {
			System.out.print(curr.label + " ");
			curr = curr.next;
		}
		System.out.println();

		RandomListNode head = Clone(pHead);

		System.out.println("abc: " + head == null);

		while (head != null) {
			System.out.print(head.label + " ");
			head = head.next;
		}
		System.out.println();
	}

	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}

		RandomListNode curr = pHead;
		while (curr != null) {
			RandomListNode temp = new RandomListNode(curr.label);
			temp.next = curr.next;
			curr.next = temp;
			curr = temp.next;
		}

		curr = pHead;
		RandomListNode p = null;
		while (curr != null) {
			p = curr.next;
			RandomListNode temp = curr.random;

			if (temp != null) {
				p.random = temp.next;
			}

			curr = p.next;
		}

		RandomListNode head = new RandomListNode(0);
		curr = pHead;
		p = head;
		while (curr != null) {
			p.next = curr.next;
			curr.next = p.next.next;
			curr = curr.next;
			p = p.next;
		}

		return head.next;
	}

	public class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}
}