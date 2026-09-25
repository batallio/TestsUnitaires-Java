package com.angelbatalla.calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public static int add(int opG, int opD) {
        return opG + opD;
    }

    public static int divide(int opG, int opD) {

        if (opD == 0) {
            throw new ArithmeticException("Division entre zero.");
        }

        return opG / opD;
    }

    public Set<Integer> ensembleChiffres(int pNombre) {
        // Convert the absolute value of the number to a string to handle negative numbers safely
        String numberStr = String.valueOf(Math.abs(pNombre));

        // Convert the string to an array of characters
        char[] digits = numberStr.toCharArray();

        // Create a Set to store the unique digits
        Set<Integer> chiffreSet = new HashSet<>();
        for (char c : digits) {
            // Convert the char digit to an int and add it to the set
            chiffreSet.add(Character.getNumericValue(c));
        }

        return chiffreSet;
    }
}
