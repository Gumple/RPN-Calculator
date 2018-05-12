package project.joseph.operators;

import project.joseph.exceptions.CalculatorException;

import java.util.Stack;

/**
 * Created by josephgan on 5/12/18.
 */
public abstract class Operator {
    OperatorEnum operator = OperatorEnum.ILLEGAL_OPERATOR;
    public OperatorEnum getOperator() {
        return this.operator;
    }
    public abstract void execute(Stack stack) throws CalculatorException;
}
