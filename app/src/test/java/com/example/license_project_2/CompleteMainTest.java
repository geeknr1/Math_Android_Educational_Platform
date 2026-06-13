package com.example.license_project_2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Assert.*;

public class CompleteMainTest {
    private boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer != null && userAnswer.trim().equals(correctAnswer);
    }

    private int getNextProblemIndex(int currentIndex, int totalProblems) {
        return currentIndex + 2;
    }

    private boolean isGameFinished(int nextIndex, int totalProblems) {
        return nextIndex + 2 >= totalProblems;
    }

    @Test
    public void testCheckAnswerWhetherIsCorrectAnswerAndReturnsTrue() {
        assertTrue(checkAnswer("120,240", "120,240"));
    }

    @Test
    public void testCheckAnswerWhetherIsWrongAnswerAndReturnsFalse() {
        assertFalse(checkAnswer("100", "120,240"));
    }

    @Test
    public void testCheckAnswerWhetherAnswerWithExtraSpacesReturnsTrue() {
        assertTrue(checkAnswer("  120,240  ", "120,240"));
    }

    @Test
    public void testWhetherNextProblemIndexAdvancesByTwo() {
        assertEquals(4, getNextProblemIndex(2, 74));
        assertEquals(10, getNextProblemIndex(8, 74));
    }

    @Test
    public void testIsGameFinishedAtLastPairAndReturnsTrue() {
        assertTrue(isGameFinished(72, 74));
    }

    @Test
    public void testIsGameFinishedInMiddleOfGameAndReturnsFalse() {
        assertFalse(isGameFinished(20, 74));
    }
}
