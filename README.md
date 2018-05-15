RPN-Calculator
===============
A simple command-line based RPN calculator

File Hierarchy
--------------
```
.
|____src
| |____project
| | |____joseph
| | | |____Calculator.java
| | | |____CalculatorTest.java
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

run `mkdir bin` to create a directory to store `.class` files

compile using `javac -d bin project/joseph/Calculator.java`

run the application by `java -cp bin project.joseph.Calculator`


