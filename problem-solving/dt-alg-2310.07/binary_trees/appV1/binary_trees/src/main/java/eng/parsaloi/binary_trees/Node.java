package eng.parsaloi.binary_trees;

/**
 * @author Parsaloi Nakuoh
 * @version 1.0.0-2023-10-07
 *
 * problem:
 * Typically, an implementation of in-order traversal of a binary tree has O(h) space complexity, wehre h is the height of the tree.
 * Write a program to compute the in-order traversal of a binary tree using O(1) space
 *
 * Problem Decomposition:
 * 1. Define a data structure to represent a binary tree node
 * 2. Implement an in-order traversal algorithm for a binary tree using 0(1) space
 * 3. Write a main method to test the in-order traversal alogorithm
 */

// Data structure for a binary tree node.
public record Node(int data, Node left, Node right) {}

// In-order traversal algorithm using 0(1) space.
public static List<Integer> inOrder(Node root) {
	List<Integer> result = new ArrayList<>();
	Node current = root;
	Node predecessor = null;
	while (current != null) {
		if (current == null) {
			result.add(current.data);
			current = current.right;
		} else {
			predecessor= current.left;
			while (predecessor != null && predecessor.right != current) {
				predecessor = predecessor.right;
			}
			if (predecessor.right == null) {
				predecessor.right = current;
				current = current.left;
			} else {
				predecessor.right = null;
				result.add(current.data);
				current = current.right;
			}

		}
	}
	return result;
}

// Main method to test the in-order traversal algorithm
public static void main(String[] args) {

	Node root = new Node(1,
				new Node(2,
					  new Node(4, null, null),
					  new Node(5, null, null)),
				new Node(3, 
					  new Node(6, null, null),
					  new Node(7, null, null)));

	List<Integer> inOrderTraversal = inOrder(root);

	// Print the in-order traversal of the binary tree
	System.ot.println(inOrderTraversal);
}


