package project.joseph.operators;

import project.joseph.exceptions.CalculatorException;

import java.util.Stack;

/**
 * Created by josephgan on 5/12/18.
 *
 * The abstraction of Operator:
 * 1. Every operator has a name to be collected from user's input
 * 2. Every operator can be executed with operands popped from the stack
 * @see OperatorEnum
 * @see CalculatorException
 */
public abstract class Operator {
    OperatorEnum operator = OperatorEnum.ILLEGAL_OPERATOR;
    public OperatorEnum getOperator() {
        return this.operator;
    }

    /**
     * @param stack is the data structure to store operands
     * @throws CalculatorException is a custom {@link Exception}
     */
    public abstract void execute(Stack<Double> stack) throws CalculatorException;
}
