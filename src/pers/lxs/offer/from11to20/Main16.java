package pers.lxs.offer.from11to20;

import org.junit.Test;

public class Main16 {
	@Test
	public void test() {
		int[] a1 = { 1, 3, 5, 7, 9 };
		int[] a2 = { 2, 4, 6, 8, 10 };

		ListNode list1 = new ListNode(a1[0]);
		ListNode curr = list1;
		for (int i = 1; i < a1.length; i++) {
			curr.next = new ListNode(a1[i]);
			curr = curr.next;
		}

		curr = list1;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();

		ListNode list2 = new ListNode(a2[0]);
		curr = list2;
		for (int i = 1; i < a2.length; i++) {
			curr.next = new ListNode(a2[i]);
			curr = curr.next;
		}

		curr = list2;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();

		ListNode result = Merge(list1, list2);

		curr = result;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		ListNode curr = null;

		if (list1.val <= list2.val) {
			curr = list1;
			list1 = list1.next;
		} else {
			curr = list2;
			list2 = list2.next;
		}

		ListNode result = curr;

		while ((list1 != null) && (list2 != null)) {
			if (list1.val <= list2.val) {
				curr.next = list1;
				curr = curr.next;
				list1 = list1.next;
			} else {
				curr.next = list2;
				curr = curr.next;
				list2 = list2.next;
			}

		}

		if (list1 == null)
			curr.next = list2;
		else if (list2.next == null) {
			curr.next = list1;
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