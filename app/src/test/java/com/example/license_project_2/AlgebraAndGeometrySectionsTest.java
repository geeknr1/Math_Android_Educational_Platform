package com.example.license_project_2;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlgebraAndGeometrySectionsTest {
    @Test
    public void testAlgebraSectionsCorrectNumberOfLessons(){
        assertEquals(53, AlgebraSections.values().length);
    }

    @Test
    public void testGeometrySectionsCorrectNumberOfLessons(){
        assertEquals(36, GeometrySections.values().length);
    }

    @Test
    public void testAlgebraSectionsFirstLessonIsArithmeticOperations(){
        AlgebraSections firstLesson = AlgebraSections.values()[0];
        assertEquals(AlgebraSections.Arithmetic_Operations_on_Whole_Numbers, firstLesson);
    }

    @Test
    public void testGeometrySectionsFirstLessonIsFundamentalGeometryConcepts(){
        GeometrySections firstLesson = GeometrySections.values()[0];
        assertEquals(GeometrySections.Fundamental_Concepts_of_Geometry, firstLesson);
    }
}
