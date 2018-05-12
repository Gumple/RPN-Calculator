package project.joseph.operators;

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
    public void execute(Stack stack) throws CalculatorException {
        return;
    }

    public static Double squareRoot(Double operand1) {
        return Math.sqrt(operand1);
    }
}
