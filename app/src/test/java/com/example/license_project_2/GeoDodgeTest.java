package com.example.license_project_2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Assert.*;

public class GeoDodgeTest {
    private int decrementHealth(int currentHealth) {
        return currentHealth - 1;
    }

    private boolean isGameOver(int healthBar) {
        return healthBar == 0;
    }

    private int addPoints(int currentPoints, int pointsToAdd) {
        return currentPoints + pointsToAdd;
    }

    @Test
    public void testDecrementHealth_from3_gives2() {
        assertEquals(2, decrementHealth(3));
    }

    @Test
    public void testIsGameOver_zeroHealth_returnsTrue() {
        assertTrue(isGameOver(0));
    }

    @Test
    public void testIsGameOver_oneHealth_returnsFalse() {
        assertFalse(isGameOver(1));
    }

    @Test
    public void testAddPoints_tenPointsPerExplosion() {
        assertEquals(10, addPoints(0, 10));
        assertEquals(50, addPoints(40, 10));
    }
}
