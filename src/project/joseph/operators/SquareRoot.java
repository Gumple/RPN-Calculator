package project.joseph.operators;

import project.joseph.exceptions.CalculatorError;
import project.joseph.exceptions.CalculatorException;

import java.util.Stack;

/**
 * Created by josephgan on 5/12/18.
 */
public class SquareRoot extends Operator {
    public SquareRoot() {
        this.operator = OperatorEnum.SQUARE_ROOT;
    }

    @Override
    public void execute(Stack<Double> stack) throws CalculatorException {
        if (stack.size() < 1) {
            throw new CalculatorException(CalculatorError.INSUFFICIENT_PARAMETERS);
        }
        Double operand = stack.pop();
        stack.push(squareRoot(operand));
    }

    public static Double squareRoot(Double operand1) {
        return Math.sqrt(operand1);
    }
}
