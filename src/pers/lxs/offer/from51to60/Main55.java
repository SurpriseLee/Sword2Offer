package pers.lxs.offer.from51to60;

import org.junit.Test;

public class Main55 {
	@Test
	public void test() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

		ListNode head = buildLink(array);

		ListNode entry = EntryNodeOfLoop(head);

		System.out.println(entry.val);
	}

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if ((pHead == null) || (pHead.next == null)) {
			return null;
		}

		ListNode p = pHead.next;
		ListNode q = pHead.next.next;

		while (p != q) {
			p = p.next;
			q = q.next.next;
		}

		p = pHead;
		while (p != q) {
			p = p.next;
			q = q.next;
		}

		return p;
	}

	public ListNode buildLink(int[] array) {
		if ((array == null) || (array.length <= 0)) {
			return null;
		}

		ListNode head = new ListNode(array[0]);

		ListNode curr = head;
		int index = 1;
		while (index < array.length) {
			curr.next = new ListNode(array[(index++)]);
			curr = curr.next;
		}

		ListNode tail = curr;
		curr = head;
		index = 1;
		while (index < array.length / 2) {
			curr = curr.next;
			index++;
		}

		tail.next = curr;

		return head;
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
