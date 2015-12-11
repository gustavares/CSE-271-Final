import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExpressionTree {

	private Node root;
	
	public ExpressionTree() {
		this.root = new Node();
	}
	
	public ExpressionTree(Stack<String> expressionStack) {
		this.root = generateExpressionTree(expressionStack);
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	private Node generateExpressionTree(Stack<String> expressionStack) {
		Node node = new Node();
		if(expressionStack.isEmpty()) {
			return new Node();
		}
		
		String label = expressionStack.pop();
		if(isOperand(label)) {
			return new Node(label);
		} else {
			node = new Node(label);
			node.setRight(generateExpressionTree(expressionStack));
			node.setLeft(generateExpressionTree(expressionStack));
		}	
		return node;
	}
	
	// TODO: make it return a string that can be used to evaluate the expression
	public void reversePolishNotationForm(Node node) {
		if (!isEmpty(node)) {
			reversePolishNotationForm(node.getLeft());
			reversePolishNotationForm(node.getRight());
			System.out.print(node.getLabel() + " ");
		}
	}
	
	public void infixNotationForm(Node node) {
		if (!isEmpty(node)) {
			if(isOperator(node.getLabel())) 
				System.out.print("(");
			infixNotationForm(node.getLeft());
			System.out.print(node.getLabel());
			infixNotationForm(node.getRight());
			if(isOperator(node.getLabel())) 
				System.out.print(")");
		}
	}
	
	public int evaluate(Node node) {
		if(isEmpty(node))
			return 0;
		return 0;
	}

	/** 
	 *  TODO evaluate()
	 *  	return the result value of a given expression
	 */
	

	public static boolean isOperand(String label) {
		if(label.matches("-?\\d+"))
			return true;
		return false;
	}
	
	public static boolean isOperator(String label) {
		if(label.matches("[\\/\\+\\-\\*\\%]"))
			return true;
		return false;
	}
	
	public boolean isEmpty(Node node) {
		if (node == null)
			return true;
		else {
			if (node.getLabel() == null)
				return true;
			return false;
		}
	}
	
	
	
	
	
}
