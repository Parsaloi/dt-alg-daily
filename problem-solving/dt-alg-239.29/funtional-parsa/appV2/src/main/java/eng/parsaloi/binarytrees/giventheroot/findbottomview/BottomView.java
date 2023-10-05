package eng.parsaloi.binarytrees.giventheroot.findbottomview;

import java.util.*;

public class BottomView {

	public static List<Integer> findBottomView(TreeNode root) {
		
		// Create a map to store the horizontal distance of each node at the bottom
		Map<Integer, Integer> bottomView = new HashMap<>();

		// Create a queue to traverse the tree in a level-order fashion
		Queue<TreeNode> queue = new LinkedList<>();

		// Add the root node to the queue
		queue.add(root);

		// Initialize the horizontal distance of the root node
		int horizontalDistance = 0;

		// While the queue is not empty, do the following:
		while (!queue.isEmpty()) {
			// Remove the first node from the queue
			TreeNode node = queue.remove();

			// Update the bottom view for the current horizontal distance
			bottomView.put(horizontalDistance, node.val);

			// Add the left and right children at the current node to the queue
			// If they are not null
			if (node.left != null) {
				queue.add(node.left);
				horizontalDistance--;
			}

			if (node.right != null) {
				queue.add(node.right);
				horizontalDistance++;
			}
		}

		// Return the bottom view
		return new ArrayList<>(bottomView.values());
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String [] args) {

		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.left.left.left = new TreeNode(0);
		root.right.right.left = new TreeNode(8);

		List<Integer> bottomView = findBottomView(root);

		System.out.println(bottomView); // [0, 1, 3, 6, 8, 9]

	}
}
