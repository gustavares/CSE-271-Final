
public class Node {
	
	private Integer label;
	private Node left;
	private Node right;
	
	// Constructors
	public Node(int label){
		setData(label);
		setLeft(null);
		setRight(null);
	}

	public Node() {
		setLeft(null);
		setRight(null);
	}
	
	// Getters & Setters
	public Integer getData() {
		return label;
	}

	public void setData(Integer label) {
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
}