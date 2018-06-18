RPN-Calculator
===============
A simple command-line based RPN calculator


Description
------------
- The calculator has a stack that can contain real numbers.
- The calculator waits for user input and expects to receive strings containing
  whitespace separated lists of numbers and operators.
- Numbers are pushed on to the stack. Operators operate on numbers that are on
  the stack.
- Available operators are +, -, *, /, sqrt, undo, clear
- Operators pop their parameters off the stack, and push their results back onto
  the stack.
- The ‘clear’ operator removes all items from the stack.
- The ‘undo’ operator undoes the previous operation. “undo undo” will undo the
  previo us two operations.
- sqrt performs a square root on the top item from the stack
- The ‘+’, ‘-’, ‘*’, ‘/’ operators perform addition, subtraction, multiplication and
  division respectively on the top two items from the
- stack.
- After processing an input string, the calculator displays the current contents of the stack as a space-separated list.
- Numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal places (or less if it causes no loss of precision).
- All numbers should be formatted as plain decimal strings (ie. no engineering formatting).
- If an operator cannot find a sufficient number of parameters on the stack, a warning is displayed:
  operator <operator> (position: <pos>): insufficient parameters
- After displaying the warning, all further processing of the string terminates and the current state of the stack is displayed.

File Hierarchy
--------------
```
.
|____src
| |____project
| | |____joseph
| | | |____Calculator.java
| | | |____modes
| | | | |____RPNMode.java
| | | | |____CalculatingMode.java
| | | |____operators
| | | | |____Addition.java
| | | | |____Multiplication.java
| | | | |____Operator.java
| | | | |____SquareRoot.java
| | | | |____Subtraction.java
| | | | |____Clear.java
| | | | |____OperatorEnum.java
| | | | |____Division.java
| | | |____exceptions
| | | | |____CalculatorException.java
| | | | |____CalculatorError.java
|____README.md
```

How to run the program
-------------------
go under `/src` directory

run `mkdir ../bin` to create a directory to store `.class` files

compile using `javac -d ../bin project/joseph/Calculator.java`

run the application by `java -cp ../bin project.joseph.Calculator`


