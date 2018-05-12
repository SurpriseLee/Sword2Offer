package pers.lxs.offer.from11to20;

import org.junit.Test;

public class Main15 {
	@Test
	public void test() {
		int[] a1 = { 1, 3, 5, 7, 9 };

		ListNode list = new ListNode(a1[0]);
		ListNode curr = list;
		for (int i = 1; i < a1.length; i++) {
			curr.next = new ListNode(a1[i]);
			curr = curr.next;
		}

		ListNode result = ReverseList(list);

		curr = result;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public ListNode ReverseList(ListNode head) {
		if (head == null)
			return null;

		ListNode result = head;
		head = head.next;
		result.next = null;

		while (head != null) {
			ListNode temp = head.next;
			head.next = result;
			result = head;
			head = temp;
		}

		return result;
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
