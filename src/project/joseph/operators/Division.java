package project.joseph.operators;

import project.joseph.exceptions.CalculatorError;
import project.joseph.exceptions.CalculatorException;

import java.util.Stack;

/**
 * Created by josephgan on 5/12/18.
 */
public class Division extends Operator {
    public Division() {
        this.operator = OperatorEnum.DIVISION;
    }

    @Override
    public void execute(Stack<Double> stack) throws CalculatorException {
        if (stack.size() < 2) {
            throw new CalculatorException(CalculatorError.INSUFFICIENT_PARAMETERS);
        }
        Double operand2 = stack.pop();
        Double operand1 = stack.pop();
        if (operand2 == 0) {
            stack.push(operand1);
            stack.push(operand2);
            throw new CalculatorException(CalculatorError.DIVIDE_BY_ZERO);
        }
        stack.push(divide(operand1, operand2));
    }

    public static Double divide(Double operand1, Double operand2) {
        return operand1 / operand2;
    }
}
