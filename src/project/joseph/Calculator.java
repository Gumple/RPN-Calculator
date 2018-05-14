package project.joseph;

import project.joseph.modes.CalculatingMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Calculator {
    private List<CalculatingMode> calculatingModes = new ArrayList<>();
    private CalculatingMode currentMode = null;
    private final static String EXIT_COMMAND = "exit";

    public Calculator(List<CalculatingMode> calculatingModes) {
        this.calculatingModes = calculatingModes;
        this.currentMode = calculatingModes.get(0);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (EXIT_COMMAND.equalsIgnoreCase(input.trim())) {
                powerOff();
            } else {
                currentMode.calculate(input);
            }
        }
    }

    //TODO: only RPNMode is available for now
    private void switchMode() {
    }

    public void powerOff() {
        System.exit(0);
    }
}
