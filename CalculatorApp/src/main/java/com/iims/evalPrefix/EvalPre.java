package com.iims.evalPrefix;

import java.util.Stack;

public class EvalPre {
    static Stack<Double> stack = new Stack<Double>();

    static Boolean isOperand(char numOp) {
        return numOp >= 48 && numOp <= 57;
    }

    public static double evaluatePrefix(String expression) {
        String[] numOps = expression.split("\\s+");

        for (int i = numOps.length - 1; i >= 0; i--) {
            if (isOperand(numOps[i].charAt(0)))
                stack.push(Double.parseDouble(numOps[i]));

            else {
                for (String num: numOps){
                    System.out.println(num);
                }

                System.out.println("----------------------");

                double numOne = stack.pop();
                double numTwo = stack.pop();

                calculate(numOne, numTwo, numOps[i]);

                for (Double num: stack){
                    System.out.println(num);
                }

                System.out.println("=======================");
            }
        }

        return stack.peek();
    }

    static void calculate(Double numOne, Double numTwo, String operator) {
        switch (operator) {
            case "+":
                stack.push(numOne + numTwo);
                break;
            case "-":
                stack.push(numTwo - numOne);
                break;
            case "*":
                stack.push(numOne * numTwo);
                break;
            case "/":
                stack.push(numOne / numTwo);
                break;
        }
    }
}
