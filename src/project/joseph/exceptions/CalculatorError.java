package project.joseph.exceptions;

import project.joseph.Calculator;

/**
 * Created by josephgan on 5/13/18.
 */
public enum CalculatorError {
    COMMON_ERROR(300, "common error"),
    INSUFFICIENT_PARAMETERS(501, "insufficient parameters"),
    ILLEGAL_OPERATOR(404, "illegal operator"),
    ILLEGAL_UNDO(405, "cannot undo"),
    DIVIDE_BY_ZERO(410, "cannot divide by 0");

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
