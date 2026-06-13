package com.example.license_project_2;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Assert.*;

public class TicTacToeMainTest {
    private int calculatePlusPlus(int a, int b, int c) {
        return a + b + c;
    }

    private int calculateMinusMinus(int a, int b, int c) {
        return a - b - c;
    }

    private int calculateProductProduct(int a, int b, int c) {
        return a * b * c;
    }

    private double calculateDivisionDivision(int a, int b, int c) {
        return (double) a / (double) b / (double) c;
    }

    private int calculatePlusMinus(int a, int b, int c) {
        return a + b - c;
    }

    @Test
    public void testPlusPlus_correctResult() {
        assertEquals(15, calculatePlusPlus(4, 5, 6));
    }

    @Test
    public void testMinusMinus_correctResult() {
        assertEquals(1, calculateMinusMinus(8, 4, 3));
    }

    @Test
    public void testProductProduct_correctResult() {
        assertEquals(24, calculateProductProduct(2, 3, 4));
    }

    @Test
    public void testDivisionDivision_correctResult() {
        assertEquals(0.5, calculateDivisionDivision(4, 4, 2), 0.001);
    }

    @Test
    public void testPlusMinus_correctResult() {
        assertEquals(4, calculatePlusMinus(3, 4, 3));
    }
}
