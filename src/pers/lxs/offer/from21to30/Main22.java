package pers.lxs.offer.from21to30;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class Main22 {
	@Test
	public void test() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		TreeNode root = buildTree(array);
		printFromTopToBotton(root);
		System.out.println();

		ArrayList<Integer> list = PrintFromTopToBottom(root);

		System.out.println(list.toString());
	}

	public TreeNode buildTree(int[] array) {
		if (array.length <= 0) {
			return null;
		}

		ArrayList<TreeNode> list = new ArrayList<TreeNode>();

		TreeNode root = new TreeNode(array[0]);
		list.add(root);

		int index = 1;
		while (index < array.length) {
			TreeNode curr = (TreeNode) list.remove(0);
			curr.left = new TreeNode(array[(index++)]);
			list.add(curr.left);

			if (index < array.length) {
				curr.right = new TreeNode(array[(index++)]);
				list.add(curr.right);
			}
		}

		return root;
	}

	public void printFromTopToBotton(TreeNode root) {
		if (root == null) {
			return;
		}

		List<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);

		while (!list.isEmpty()) {
			TreeNode curr = (TreeNode) list.remove(0);

			System.out.print(curr.val + " ");

			if (curr.left != null) {
				list.add(curr.left);
			}

			if (curr.right != null)
				list.add(curr.right);
		}
	}

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		if (root == null) {
			return list;
		}

		List<TreeNode> nodeList = new LinkedList<TreeNode>();

		nodeList.add(root);

		while (!nodeList.isEmpty()) {
			TreeNode curr = (TreeNode) nodeList.remove(0);

			list.add(Integer.valueOf(curr.val));

			if (curr.left != null) {
				nodeList.add(curr.left);
			}

			if (curr.right != null) {
				nodeList.add(curr.right);
			}
		}

		return list;
	}

	class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}