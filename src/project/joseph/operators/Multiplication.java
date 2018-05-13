package project.joseph.operators;

import project.joseph.exceptions.CalculatorError;
import project.joseph.exceptions.CalculatorException;

import java.util.Stack;

/**
 * Created by josephgan on 5/12/18.
 */
public class Multiplication extends Operator {
    public Multiplication() {
        this.operator = OperatorEnum.MULTIPLICATION;
    }

    @Override
    public void execute(Stack<Double> stack) throws CalculatorException {
        if (stack.size() < 2) {
            throw new CalculatorException(CalculatorError.INSUFFICIENT_PARAMETERS);
        }
        Double operand1 = stack.pop();
        Double operand2 = stack.pop();
        stack.push(multiply(operand1, operand2));
    }

    public static Double multiply(Double operand1, Double operand2) {
        return operand1 * operand2;
    }
}
