package com.example.a9726446.lab2wk3_additionapp;

/**
 * Created by 9726446 on 17/8/18 via LB1-MAC-024
 */

public class Calculator {

    /// Takes two numbers and adds them together.
    /// num1, num2: Strings. Should be forced to be numbers during input.
    public String addition (String num1, String num2){
        try {
            double ex = Double.parseDouble(num1);
            double why = Double.parseDouble(num2);
            return String.format("%f", ex + why);
        } catch (NumberFormatException nfe){
            return "ERR";
        }
    }
}
