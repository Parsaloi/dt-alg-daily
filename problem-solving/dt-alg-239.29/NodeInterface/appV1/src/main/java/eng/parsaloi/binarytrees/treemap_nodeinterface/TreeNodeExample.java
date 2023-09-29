import java.util.*;
import java.util.TreeMap.Node;

public class TreeNodeExample {
	
	public static void main(String[] args) {

		TreeMap<Integer, String> treeMap = new TreeMap<>();

		Node<Integer, String> node1 = new Node<>(1, "nodeOne");
		Node<Integer, String> node2 = new Node<>(2, "nodeTwo");

		treeMap.put(node1);
		treeMap.put(node2);

		System.out.println(treeMap);
	}
}
