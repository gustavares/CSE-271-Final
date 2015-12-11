
public class Node {
	
	private String label;
	private Node left;
	private Node right;
	
	// Constructors
	public Node(String label){
		setLabel(label);
		setLeft(null);
		setRight(null);
	}

	public Node() {
		setLeft(null);
		setRight(null);
	}
	
	// Getters & Setters
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	/**
	 * To find out whether or not a node is "empty." If the node or its label
	 * are null, return true, otherwise, return false.
	 */
	public boolean isEmpty() {
		if (this.getLabel() == null)
			return true;
		else
			return false;
	}
}