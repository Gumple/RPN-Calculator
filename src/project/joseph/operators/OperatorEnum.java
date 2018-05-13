package project.joseph.operators;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * Created by josephgan on 5/12/18.
 */
public enum OperatorEnum {
    ILLEGAL_OPERATOR("illegal operator"),

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    SQUARE_ROOT("sqrt"),
    UNDO("undo"),
    CLEAR("clear");

    private String name;

    OperatorEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static OperatorEnum getByName(String name) {
        for (OperatorEnum operatorEnum : values()) {
            if (operatorEnum.name.equalsIgnoreCase(name.trim())) {
                return operatorEnum;
            }
        }
        return ILLEGAL_OPERATOR;
    }
}
