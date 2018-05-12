package pers.lxs.offer.from11to20;

import org.junit.Test;

public class Main14 {
	@Test
	public void test() {
		int[] a = { 67, 0, 24, 58, 69 };

		ListNode head = new ListNode(a[0]);
		ListNode curr = head;
		for (int i = 1; i < a.length; i++) {
			curr.next = new ListNode(a[i]);
			curr = curr.next;
		}

		curr = head;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();

		ListNode result = FindKthToTail(head, 2);

		System.out.println("k: " + result.val);
	}

	public ListNode FindKthToTail(ListNode head, int k) {
		ListNode curr = head;
		while ((k > 0) && (curr != null)) {
			curr = curr.next;
			k--;
		}

		if (k > 0)
			return null;

		ListNode result = head;

		while (curr != null) {
			curr = curr.next;
			result = result.next;
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
