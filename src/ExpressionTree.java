import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.EmptyStackException;
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
	
	/**
	 * Generate an expression tree from a given stack 
	 */
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
	
	/**
	 * Returns a String in the Reverse Polish Notation Form from a given expression tree
	 */
	public String reversePolishNotationForm(Node node) {
		String expression = "";
		if (!isEmpty(node)) {
			expression += reversePolishNotationForm(node.getLeft());
			expression += reversePolishNotationForm(node.getRight());
			expression += node.getLabel() + " ";
		}
		return expression;
	}
	
	/**
	 * Returns a String in the Infix Form from a given expression tree
	 */
	public String infixNotationForm(Node node) {
		String expression = "";
		if (!isEmpty(node)) {
			if(isOperator(node.getLabel())) 
				expression += "(";
			expression += infixNotationForm(node.getLeft());
			expression += node.getLabel();
			expression += infixNotationForm(node.getRight());
			if(isOperator(node.getLabel())) 
				expression += ")";
		}
		return expression;
	}
	
	/**
	 * Returns the result of an expression given its tree's root
	 */
	public int value(Node node) {
		if(isEmpty(node))
			return 0;
		String rpn = reversePolishNotationForm(node);
		
		String[] tokens = rpn.split("\\s+");
        Stack<Integer> stack = new Stack<Integer>();
        try {    	
        	for (String token : tokens) {
				if (isOperand(token)) {
					stack.push(Integer.valueOf(token)); // push to stack if it's a number
				} else {
					int op2 = stack.pop(); // pop numbers from stack if it's an operator
					int op1 = stack.pop();
					
					switch (token) {
					case "+":
						stack.push(op1 + op2);
						break;
					case "-":
						stack.push(op1 - op2);
						break;
					case "*":
						stack.push(op1 * op2);
						break;
					case "/":
						stack.push(op1 / op2);
						break;
					case "%":
						stack.push(op1 % op2);
						break;
					}
				}
			}	
        } catch (EmptyStackException e) {
        	System.err.printf("%s is not a valid expression.", rpn);
        }	
        return Integer.valueOf(stack.pop());
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
	
	// TODO move this methods to an Interface
	public static boolean isOperand(String token) {
		if(token.matches("-?\\d+"))
			return true;
		return false;
	}
	
	public static boolean isOperator(String token) {
		if(token.matches("[\\/\\+\\-\\*\\%]"))
			return true;
		return false;
	}
}
