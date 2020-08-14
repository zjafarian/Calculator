package com.example.calculator.model;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Calculator implements Serializable {
    private String sending;
    private String resultCalculator;

    public String getResultCalculator() {
        return resultCalculator;
    }

    public Calculator(String sending) {
        this.sending = sending;
        selectOperation(sending);
    }

    private void selectOperation(String sending) {
        String operation = sending;
        String numOne;
        String numTwo;
        String numThree = "";
        char operationOne = ' ';
        char operationTwo = ' ';
        int i = 0;

        while (i < operation.length()) {
            if (operation.charAt(i) == '/' || operation.charAt(i) == '*' ||
                    operation.charAt(i) == '-' || operation.charAt(i) == '+') {
                numOne = operation.substring(0, i);
                numTwo = operation.substring(i + 1);
                operationOne = operation.charAt(i);
                for (int j = 0; j < numTwo.length(); j++) {
                    if (numTwo.charAt(j) == '/' || numTwo.charAt(j) == '*' ||
                            numTwo.charAt(j) == '-' || numTwo.charAt(j) == '+') {
                        numThree = numTwo.substring(0, j);
                        operationTwo = numTwo.charAt(j);
                        numTwo = numTwo.substring(j + 1);
                        break;
                    }
                }
                if (operationTwo != '/' && operationTwo != '*' && operationTwo != '-' && operationTwo != '+') {
                    switch (operationOne) {
                        case '/':
                            resultCalculator = division(Double.parseDouble(numOne), Double.parseDouble(numTwo));
                            break;
                        case '*':
                            resultCalculator = multiply(Double.parseDouble(numOne), Double.parseDouble(numTwo));
                            break;
                        case '+':
                            resultCalculator = sum(Double.parseDouble(numOne), Double.parseDouble(numTwo));
                            break;
                        case '-':
                            resultCalculator = subtraction(Double.parseDouble(numOne), Double.parseDouble(numTwo));
                            break;
                    }
                    break;
                } else {
                    switch (operationOne) {
                        case '/':
                            resultCalculator = division(Double.parseDouble(numOne), Double.parseDouble(numThree));
                            break;
                        case '*':
                            resultCalculator = multiply(Double.parseDouble(numOne), Double.parseDouble(numThree));
                            break;
                        case '+':
                            resultCalculator = sum(Double.parseDouble(numOne), Double.parseDouble(numThree));
                            break;
                        case '-':
                            resultCalculator = subtraction(Double.parseDouble(numOne), Double.parseDouble(numThree));
                            break;
                    }
                    operation = resultCalculator + operationTwo + numTwo;
                    operationTwo = ' ';
                    i = 0;
                }

            } else i++;
        }
    }

    public String sum(double number1, double number2) {
        double add;
        String pattern = "#";
        String result = "";
        String number;
        add = number1 + number2;
        if (add % 1 == 0) {
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            number = decimalFormat.format(add);
            result = number;
        } else {
            result = String.valueOf(add);
        }
        return result;
    }

    public String subtraction(double number1, double number2) {
        double mines;
        String pattern = "#";
        String result = "";
        String number;
        mines = number1 - number2;
        if (mines % 1 == 0) {
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            number = decimalFormat.format(mines);
            result = number;
        } else {
            result = String.valueOf(mines);
        }
        return result;
    }

    public String multiply(double number1, double number2) {
        double multi;
        String result = "";
        String pattern = "#";
        String number;
        multi = number1 * number2;
        if (multi % 1 == 0) {
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            number = decimalFormat.format(multi);
            result = number;
        } else {
            result = String.valueOf(multi);
        }
        return result;

    }

    public String division(double number1, double number2) {
        double div = 0;
        String pattern = "#";
        String result = "";
        String number;
        if (number2 == 0) {
            result = "Error";
        } else if (number1 == 0 && number2 == 0) {
            result = "Error";
        } else {
            div = number1 / number2;
            if (div % 1 == 0) {
                DecimalFormat decimalFormat = new DecimalFormat(pattern);
                number = decimalFormat.format(div);
                result = number;
            } else {
                result = String.valueOf(div);
            }
        }
        return result;

    }
}
