package com.example.a9726446.lab2wk3_additionapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 9726446 on 20/8/18 @ LB1-MAC-024
 */
public class CalculatorTest {

    private Calculator aCalc;

    @Before
    public void setUp() throws Exception {
        aCalc = new Calculator();
    }

    @Test
    public void additionTest() throws Exception {
        //expected 5, input: 2, 3.
        assertEquals("5",aCalc.addition("2","3"));
    }

    @Test
    public void decimalAdd() throws Exception{
        //expected 9.26, input: 5.7, 3.56
        assertEquals("9.26", aCalc.addition("5.7","3.56"));
    }

}