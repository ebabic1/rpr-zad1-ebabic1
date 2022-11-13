package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    private Stack<Double> operandStack;
    private Stack<String> operatorStack;

    public ExpressionEvaluator() {
            operatorStack = new Stack<String>();
            operandStack = new Stack<Double>();
    }
    /** Class constructor */

    /** Parses an arithmetic expression using Dijkstra algorithm
     * @param s fully parenthesized arithmetic expression
     * @return result
     * @throws RuntimeException in case of missing operands  */
    public Double evaluate(String s) {
        Double result;
        String el = null;
        for(String element : s.trim().split(" ")) {
            if(isOperator(element) || element.equals("(")) operatorStack.push(element);
            else if(element.equals(")"))
            {
                if(operandStack.isEmpty() || operatorStack.isEmpty()) {
                    throw new RuntimeException("Invalid expression - missing operands");
                }
                String operator = operatorStack.pop();
                Double value = operandStack.pop();
                this.applyOperator(operator,value);
            }
            else if (!operatorStack.isEmpty()) try{
                    operandStack.push(Double.parseDouble(element));
                } catch (Exception e) {
                    throw new RuntimeException("Invalid expression");
                }
        }
        if (operandStack.size() == 1) result = operandStack.pop();
        else {
            throw new RuntimeException("Invalid expression");
        }
        return result;
    }
    /** Method for applying given operator to values
     * @param operator
     * @return  void
     * @throws RuntimeException in case of missing operands*/
    private void applyOperator(String operator, Double value) throws RuntimeException{
        if(operator.equals("(")){
            operandStack.push(value);
            return;
        }
        if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
            if(operandStack.isEmpty()) throw new RuntimeException("Invalid expression - missing operand");
        }
        if(operator.equals("+")) operandStack.push(operandStack.pop()+value);
        else if(operator.equals("-")) operandStack.push(operandStack.pop()-value);
        else if(operator.equals("*")) operandStack.push(operandStack.pop()*value);
        else if(operator.equals("/")) operandStack.push(operandStack.pop()/value);
        else if(operator.equals("sqrt")) operandStack.push(Math.sqrt(value));
        if(operatorStack.empty() || !operatorStack.pop().equals("(")) throw new RuntimeException("Invalid expression - right bracket left open");
    }
    /* Method for checking if given string represents an operator
     * @param string
     * @return true if parameter is an operator, false otherwise*/
    static private boolean isOperator(String s) {
        return (s.equals("*") || s.equals("+") || s.equals("-") || s.equals("/") || s.equals("sqrt"));
    }

}
