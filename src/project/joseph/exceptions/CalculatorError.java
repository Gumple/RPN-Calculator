package project.joseph.exceptions;

import project.joseph.Calculator;

/**
 * Created by josephgan on 5/13/18.
 *
 * Custom Error Type
 */
public enum CalculatorError {
    CLEAR_HISTORY(200, "history cleared"),
    COMMON_ERROR(300, "common error"),
    INSUFFICIENT_PARAMETERS(501, "insufficient parameters"),
    ILLEGAL_OPERATOR(404, "illegal operator"),
    ILLEGAL_UNDO(405, "cannot undo"),
    DIVIDE_BY_ZERO(410, "cannot divide by 0"),
    SQUARE_ROOT_OF_NEGATIVE_NUMBER(410, "sqrt does not accept negative number");

    private Integer code;
    private String errorMsg;

    CalculatorError(Integer code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
