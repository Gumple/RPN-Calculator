package project.joseph.exceptions;

/**
 * Created by josephgan on 5/12/18.
 */
public class CalculatorException extends Exception {
    private Integer errorCode = CalculatorError.COMMON_ERROR.getCode();
    public CalculatorException() {
        super();
    }

    public CalculatorException(String message) {
        super(message);
    }

    public CalculatorException(CalculatorError calculatorError) {
        this(calculatorError.getErrorMsg());
        this.errorCode = calculatorError.getCode();
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }
}
