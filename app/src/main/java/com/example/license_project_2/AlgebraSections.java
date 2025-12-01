package com.example.license_project_2;


import android.content.Intent;

public enum AlgebraSections {
    Arithmetic_Operations_on_Whole_Numbers(R.string.SectionOneTheory),
    Prime_and_Composite_Natural_Numbers(R.string.SectionTwoTheory),
    Common_Divisors_and_Multiples___Least_Common_Multiple(R.string.SectionThreeTheory),
    Fractions_and_Arithmetic_Operations_on_Them(R.string.SectionFourTheory),
    Rational_Numbers___Periodic_Fractions(R.string.SectionFiveTheory),
    Number_Line___Modulus_of_a_Number(R.string.SectionSixTheory),
    Exercises_Chapter1(R.string.ExercisesOne),
    Exact_and_Composite_Values_of_Quantities___Method_of_Bounds(R.string.SectionOneTheory2),
    Absolute_and_Relative_Errors(R.string.SectionTwoTheory2),
    Notation_of_Approximate_Values_of_Numbers(R.string.SectionThreeTheory2),
    Multiplication_and_Division_of_Approximate_Values_of_Numbers(R.string.SectionFourTheory2),
    Exercises_Chapter2(R.string.ExercisesTwo),
    Concept_of_an_Irrational_Number(R.string.SectionOneTheory3),
    Real_Numbers___Arithmetical_Roots___Rectangular_Coordinates_in_the_Planes(R.string.SectionTwoTheory3),
    Powers_with_a_Natural_Exponent(R.string.SectionThreeTheory3),
    Arithmetical_Square_Root(R.string.SectionFourTheory3),
    Powers_with_an_Integral_Exponent(R.string.SectionFiveTheory3),
    Notion_of_a_Power_with_an_Irrational_Exponent___The_Properties_of_a_Power_With_a_Real_Exponent(R.string.SectionSixTheory3),
    Exercises_Chapter3(R.string.ExercisesThree);


    public final int theory;

    AlgebraSections(int theory){
        this.theory = theory;
    }

    private static final String NAME = AlgebraSections.class.getName();

    public void attachTo(Intent intent){
        intent.putExtra(NAME, ordinal());
    }

    public static AlgebraSections detachFrom(Intent intent){
        if(!intent.hasExtra(NAME)) throw new IllegalStateException("No vacation type");
        return values()[intent.getIntExtra(NAME,-1)];
    }
}

