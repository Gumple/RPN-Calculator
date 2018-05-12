package project.joseph.operators;

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
    public void execute(Stack stack) throws CalculatorException {
        return;
    }

    public static Double multiply(Double operand1, Double operand2) {
        return operand1 * operand2;
    }
}
