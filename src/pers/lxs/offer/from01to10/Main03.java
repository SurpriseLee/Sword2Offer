package pers.lxs.offer.from01to10;

import java.util.ArrayList;
import org.junit.Test;

public class Main03 {
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

		ArrayList<Integer> list = printListFromTailToHead(head);

		System.out.println(list.toString());
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		if (listNode == null) {
			return list;
		}

		while (listNode != null) {
			list.add(Integer.valueOf(listNode.val));
			listNode = listNode.next;
		}

		int size = list.size();
		int half = (size - 1) / 2;

		for (int i = 0; i <= half; i++) {
			int temp = ((Integer) list.get(i)).intValue();
			list.set(i, (Integer) list.get(size - 1 - i));
			list.set(size - 1 - i, Integer.valueOf(temp));
		}

		return list;
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}