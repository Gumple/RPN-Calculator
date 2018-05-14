package project.joseph;

import project.joseph.modes.CalculatingMode;
import project.joseph.operators.OperatorEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Calculator {
    private List<CalculatingMode> calculatingModes = new ArrayList<>();
    private CalculatingMode currentMode = null;
    private final static String SAY_GOODBYE = "Goodbye!";

    public Calculator(List<CalculatingMode> calculatingModes) {
        this.calculatingModes = calculatingModes;
    }

    public void start() {
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
}
