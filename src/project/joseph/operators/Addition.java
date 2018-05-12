package project.joseph.operators;

import project.joseph.exceptions.CalculatorException;

import java.util.Stack;

/**
 * Created by josephgan on 5/12/18.
 */
public class Addition extends Operator {
    public Addition() {
        this.operator = OperatorEnum.ADDITION;
    }

    @Override
    public void execute(Stack stack) throws CalculatorException {
        return;
    }

    public static Double add(Double operand1, Double operand2) {
        return operand1 + operand2;
    }
}
