package pers.lxs.offer.from21to30;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Main26 {
	@Test
	public void test() {
		int[] array = { 8, 6, 7, 5, 9, 3, 4, 2, 1 };

		TreeNode root = buildBST(array);

		midTravel(root);
		System.out.println();

		TreeNode head = Convert(root);

		System.out.println("Result: ");
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

		List<TreeNode> list = new ArrayList<TreeNode>();

		Convert(pRootOfTree, list);

		TreeNode head = (TreeNode) list.remove(0);
		TreeNode curr = head;
		curr.left = null;
		curr.right = null;
		for (TreeNode node : list) {
			node.left = null;
			node.right = null;
			curr.right = node;
			node.left = curr;
			curr = curr.right;
		}

		return head;
	}

	public void Convert(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			return;
		}

		TreeNode left = root.left;
		TreeNode right = root.right;

		Convert(left, list);

		list.add(root);

		Convert(right, list);
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
