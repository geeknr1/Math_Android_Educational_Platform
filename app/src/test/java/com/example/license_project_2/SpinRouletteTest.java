package com.example.license_project_2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Assert.*;

public class SpinRouletteTest {
    private boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer != null &&
                userAnswer.trim().equals(correctAnswer);
    }

    @Test
    public void testAlgebraAnswerIsCorrectAndReturnsTrue(){
        assertTrue(checkAnswer("-2, -3", "-2, -3"));
    }

    @Test
    public void testAlgebraAnswerIsWrongAndReturnsFalse(){
        assertFalse(checkAnswer("0, 1", "-2, -3"));
    }

    @Test
    public void testAlgebraArraysAreTheSameLength() {
        String[] algebraProblems = {
                "Solve: x^2+5x+6 = 0",
                "Factor the quadratic equation x^2 - 5x + 6 = 0.",
                "Factor the quadratic equation x^2 - 4x + 4 = 0.",
                "Solve the inequality x + 3 < 5 + 2x.",
                "Solve the inequality x/5 + 3 < 8.",
                "Given a polynomial f(x) = x^3 - x^2 - 2x + 1. Factorize and find its roots.",
                "Solve 3x + 1/2 = (1/2)x - 13/2",
                "The sum of two numbers is 24 and their product is 128. Find the absolute difference of numbers.",
                "Solve  3e^x + 6 = 120",
                "If the sum of the square of two real numbers is 74 and their sum is 12."
        };
        String[] algebraAnswers = {
                "-2, -3", "(x-2)*(x-3)", "(x-2)^2",
                "x>-2", "x<25", "1.801, 0.447, -1.248",
                "-14/5", "8", "ln(38)", "468"
        };
        assertEquals(algebraProblems.length, algebraAnswers.length);
    }
}
