package pers.lxs.offer.from61to66;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class Main61 {
	@Test
	public void test() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		TreeNode root = buildTree(array);

		String str = Serialize(root);
		System.out.println("ser: " + str);

		root = Deserialize(str);

		str = Serialize(root);
		System.out.println("Des: " + str);
	}

	public String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder("");

		if (root == null) {
			return sb.toString();
		}

		sb.append(root.val);

		List<TreeNode> list = new LinkedList<TreeNode>();

		list.add(root);

		while (!list.isEmpty()) {
			TreeNode node = (TreeNode) list.remove(0);

			if (node.left != null) {
				list.add(node.left);
				sb.append("," + node.left.val);
			} else {
				sb.append(",#");
			}

			if (node.right != null) {
				list.add(node.right);
				sb.append("," + node.right.val);
			} else {
				sb.append(",#");
			}
		}

		return sb.toString();
	}

	public TreeNode Deserialize(String str) {
		if ((str == null) || (str.length() <= 0) || (str.charAt(0) == '#')) {
			return null;
		}

		String[] strs = str.trim().split(",");

		TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
		List<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);

		int index = 1;
		while (index < strs.length) {
			TreeNode node = (TreeNode) list.remove(0);

			if (!strs[index].equals("#")) {
				node.left = new TreeNode(Integer.valueOf(strs[index]).intValue());
				list.add(node.left);
			}
			index++;

			if ((index < strs.length) && (!strs[index].equals("#"))) {
				node.right = new TreeNode(Integer.valueOf(strs[index]).intValue());
				list.add(node.right);
			}

			index++;
		}

		return root;
	}

	public TreeNode buildTree(int[] array) {
		if ((array == null) || (array.length <= 0)) {
			return null;
		}

		TreeNode root = new TreeNode(array[0]);
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offerLast(root);

		int index = 1;
		while (index < array.length) {
			TreeNode node = (TreeNode) queue.pollFirst();
			node.left = new TreeNode(array[(index++)]);
			queue.offerLast(node.left);

			if (index < array.length) {
				node.right = new TreeNode(array[(index++)]);
				queue.offerLast(node.right);
			}
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