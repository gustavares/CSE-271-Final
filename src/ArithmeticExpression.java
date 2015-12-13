import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * ArithmeticExpression lists all the valid arithmetic expressions from a file
 * onto a List of Expression Trees where each Tree represents one expression from the file.
 * @author Gustavo
 *
 */
public class ArithmeticExpression {
	
	private List<ExpressionTree> expressionList = null;
	private String fileName = null;
	
	public ArithmeticExpression (String fileName) throws ArithmeticExpressionException {
		this.fileName = fileName;
		this.expressionList = setExpressionList(fileName);
	}
	
	public List<ExpressionTree> getExpressionList() {
		return expressionList;
	}
	
	public boolean isEmpty() {
		return this.expressionList.isEmpty();
	}
	
	/**
     * Sets the list of expressions. 
     * If an expression contains invalid tokens 
     * throws an ArithmeticExpressionException
     */
	private List<ExpressionTree> setExpressionList(String fileName){
		List<String> lines = readLinesFromFile(fileName);
		List<ExpressionTree> expressionList = new ArrayList<>();
		
		for (String expression : lines) {
			String[] tokens = expression.split("\\s+");
			Stack<String> expressionStack = new Stack<String>();
			try {
				if (tokens.length < 3){
					throw new ArithmeticExpressionException();
				}
				for(String token : tokens) {
					if (isValidToken(token)) {
						expressionStack.push(token);
					} else {
						throw new ArithmeticExpressionException();
					}
				}	
				ExpressionTree tree = new ExpressionTree(expressionStack);
				expressionList.add(tree);
			} catch (ArithmeticExpressionException e) {
				System.err.println(expression + " is not valid.");
			}
		}
		return expressionList;
	}
	
	/**
	 * Returns a formated string with all the expressions in the file
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(String.format("Expressions for %s:\n", this.fileName));
		for(ExpressionTree expression : expressionList) {
			stringBuilder.append(String.format("\n%s", expression.reversePolishNotationForm(expression.getRoot())));
		}
		return stringBuilder.toString();
	}
	
	/**
	 * Returns true if a given token is valid and false otherwise.
	 */
	public static boolean isValidToken(String token) {
		if(token.matches("[-?\\d+\\/\\+\\-\\*\\%]"))
			return true;
		return false;
	}
	
	/**
     * Returns a list of lines read from the specified file. If the file
     * is empty or unreadable, returns an empty list.
     */
	private static List<String> readLinesFromFile(String fileName) {
        try (Stream<String> lines = Files.lines(new File(fileName).toPath(), Charset.defaultCharset())) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            System.err.printf("Failed to load file: %s", fileName);
            return new ArrayList<>();
        }
	}
}
