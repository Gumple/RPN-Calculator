package project.joseph.modes;

import project.joseph.exceptions.CalculatorError;
import project.joseph.exceptions.CalculatorException;
import project.joseph.operators.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by josephgan on 5/12/18.
 */
public class RPNMode implements CalculatingMode {
    private static Set<Operator> operators;
    private Stack<Double> stack = new Stack<>();
    private static String description;

    static {
        description =
                "                                                   \n" +
                "              You are now in RPN Mode              \n" +
                "                                                   \n" +
                "#Available operators: +, -, *, /, sqrt, undo, clear\n" +
                "                                                   \n" +
                "|                                                  \n" +
                "V  Calculate Now!                                   ";
        operators = new HashSet<>();
        operators.add(new Addition());
        operators.add(new Subtraction());
        operators.add(new Multiplication());
        operators.add(new Division());
        operators.add(new SquareRoot());
        operators.add(new Clear());
    }

    private static ArrayList<String> history = new ArrayList<>();
    private final static String DELIMITER = ":";

    @Override
    public String description() {
        return description;
    }

    /**
     * @param input is a String that user enters in command-line
     *
     * @implNote The flow of calculate:
     * -> translates user's input into operations(operators & operands)
     * -> runs UNDO check(#undo functionality# is implemented by removing previous operations)
     * -> executes valid operations {@link #execute(List)}
     * -> displays result {@link #displayStack()}
     */
    @Override
    public void calculate(String input) {
        String[] items = input.split(" ");
        ArrayList<String> validItems = (ArrayList<String>)Arrays.stream(items).
                filter(x -> !x.isEmpty()).map(String::toLowerCase).collect(Collectors.toList());
        if (validItems.size() > 0) {
            int idx = -1; // index of operator in input string
            int undoIdx = validItems.indexOf(OperatorEnum.UNDO.getName());
            boolean illegalUndo = false;
            while (undoIdx > -1) {
                idx = input.toLowerCase().indexOf(OperatorEnum.UNDO.getName(), ++idx);
                if (undoIdx == 0) {
                    if (history.isEmpty()) {
                        System.out.println("operator " + OperatorEnum.UNDO.getName() + " (position: " + idx + "): " +
                                CalculatorError.ILLEGAL_UNDO.getErrorMsg());
                        illegalUndo = true;
                        break;
                    } else {
                        undoIdx = history.size();
                        history.addAll(validItems);
                        validItems = history;
                        history = new ArrayList<>();
                        stack.clear();
                    }
                } else {
                    validItems.remove(--undoIdx); // remove previous operation
                    validItems.remove(undoIdx); // remove UNDO operation
                    undoIdx = validItems.indexOf(OperatorEnum.UNDO.getName());
                }
            }
            if (!illegalUndo) {
                idx = -1;
                List<String> operations = new ArrayList<>();
                for (String item : validItems) {
                    idx = input.toLowerCase().indexOf(item, ++idx);
                    operations.add(item + DELIMITER + idx);
                }
                execute(operations);
            }
        }
        displayStack();
    }

    /**
     * @param items is a list of operation items <operation:index> with index info
     *
     * if the item is an operand: push to stack
     * if the item is an {@link Operator}: execute the calculation
     */
    private void execute(List<String> items) {
        for (String item : items) {
            String[] token = item.split(DELIMITER);
            String operation = token[0];
            int idx = Integer.parseInt(token[1]);
            try {
                Double number = Double.valueOf(operation);
                history.add(operation); // added to history only when it's legal
                stack.push(number);
            } catch (NumberFormatException e) {
                Operator operator = getByName(operation);
                try {
                    if (operator == null) {
                        throw new CalculatorException(CalculatorError.ILLEGAL_OPERATOR);
                    } else {
                        history.add(operation);
                        operator.execute(stack);
                    }
                } catch (CalculatorException ce) {
                    //print error message
                    if (CalculatorError.CLEAR_HISTORY.getCode().equals(ce.getErrorCode())) {
                        history.clear();
                    } else {
                        System.out.println("operator " + operation + " (position: " + idx + "): " + ce.getMessage());
                        break;
                    }

                }
            }
        }
    }

    private void displayStack() {
        System.out.print("stack: ");
        stack.forEach(x -> {
            //displayed to 10 decimal places (or less if it causes no loss of precision)
            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            decimalFormat.setRoundingMode(RoundingMode.CEILING);
            System.out.print(decimalFormat.format(x) + " ");
        });
        System.out.println();
    }

    private Operator getByName(String name) {
        for (Operator operator : operators) {
            if (operator.getOperator().equals(OperatorEnum.getByName(name))) {
                return operator;
            }
        }
        return null;
    }
}
