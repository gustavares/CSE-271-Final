# CSE-271-Final 

Write a program which will query the user for a file containing a list of arithmetic expressions in reverse polish notation (Links to an external site.). For this assignment, you may assume that the file is formatted with one expression per line. Unlike your previous lab, you may not assume that expressions are formatted correctly. If the expression is correct however, you may assume that it is comprised of the following (and only binary arithmetic operations on integers):

- plus – representing integer addition (denoted by the symbol '+')
- dash – representing integer subtraction (denoted by the symbol '-')
- astherisc representing integer multiplication (denoted by the symbol '*')
- slash – representing integer division (denoted by the symbol '/')
- percentage – representing the modulus operator (denoted by the symbol '%')
For every expression in the file, evaluate the expression and print it's value to System.out. If the expression is syntactically incorrect, you are to output a clear error message informing the user of (the expression, and the first error within the expression).

 

You program's design should be done in an "OOP" manner. In other words, you are to design an "ArithmeticExpression" class which supports at least the following methods:

- a constructor
- value() - returns the value of the ArithmeticExpression
- reversePolishNotationForm() - returns the reverse polish notation form of the expression
- infixNotationForm() - returns the infix form of the expression (try to minimize the amount of parentheses in the output)
- toString() - returns a String representation of the expression (in reverse polish notation for the moment)
  
 and possibly other methods as necessary. You must decompose your design into well specified and defined functions/methods as opposed  to using a single "main" method. Syntax errors should be detected by extending the Exception class accordingly.

 

Note that the methods value(), reversePolishNotationForm(), and infixNotationForm() may all be written in a simple way if you design your program according to the methods discussed in class by: first building up an expression tree and then; reducing each of these operations to walking the tree.

