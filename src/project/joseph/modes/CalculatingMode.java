package project.joseph.modes;

import project.joseph.operators.Operator;

import java.util.Set;
import java.util.Stack;

/**
 * Created by josephgan on 5/12/18.
 *
 * defines calculating mode in a calculator, it has
 * 1. the description of the mode
 * 2. the implementation of calculation based on user's input
 *
 * @see RPNMode
 */
public interface CalculatingMode {
    String description();
    void calculate(String input);
}
