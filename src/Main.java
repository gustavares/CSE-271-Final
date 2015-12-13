import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	
    	System.out.printf("File Name: ");
    	String fileName = input.next();
    	
    	ArithmeticExpression expressions = new ArithmeticExpression(fileName);
        for (ExpressionTree expression : expressions.getExpressionList()) {
        	System.out.println(expression.infixNotationForm(expression.getRoot()) + " = " + expression.value(expression.getRoot()));
        }
        input.close();
	}
}
