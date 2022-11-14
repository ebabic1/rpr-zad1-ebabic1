package ba.unsa.etf.rpr;

import java.util.Stack;
/** Parses a fully parenthesized arithmetic expression. A fully parenthesized arithmetic expression is an arithmetic
 *          expression where every operator
 *          and its arguments are contained in parentheses, as seen in following: ( 2 + 3 ) or ( 1 + ( ( 2 + 3 ) ∗ ( 4 ∗ 5 ) ) ) - note the spaces in between */
public class ExpressionEvaluator {
    private final Stack<Double> operandStack;
    private final Stack<String> operatorStack;
    private int lBrace = 0;
    /** Class constructor */
    public ExpressionEvaluator() {
            operatorStack = new Stack<>();
            operandStack = new Stack<>();
    }


    /** main evaluation method
     * @param s fully parenthesized arithmetic expression
     *
     * @return result
     * @throws RuntimeException in case of missing operands  */
    public Double evaluate(String s) {
        boolean flag = false;
        for(String element : s.trim().split(" ")) {
            if(isOperator(element)) {operatorStack.push(element);}
            else if(element.equals("(")) {lBrace = lBrace+1; flag = true;}
            else if(element.equals(")"))
            {
                if(operandStack.isEmpty() || operatorStack.isEmpty()) {
                    throw new RuntimeException("Invalid expression - missing operands");
                }
                String operator = operatorStack.pop();
                Double value = operandStack.pop();
                this.applyOperator(operator,value);
                lBrace--;
            }
            else try{
                    operandStack.push(Double.parseDouble(element));
                } catch (Exception e) {
                    throw new RuntimeException("Invalid symbols in expression");
                }
        }
        if (operandStack.size() == 1 && lBrace == 0 && flag) return operandStack.pop();
        else {
            throw new RuntimeException("Invalid expression");
        }
    }
    /** Method for applying given operator to values
     * @param operator, value
     * @throws RuntimeException in case of missing operands*/
    private void applyOperator(String operator, Double value) throws RuntimeException{
        /* in case of number surrounded in braces eg. ( ... ( 1 ) ... )*/

        if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
            if(operandStack.isEmpty()) throw new RuntimeException("Invalid expression - missing operand");
        }
        switch (operator) {
            case "+" -> operandStack.push(operandStack.pop() + value);
            case "-" -> operandStack.push(operandStack.pop() - value);
            case "*" -> operandStack.push(operandStack.pop() * value);
            case "/" -> operandStack.push(operandStack.pop() / value);
            case "sqrt" -> operandStack.push(Math.sqrt(value));
        }
    }
    /* Method for checking if given string represents an operator
     * @param string
     * @return true if parameter is an operator, false otherwise*/
    static private boolean isOperator(String s) {
        return (s.equals("*") || s.equals("+") || s.equals("-") || s.equals("/") || s.equals("sqrt"));
    }

}
