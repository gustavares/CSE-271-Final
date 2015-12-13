import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//    	
//    	System.out.printf("File Name: ");
//    	String fileName = input.next();
//    	
//		String fileName = "expressions.txt";
//    	ArithmeticExpression expressions = new ArithmeticExpression(fileName);
//        if (!expressions.isEmpty()) {
//            System.out.println("Done");
//        }
    	//input.close();

		Stack<String> stack = new Stack<>();
		stack.push("6");
		stack.push("7");
		stack.push("*");
		stack.push("4");
		stack.push("3");
		stack.push("+");
		stack.push("-");
		ExpressionTree tree = new ExpressionTree(stack);
		System.out.println(tree.reversePolishNotationForm(tree.getRoot()));
		tree.infixNotationForm(tree.getRoot());
		
		System.out.println();
		System.out.printf("%d", tree.evaluate(tree.getRoot()));
	}
}
