package project.joseph;

import project.joseph.modes.CalculatingMode;
import project.joseph.modes.RPNMode;
import project.joseph.operators.OperatorEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * @author josephgan
 * @version 0.0.1
 */
public class Calculator {
    private List<CalculatingMode> calculatingModes = new ArrayList<>();
    private CalculatingMode currentMode = null;
    private final static String WELCOME_MSG =
                    "***************************************************\n" +
                    "*         Welcome to JOSimple Calculator!         *\n" +
                    "*                                                 *\n" +
                    "* @Author Joseph                                  *\n" +
                    "* @Version 0.0.1                                  *\n" +
                    "*                                                 *\n" +
                    "* (Enter \"exit\" to turn off the calculator)       *\n" +
                    "***************************************************";

    private final static String SAY_GOODBYE =
                    "***************************************************\n" +
                    "*                    GOODBYE!                     *\n" +
                    "***************************************************";

    public Calculator(List<CalculatingMode> calculatingModes) {
        this.calculatingModes = calculatingModes;
    }

    private void welcome() {
       System.out.println(WELCOME_MSG);
    }

    public void start() {
        welcome();
        switchMode(0);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (OperatorEnum.EXIT.getName().equalsIgnoreCase(input.trim())) {
                powerOff();
            } else {
                currentMode.calculate(input);
            }
        }
    }

    //TODO: only RPNMode is available for now
    public void switchMode(int i) {
        this.currentMode = calculatingModes.get(i);
        System.out.println(currentMode.description());
    }

    public void powerOff() {
        System.out.println(SAY_GOODBYE);
        System.exit(0);
    }

    public static void main(String[] args) {
        new Calculator(Arrays.asList(new RPNMode())).start();
    }
}
