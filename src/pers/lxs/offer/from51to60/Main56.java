package pers.lxs.offer.from51to60;

import org.junit.Test;

public class Main56 {
	@Test
	public void test() {
		int[] array = { 1, 1, 2, 3, 3, 4, 5, 5 };

		ListNode head = buildLink(array);

		ListNode entry = deleteDuplication(head);

		while (entry != null) {
			System.out.print(entry.val + " ");
			entry = entry.next;
		}
		System.out.println();
	}

	public ListNode deleteDuplication(ListNode pHead) {
		if ((pHead == null) || (pHead.next == null)) {
			return pHead;
		}

		ListNode curr = new ListNode(0);

		ListNode p = pHead;

		pHead = curr;

		while (p != null) {
			if ((p.next != null) && (p.val == p.next.val)) {
				while ((p.next != null) && (p.val == p.next.val)) {
					p = p.next;
				}

				if (p.next == null) {
					return pHead.next;
				}

				p = p.next;
			} else {
				curr.next = p;
				curr = curr.next;

				p = p.next;

				curr.next = null;
			}

		}

		return pHead.next;
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
