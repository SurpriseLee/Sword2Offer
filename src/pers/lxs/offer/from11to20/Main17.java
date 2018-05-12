package pers.lxs.offer.from11to20;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Main17 {
	@Test
	public void test() {
		int[] a1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] a2 = { 2, 4, 5 };

		TreeNode tree1 = buildTree(a1);
		TreeNode tree2 = buildTree(a2);

		System.out.println(isSubTree(tree1, tree2));

		preTravel(tree1);
		System.out.println();

		preTravel(tree2);
		System.out.println();

		System.out.println(HasSubtree(tree1, tree2));
	}

	public TreeNode buildTree(int[] array) {
		if (array.length <= 0) {
			return null;
		}

		TreeNode root = new TreeNode(array[0]);

		List<TreeNode> list = new ArrayList<TreeNode>();
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

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if ((root1 == null) || (root2 == null)) {
			return false;
		}

		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root1);

		while (!list.isEmpty()) {
			TreeNode curr = (TreeNode) list.remove(0);
			boolean isSubTree = isSubTree(curr, root2);

			if (isSubTree) {
				return isSubTree;
			}

			if (curr.left != null) {
				list.add(curr.left);
			}

			if (curr.right != null) {
				list.add(curr.right);
			}
		}

		return false;
	}

	public boolean isSubTree(TreeNode root1, TreeNode root2) {
		if ((root1 == null) && (root2 == null)) {
			return true;
		}

		if ((root1 == null) && (root2 != null)) {
			return false;
		}

		if ((root2 == null) && (root1 != null)) {
			return true;
		}

		if (root1.val != root2.val) {
			return false;
		}

		return (isSubTree(root1.left, root2.left)) && (isSubTree(root1.right, root2.right));
	}

	private void preTravel(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preTravel(root.left);
			preTravel(root.right);
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}

	}
}