package project.joseph.operators;

import project.joseph.exceptions.CalculatorError;
import project.joseph.exceptions.CalculatorException;

import java.util.Stack;

/**
 * Created by josephgan on 5/12/18.
 */
public class Clear extends Operator {
    public Clear() {
        this.operator = OperatorEnum.CLEAR;
    }

    @Override
    public void execute(Stack<Double> stack) throws CalculatorException {
        stack.clear();
        throw new CalculatorException(CalculatorError.CLEAR_HISTORY);
    }
}
