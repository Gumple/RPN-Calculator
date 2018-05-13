package project.joseph;

import project.joseph.modes.CalculatingMode;
import project.joseph.modes.RPNMode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Calculator {
    private Set<CalculatingMode> calculatingModes = new HashSet<>();

    public Calculator(Set<CalculatingMode> calculatingModes) {
        this.calculatingModes = calculatingModes;
    }

    private void start() {
    }

    private void switchMode() {
    }

    private void powerOff() {
        System.exit(0);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new HashSet<>(Arrays.asList(new RPNMode())));
    }
}
