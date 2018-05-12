package pers.lxs.offer.from31to40;

import org.junit.Test;

public class Main36 {
	@Test
	public void test() {
		int[] a1 = { 1, 2, 3 };
		int[] a2 = { 4, 5, 6 };
		int[] common = { 7, 8, 9 };

		ListNode head1 = buildLink(a1);
		ListNode head2 = buildLink(a2);

		ListNode commonHead = buildLink(common);

		ListNode pHead1 = connectLink(head1, commonHead);
		ListNode pHead2 = connectLink(head2, commonHead);

		ListNode node = FindFirstCommonNode(pHead1, pHead2);

		System.out.println(node.val);
	}

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if ((pHead1 == null) || (pHead2 == null)) {
			return null;
		}

		int len1 = getLength(pHead1);
		int len2 = getLength(pHead2);

		int diff = 0;
		if (len1 > len2) {
			diff = len1 - len2;
			while (diff > 0) {
				pHead1 = pHead1.next;
				diff--;
			}
		} else {
			diff = len2 - len1;
			while (diff > 0) {
				pHead2 = pHead2.next;
				diff--;
			}
		}

		while (pHead1 != pHead2) {
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}

		return pHead1;
	}

	public int getLength(ListNode head) {
		if (head == null) {
			return 0;
		}

		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}

		return len;
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

	public ListNode connectLink(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		}

		if (head2 == null) {
			return head1;
		}

		ListNode curr = head1;
		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = head2;

		return head1;
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}