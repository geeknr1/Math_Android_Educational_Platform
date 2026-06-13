package com.example.license_project_2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Assert.*;

public class MathShootTest{
    private int addPoints(int currentPoints, int pointsToAdd) {
        return currentPoints + pointsToAdd;
    }

    private boolean isOutOfBounds(int x, int screenX) {
        return x > screenX;
    }

    private boolean isOffScreen(int x, int width) {
        return x + width < 0;
    }

    @Test
    public void testAddPoints_onBulletHit() {
        assertEquals(10, addPoints(0, 10));
        assertEquals(30, addPoints(20, 10));
    }

    @Test
    public void testBulletOutOfBounds_returnsTrue() {
        assertTrue(isOutOfBounds(1921, 1920));
    }

    @Test
    public void testNumberOffScreen_returnsTrue() {
        assertTrue(isOffScreen(-101, 100));
    }
}
