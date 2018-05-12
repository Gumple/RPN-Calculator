package project.joseph.modes;

import project.joseph.operators.Operator;
import project.joseph.operators.OperatorEnum;

import java.util.Set;
import java.util.Stack;

/**
 * Created by josephgan on 5/12/18.
 */
public class RPNMode implements CalculatingMode {
    private Set<Operator> operators;
    private Stack stack;
    private static String description;

    static {
        description = "";
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void calculate() {
    }

    private Operator getByName(String name) {
        for (Operator operator : this.operators) {
            if (operator.getOperator().equals(OperatorEnum.getByName(name))) {
                return operator;
            }
        }
        return null;
    }
}
