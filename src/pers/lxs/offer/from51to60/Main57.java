package pers.lxs.offer.from51to60;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class Main57 {
	@Test
	public void test() {
		int[] array = { 8, 6, 10, 5, 7, 9, 11 };

		TreeLinkNode root = buildTree(array);

		TreeLinkNode node = GetNext(root.right.right);

		System.out.println(node.val);
	}

	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return pNode;
		}

		if (pNode.right == null) {
			TreeLinkNode parent = pNode.next;

			if (parent == null) {
				return null;
			}

			if (parent.left == pNode) {
				return parent;
			}

			if (parent.right == pNode) {
				TreeLinkNode temp = pNode;
				while (parent != null) {
					if (parent.right == temp) {
						temp = temp.next;
						parent = parent.next;
					} else if (parent.left == temp) {
						return parent;
					}
				}

				return parent;
			}
		}

		pNode = pNode.right;
		while (pNode.left != null) {
			pNode = pNode.left;
		}

		return pNode;
	}

	public TreeLinkNode buildTree(int[] array) {
		if ((array == null) || (array.length <= 0)) {
			return null;
		}

		TreeLinkNode root = new TreeLinkNode(array[0]);
		Deque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
		queue.offerLast(root);

		int index = 1;
		while (index < array.length) {
			TreeLinkNode parent = (TreeLinkNode) queue.pollFirst();

			TreeLinkNode left = new TreeLinkNode(array[(index++)]);
			parent.left = left;
			left.next = parent;
			queue.offerLast(left);

			if (index < array.length) {
				TreeLinkNode right = new TreeLinkNode(array[(index++)]);
				parent.right = right;
				right.next = parent;
				queue.offerLast(right);
			}
		}

		return root;
	}

	public class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}
}