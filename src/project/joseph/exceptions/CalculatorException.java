package project.joseph.exceptions;

/**
 * Created by josephgan on 5/12/18.
 *
 * This is a custom {@link Exception} class with an extra {@code errorCode} field
 * @see CalculatorError
 */
public class CalculatorException extends Exception {
    private Integer errorCode = CalculatorError.COMMON_ERROR.getCode();
    public CalculatorException() {
        super();
    }

    public CalculatorException(String message) {
        super(message);
    }

    /**
     * @implNote this is a constructor
     * @param calculatorError specifies errorCode and message
     */
    public CalculatorException(CalculatorError calculatorError) {
        this(calculatorError.getErrorMsg());
        this.errorCode = calculatorError.getCode();
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }
}
