package project.joseph.operators;

import project.joseph.exceptions.CalculatorException;

import java.util.Stack;

/**
 * Created by josephgan on 5/12/18.
 */
public class Undo extends Operator {
    public Undo() {
        this.operator = OperatorEnum.UNDO;
    }

    @Override
    public void execute(Stack<Double> stack) throws CalculatorException {
        return;
    }
}
