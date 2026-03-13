package com.example.license_project_2;


import android.content.Intent;

public enum AlgebraSections {
    Arithmetic_Operations_on_Whole_Numbers(R.string.SectionOneTheoryDef, R.string.SectionOneTheoryProperties, R.string.SectionOneTheoryWorkedExamples, R.string.SectionOneQuiz),
    Prime_and_Composite_Natural_Numbers(R.string.SectionTwoTheoryDef, R.string.SectionTwoTheoryProperties, R.string.SectionTwoTheoryWorkedExamples, R.string.SectionTwoQuiz),
//    Common_Divisors_and_Multiples___Least_Common_Multiple(R.string.SectionThreeTheoryDef, R.string.SectionThreeTheoryProperties, R.string.SectionThreeTheoryWorkedExamples, R.string.SectionThreeQuiz),
//    Fractions_and_Arithmetic_Operations_on_Them(R.string.SectionFourTheoryDef, R.string.SectionFourTheoryProperties, R.string.SectionFourTheoryWorkedExamples, R.string.SectionFourQuiz),
//    Rational_Numbers___Periodic_Fractions(R.string.SectionFiveTheoryDef, R.string.SectionFiveTheoryProperties, R.string.SectionFiveTheoryWorkedExamples, R.string.SectionFiveQuiz),
//    Number_Line___Modulus_of_a_Number(R.string.SectionSixTheoryDef, R.string.SectionSixTheoryProperties, R.string.SectionSixTheoryWorkedExamples, R.string.SectionSixQuiz),
    Exact_and_Composite_Values_of_Quantities___Method_of_Bounds(R.string.SectionOneTheoryDef_2, R.string.SectionOneTheoryProperties_2, R.string.SectionOneTheoryWorkedExamples_2, R.string.SectionOneQuiz_2),
    Absolute_and_Relative_Errors(R.string.SectionTwoTheoryDef_2, R.string.SectionTwoTheoryProperties_2, R.string.SectionTwoTheoryWorkedExamples_2, R.string.SectionTwoTheoryQuiz_2),
//    Notation_of_Approximate_Values_of_Numbers(R.string.SectionThreeTheoryDef_2, R.string.SectionThreeTheoryProperties_2, R.string.SectionThreeTheoryWorkedExamples_2, R.string.SectionThreeQuiz_2),
//    Addition_and_Subtraction_of_Approximate_Values_of_Numbers(R.string.SectionFourTheoryDef_2, R.string.SectionFourTheoryProperties_2, R.string.SectionFourTheoryWorkedExamples_2, R.string.SectionFourQuiz_2),
//    Multiplication_and_Division_of_Approximate_Values_of_Numbers(R.string.SectionFiveTheoryDef_2, R.string.SectionFiveTheoryProperties_2, R.string.SectionFiveTheoryWorkedExamples_2, R.string.SectionFiveQuiz_2),
    Raising_Rational_Numbers_to_a_Power_with_a_Natural_Exponent___Taking_the_Root(R.string.SectionOneTheoryDef_3, R.string.SectionOneTheoryProperties_3, R.string.SectionOneTheoryWorkedExamples_3, R.string.SectionOneQuiz_3),
    Concept_of_an_Irrational_Number(R.string.SectionTwoTheoryDef_3, R.string.SectionTwoTheoryProperties_3, R.string.SectionTwoTheoryWorkedExamples_3, R.string.SectionTwoQuiz_3),
//    Real_Numbers___Arithmetical_Roots___Rectangular_Coordinates_in_the_Planes(R.string.SectionThreeTheoryDef_3, R.string.SectionThreeTheoryProperties_3, R.string.SectionThreeTheoryWorkedExamples_3, R.string.SectionThreeQuiz_3),
//    Powers_with_a_Natural_Exponent(R.string.SectionFourTheoryDef_3, R.string.SectionFourTheoryProperties_3, R.string.SectionFourTheoryWorkedExamples_3, R.string.SectionFourQuiz_3),
//    Arithmetical_Square_Root(R.string.SectionFiveTheoryDef_3, R.string.SectionFiveTheoryProperties_3, R.string.SectionFiveTheoryWorkedExamples_3, R.string.SectionFiveQuiz_3),
//    Powers_with_an_Integral_Exponent(R.string.SectionSixTheoryDef_3, R.string.SectionSixTheoryProperties_3, R.string.SectionSixTheoryWorkedExamples_3, R.string.SectionSixQuiz_3),
//    The_Arithmetical_nth_Root(R.string.SectionSevenTheoryDef_3, R.string.SectionSevenTheoryProperties_3, R.string.SectionSevenTheoryWorkedExamples_3, R.string.SectionSevenQuiz_3),
//    Powers_With_a_Rational_Exponent(R.string.SectionEightTheoryDef_3, R.string.SectionEightTheoryProperties_3, R.string.SectionEightTheoryWorkedExamples_3, R.string.SectionEightQuiz_3),
//    Notion_of_a_Power_with_an_Irrational_Exponent___The_Properties_of_a_Power_With_a_Real_Exponent(R.string.SectionNineTheoryDef_3, R.string.SectionNineTheoryProperties_3, R.string.SectionNineTheoryWorkedExamples_3, R.string.SectionNineQuiz_3),
    Numerical_and_Algebraic_Expressions(R.string.SectionOneTheoryDef_4, R.string.SectionOneTheoryProperties_4, R.string.SectionOneTheoryWorkedExamples_4, R.string.SectionOneQuiz_4),
    Ratios_of_Numbers_and_Homogenous_Quantities___PerCent(R.string.SectionTwoTheoryDef_4, R.string.SectionTwoTheoryProperties_4, R.string.SectionTwoTheoryWorkedExamples_4, R.string.SectionTwoQuiz_4),
//    Proportions(R.string.SectionThreeTheoryDef_4, R.string.SectionThreeTheoryProperties_4, R.string.SectionThreeTheoryWorkedExamples_4, R.string.SectionThreeQuiz_4),
//    Monomials_and_Polynomials___Their_Standard_Form(R.string.SectionFourTheoryDef_4, R.string.SectionFourTheoryProperties_4, R.string.SectionFourTheoryWorkedExamples_4, R.string.SectionFourQuiz_4),
//    Formulas_for_Abridged_Multiplication(R.string.SectionFiveTheoryDef_4, R.string.SectionFiveTheoryProperties_4, R.string.SectionFiveTheoryWorkedExamples_4, R.string.SectionFiveQuiz_4),
//    Polynomials_in_one_Variable(R.string.SectionSixTheoryDef_4, R.string.SectionSixTheoryProperties_4, R.string.SectionSixTheoryWorkedExamples_4, R.string.SectionSixQuiz_4),
//    Identical_Transformations_of_Polynomials(R.string.SectionSevenTheoryDef_4, R.string.SectionSevenTheoryProperties_4, R.string.SectionSevenTheoryWorkedExamples_4, R.string.SectionSevenQuiz_4),
//    Algebraic_Fractions___Irrational_Expressions(R.string.SectionEightTheoryDef_4, R.string.SectionEightTheoryProperties_4, R.string.SectionEightTheoryWorkedExamples_4, R.string.SectionEightQuiz_4),
    Equations_in_One_Variable___Root_of_an_Equation(R.string.SectionOneTheoryDef_5, R.string.SectionOneTheoryProperties_5, R.string.SectionOneTheoryWorkedExamples_5, R.string.SectionOneQuiz_5),
    Linear_Equations(R.string.SectionTwoTheoryDef_5, R.string.SectionTwoTheoryProperties_5, R.string.SectionTwoTheoryWorkedExamples_5, R.string.SectionTwoQuiz_5),
//    Quadratic_Equations___Viètes_Theorem(R.string.SectionThreeTheoryDef_5, R.string.SectionThreeTheoryProperties_5, R.string.SectionThreeTheoryWorkedExamples_5, R.string.SectionThreeQuiz_5),
//    Factorization_of_a_Quadratic_Trinomial(R.string.SectionFourTheoryDef_5, R.string.SectionFourTheoryProperties_5, R.string.SectionFourTheoryWorkedExamples_5, R.string.SectionFourQuiz_5),
//    Equations_Reducible_to_Linear_and_Quadratic_Equations(R.string.SectionFiveTheoryDef_5, R.string.SectionFiveTheoryProperties_5, R.string.SectionFiveTheoryWorkedExamples_5, R.string.SectionFiveQuiz_5),
//    Equations_in_Several_Unknowns___Systems_of_Equations(R.string.SectionSixTheoryDef_5, R.string.SectionSixTheoryProperties_5, R.string.SectionSixTheoryWorkedExamples_5, R.string.SectionSixQuiz_5),
//    System_of_Two_Equations_of_the_First_Degree_in_Two_Unknowns(R.string.SectionSevenTheoryDef_5, R.string.SectionSevenTheoryProperties_5, R.string.SectionSevenTheoryWorkedExamples_5, R.string.SectionSevenQuiz_5),
//    Equations_and_Systems_of_Equations___Solution_of_Problems(R.string.SectionEightTheoryDef_5, R.string.SectionEightTheoryProperties_5, R.string.SectionEightTheoryWorkedExamples_5, R.string.SectionEightQuiz_5),
//    Problems_on_Setting_Up_Equations(R.string.SectionNineTheoryDef_5, R.string.SectionNineTheoryProperties_5, R.string.SectionNineTheoryWorkedExamples_5, R.string.SectionNineQuiz_5),
//    Inequalities_and_Their_Properties(R.string.SectionTenTheoryDef_5, R.string.SectionTenTheoryProperties_5, R.string.SectionTenTheoryWorkedExamples_5, R.string.SectionTenQuiz_5),
//    Proving_Inequalities(R.string.SectionElevenTheoryDef_5, R.string.SectionElevenTheoryProperties_5, R.string.SectionElevenTheoryWorkedExamples_5, R.string.SectionElevenQuiz_5),
//    Solving_Linear_and_Quadratic_Inequalities_in_One_Unknown(R.string.SectionTwelveTheoryDef_5, R.string.SectionTwelveTheoryProperties_5, R.string.SectionTwelveTheoryWorkedExamples_5, R.string.SectionTwelveQuiz_5),
//    Systems_of_Inequalities_in_One_Unknown___Inequalities_Containing_a_Modulus(R.string.SectionThirteenTheoryDef_5, R.string.SectionThirteenTheoryProperties_5, R.string.SectionThirteenTheoryWorkedExamples_5, R.string.SectionThirteenQuiz_5),
//    Problems_on_Equations_and_Inequalities___Method_of_Intervals(R.string.SectionFourteenTheoryDef_5, R.string.SectionFourteenTheoryProperties_5, R.string.SectionFourteenTheoryWorkedExamples_5, R.string.SectionFourteenQuiz_5),
    Concept_of_a_Function___Methods_of_Representing_Functions(R.string.SectionOneTheoryDef_6, R.string.SectionOneTheoryProperties_6, R.string.SectionOneTheoryWorkedExamples_6, R.string.SectionOneQuiz_6),
    Properties_of_Functions(R.string.SectionTwoTheoryDef_6, R.string.SectionTwoTheoryProperties_6, R.string.SectionTwoTheoryWorkedExamples_6, R.string.SectionTwoQuiz_6),
//    Inverse_of_a_Function(R.string.SectionThreeTheoryDef_6, R.string.SectionThreeTheoryProperties_6, R.string.SectionThreeTheoryWorkedExamples_6, R.string.SectionThreeQuiz_6),
//    Properties_and_Graphs_of_Certain_Simplest_Functions(R.string.SectionFourTheoryDef_6, R.string.SectionFourTheoryProperties_6, R.string.SectionFourTheoryWorkedExamples_6, R.string.SectionFourQuiz_6),
//    Graphical_Method_of_Solving_Equations_and_Systems_of_Equations___Equation_of_a_Circle(R.string.SectionFiveTheoryDef_6, R.string.SectionFiveTheoryProperties_6, R.string.SectionFiveTheoryWorkedExamples_6, R.string.SectionFiveQuiz_6),
//    Application_of_Graphs_to_Solving_Inequalities(R.string.SectionSixTheoryDef_6, R.string.SectionSixTheoryProperties_6, R.string.SectionSixTheoryWorkedExamples_6, R.string.SectionSixQuiz_6),
    Number_Sequences(R.string.SectionOneTheoryDef_7, R.string.SectionOneTheoryProperties_7, R.string.SectionOneTheoryWorkedExamples_7, R.string.SectionOneQuiz_7),
    Arithmetic_Progression(R.string.SectionTwoTheoryDef_7, R.string.SectionTwoTheoryProperties_7, R.string.SectionTwoTheoryWorkedExamples_7, R.string.SectionTwoQuiz_7);
//    Geometric_Progression(R.string.SectionThreeTheoryDef_7, R.string.SectionThreeTheoryProperties_7, R.string.SectionThreeTheoryWorkedExamples_7, R.string.SectionThreeQuiz_7),
//    Problems_on_Progressions(R.string.SectionFourTheoryDef_7, R.string.SectionFourTheoryProperties_7, R.string.SectionFourWorkedExamples_7, R.string.SectionFourQuiz_7),
//    Taking_Logarithms_and_Antilogarithms(R.string.SectionFiveTheoryDef_7, R.string.SectionFiveTheoryProperties_7, R.string.SectionFiveWorkedExamples_7, R.string.SectionFiveQuiz_7);









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

