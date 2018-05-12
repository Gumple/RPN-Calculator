package project.joseph.operators;

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
    public void execute(Stack stack) throws CalculatorException {
        return;
    }
}
