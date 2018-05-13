package project.joseph.modes;

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
        description = "";
        operators = new HashSet<>();
        operators.add(new Addition());
        operators.add(new Subtraction());
        operators.add(new Multiplication());
        operators.add(new Division());
        operators.add(new SquareRoot());
        operators.add(new Clear());
        operators.add(new Undo());
    }

    private static List<String> history = new ArrayList<>();
    private final String DELIMITER = ":";

    @Override
    public String description() {
        return description;
    }

    @Override
    public void calculate(String input) {
        String[] items = input.split(" ");
        List<String> validItems = Arrays.stream(items).filter(x -> !x.isEmpty()).collect(Collectors.toList());
        if (validItems.size() > 0) {

            int idx = 0;
            ListIterator<String> iterator = validItems.listIterator();
            while (iterator.hasNext()) {
                String item = iterator.next();
                Operator operator = getByName(item);
            }

        } else {
            displayStack();
        }

    }

    private void execute(List<String> items) {
        history = items;
        int idx = 0;
        for (String item : items) {
            try {
                Double number = Double.valueOf(item);
                stack.push(number);
            } catch (NumberFormatException e) {
                Operator operator = getByName(item);
                try {
                    operator.execute(stack);
                } catch (CalculatorException ce) {
                    //TODO print error message
                    displayStack();
                } catch (NullPointerException ne) {
                    System.out.println("illegal operator");
                    displayStack();
                }
            }
        }
    }

    private void displayStack() {
        System.out.print("stack: ");
        stack.stream().forEach(x -> {
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
