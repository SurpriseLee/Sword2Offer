package pers.lxs.offer.from21to30;

import org.junit.Test;

public class Main2626 {
	@Test
	public void test() {
		int[] array = { 8, 6, 7, 5, 9, 3, 4, 2, 1 };

		TreeNode root = buildBST(array);

		TreeNode head = Convert(root);

		while (head != null) {
			System.out.print(head.val + " ");
			head = head.right;
		}
		System.out.println();
	}

	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}

		TreeNode tail = null;

		TreeNode head = Convert(pRootOfTree, tail);

		while (head.left != null) {
			head = head.left;
		}

		return head;
	}

	public TreeNode Convert(TreeNode root, TreeNode tail) {
		if (root == null) {
			return tail;
		}

		tail = Convert(root.left, tail);

		if (tail == null) {
			tail = root;
			tail.left = null;
		} else {
			tail.right = root;
			root.left = tail;
			tail = tail.right;
		}

		tail = Convert(root.right, tail);

		return tail;
	}

	public void midTravel(TreeNode root) {
		if (root == null) {
			return;
		}

		midTravel(root.left);
		System.out.print(root.val + " ");
		midTravel(root.right);
	}

	public TreeNode buildBST(int[] array) {
		if (array.length <= 0) {
			return null;
		}

		TreeNode root = new TreeNode(array[0]);

		int index = 1;
		label124: while (index < array.length) {
			int e = array[(index++)];

			TreeNode curr = root;
			while (true) {
				if (e < curr.val) {
					if (curr.left != null) {
						curr = curr.left;
					} else {
						curr.left = new TreeNode(e);
						break label124;
					}
				} else if (e >= curr.val) {
					if (curr.right == null)
						break;
					curr = curr.right;
				}
			}
			curr.right = new TreeNode(e);
		}

		return root;
	}

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}