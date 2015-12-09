import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * ArithmeticExpression lists all the valid arithmetic expressions from a file
 * onto an ExpressionTree.
 * @author Gustavo
 *
 */
public class ArithmeticExpression {
	
	private List<ExpressionTree> expressionList = null;
	private String filename = null;
	
	public ArithmeticExpression (String fileName) {
		this.filename = fileName;
		// TODO set the Expression tree here
	}
	
	public List<ExpressionTree> getExpressionList() {
		return expressionList;
	}
	
	
	/** 
	 *  TODO evaluate()
	 *  	return the result value of a given expression
	 */
				
	/**
	 * Returns true if the list is empty and false otherwise.
	 */
	public boolean isEmpty() {
		return this.expressionList.isEmpty();
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
