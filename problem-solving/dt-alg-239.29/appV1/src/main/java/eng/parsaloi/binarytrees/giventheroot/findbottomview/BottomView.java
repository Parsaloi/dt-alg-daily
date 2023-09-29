package eng.parsaloi.binarytrees.giventheroot.findbottomview;

import java.util.*;
// import java.util.TreeMap;
// import java.util.stream.Collectors;

public class BottomView {

	public static List<Integer> getBottomView(TreeNode root) {
		List<Integer> bottomView = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Map<Integer, Integer> horizontalDistanceToNodeMap = new HashMap<>();

		queue.add(root);
		horizontalDistanceToNodeMap.put(0, root.val);

		while (queue.isEmpty()) {
			TreeNode currentNode = queue.poll();

			// Get the horizontal distance of the current node
			int horizontalDistance = horizontalDistanceToNodeMap.get(currentNode.val);

			// Add the current node to the bottom view if it is the lowest node at this horizontal distance.
			if (!bottomView.contains(currentNode.val) || horizontalDistance < bottomView.indexOf(currentNode.val)) {
				bottomView.add(currentNode.val);
			}

			// Add the left and right child of the current node to the queue, along with their horizontal distances.
			if (currentNode.left != null) {
				horizontalDistanceToNodeMap.put(horizontalDistance - 1, currentNode.left.val);
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				horizontalDistanceToNodeMap.put(horizontalDistance + 1, currentNode.right.val);
				queue.add(currentNode.right);
			}
		}

		return bottomView;
	}
}
