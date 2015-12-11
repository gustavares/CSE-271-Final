import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
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
	private String filename = null;
	
	public ArithmeticExpression (String fileName) {
		this.filename = fileName;
		expressionList = setExpressionList(fileName);
	}
	
	public List<ExpressionTree> getExpressionList() {
		return expressionList;
	}
	
	public boolean isEmpty() {
		return this.expressionList.isEmpty();
	}
	
	/**
     * Returns a list of lines read from the specified file. If the file
     * is empty or unreadable, returns an empty list.
     */
	
	private List<ExpressionTree> setExpressionList(String fileName) {
		List<String> lines = readLinesFromFile(fileName);
		List<ExpressionTree> expressionList = null;
		
		for (String expression : lines) {
			String[] tokens = expression.split("\\s+");
			Stack<String> expressionStack = new Stack<String>();
			
			for(String token : tokens) {
				if (token.matches("[-?\\d+\\/\\+\\-\\*\\%]")) { // regex to match digits and the valid operators
					expressionStack.push(token);
				}
				// TODO: change this if to a try-catch for invalid tokens
				}
			this.expressionList.add(new ExpressionTree(expressionStack));
		}
		return expressionList;
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
