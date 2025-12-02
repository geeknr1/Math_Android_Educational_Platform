package com.example.license_project_2;


import android.content.Intent;

public enum AlgebraSections {
    Arithmetic_Operations_on_Whole_Numbers(R.string.SectionOneTheoryDef, R.string.SectionOneTheoryProperties, R.string.SectionOneTheoryWorkedExamples, R.string.SectionOneQuiz),
    Prime_and_Composite_Natural_Numbers(R.string.SectionTwoTheoryDef, R.string.SectionTwoTheoryProperties, R.string.SectionTwoTheoryWorkedExamples, R.string.SectionTwoQuiz),
    Common_Divisors_and_Multiples___Least_Common_Multiple(R.string.SectionThreeTheoryDef, R.string.SectionThreeTheoryProperties, R.string.SectionThreeTheoryWorkedExamples, R.string.SectionThreeQuiz),
    Fractions_and_Arithmetic_Operations_on_Them(R.string.SectionFourTheoryDef, R.string.SectionFourTheoryProperties, R.string.SectionFourTheoryWorkedExamples, R.string.SectionFourQuiz),
    Rational_Numbers___Periodic_Fractions(R.string.SectionFiveTheoryDef, R.string.SectionFiveTheoryProperties, R.string.SectionFiveTheoryWorkedExamples, R.string.SectionFiveQuiz),
    Number_Line___Modulus_of_a_Number(R.string.SectionSixTheoryDef, R.string.SectionSixTheoryProperties, R.string.SectionSixTheoryWorkedExamples, R.string.SectionSixQuiz),
    Exact_and_Composite_Values_of_Quantities___Method_of_Bounds(R.string.SectionOneTheoryDef_2, R.string.SectionOneTheoryProperties_2, R.string.SectionOneTheoryWorkedExamples_2, R.string.SectionOneQuiz_2),
    Absolute_and_Relative_Errors(R.string.SectionTwoTheoryDef_2, R.string.SectionTwoTheoryProperties_2, R.string.SectionTwoTheoryWorkedExamples_2, R.string.SectionTwoQuiz_2),
    Notation_of_Approximate_Values_of_Numbers(R.string.SectionThreeTheoryDef_2, R.string.SectionThreeTheoryProperties_2, R.string.SectionThreeTheoryWorkedExamples_2, R.string.SectionThreeQuiz_2),
    Addition_and_Subtraction_of_Approximate_Values_of_Numbers(R.string.SectionFourTheoryDef_2, R.string.SectionFourTheoryProperties_2, R.string.SectionFourTheoryWorkedExamples_2, R.string.SectionFourQuiz_2),
    Multiplication_and_Division_of_Approximate_Values_of_Numbers(R.string.SectionFiveTheoryDef_2, R.string.SectionFiveTheoryProperties_2, R.string.SectionFiveTheoryWorkedExamples_2, R.string.SectionFiveQuiz_2),
//    Concept_of_an_Irrational_Number(R.string.SectionOneTheory3),
//    Real_Numbers___Arithmetical_Roots___Rectangular_Coordinates_in_the_Planes(R.string.SectionTwoTheory3),
//    Powers_with_a_Natural_Exponent(R.string.SectionThreeTheory3),
//    Arithmetical_Square_Root(R.string.SectionFourTheory3),
//    Powers_with_an_Integral_Exponent(R.string.SectionFiveTheory3),
//    Notion_of_a_Power_with_an_Irrational_Exponent___The_Properties_of_a_Power_With_a_Real_Exponent(R.string.SectionSixTheory3),
//    Exercises_Chapter3(R.string.ExercisesThree);


    public final int theoryDef;
    public final int theoryProperties;
    public final int theoryWorkedExamples;
    public final int quiz;

    AlgebraSections(int def, int properties, int examples, int quiz){
        this.theoryDef = def;
        this.theoryProperties = properties;
        this.theoryWorkedExamples = examples;
        this.quiz = quiz;
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

