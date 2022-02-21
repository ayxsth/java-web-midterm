package com.iims.driver;

import com.iims.evalPrefix.EvalPre;
import com.iims.infixToPrefix.InToPre;

public class Mian {
    public static void main(String[] args) {
        String expression = " 2 - 1 + 5 * 4 / 2";
        expression = InToPre.infixToPrefix(expression);
        System.out.println(expression);
        double result = EvalPre.evaluatePrefix(expression);
        System.out.println(result);
    }
}
