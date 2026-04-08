package com.example.license_project_2;

import android.content.Intent;

public enum GeometrySections {
    Fundamental_Concepts_of_Geometry(R.string.SectionOneTheoryDef_8, R.string.SectionOneTheoryProperties_8, R.string.SectionOneTheoryWorkedExamples_8, R.string.SectionOneQuiz_8, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Geometric_Figures(R.string.SectionTwoTheoryDef_8, R.string.SectionTwoTheoryProperties_8, R.string.SectionTwoTheoryWorkedExamples_8, R.string.SectionTwoQuiz_8, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Triangles(R.string.SectionOneTheoryDef_9, R.string.SectionOneTheoryProperties_9, R.string.SectionOneTheoryWorkedExamples_9, R.string.SectionOneQuiz_9, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Basic_Geometric_Constructions(R.string.SectionTwoTheoryDef_9, R.string.SectionTwoTheoryProperties_9, R.string.SectionTwoTheoryWorkedExamples_9, R.string.SectionTwoQuiz_9, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Parallel_Lines(R.string.SectionThreeTheoryDef_9, R.string.SectionThreeTheoryProperties_9, R.string.SectionThreeTheoryWorkedExamples_9, R.string.SectionThreeQuiz_9, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Quadrilaterals(R.string.SectionFourTheoryDef_9, R.string.SectionFourTheoryProperties_9, R.string.SectionFourTheoryWorkedExamples_9, R.string.SectionFourQuiz_9, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Mutual_Position_of_a_Straight_Line_and_a_Circle___Tangent_Line_to_a_Circle(R.string.SectionOneTheoryDef_10, R.string.SectionOneTheoryProperties_10, R.string.SectionOneTheoryWorkedExamples_10, R.string.SectionOneQuiz_10, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Angles_in_a_Circles(R.string.SectionTwoTheoryDef_10, R.string.SectionTwoTheoryProperties_10, R.string.SectionTwoTheoryWorkedExamples_10, R.string.SectionTwoQuiz_10, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Properties_of_Chords_and_Diameters_of_a_Circle(R.string.SectionThreeTheoryDef_10, R.string.SectionThreeTheoryProperties_10, R.string.SectionThreeTheoryWorkedExamples_10, R.string.SectionThreeQuiz_10, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Inscribed_and_Circumscribed_Polygons(R.string.SectionFourTheoryDef_10, R.string.SectionFourTheoryProperties_10, R.string.SectionFourTheoryWorkedExamples_10, R.string.SectionFourQuiz_10, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Four_Remarkable_Points_in_a_Triangle(R.string.SectionFiveTheoryDef_10, R.string.SectionFiveTheoryProperties_10, R.string.SectionFiveTheoryWorkedExamples_10, R.string.SectionFiveQuiz_10, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Proportional_Line_Segments(R.string.SectionOneTheoryDef_11, R.string.SectionOneTheoryProperties_11, R.string.SectionOneTheoryWorkedExamples_11, R.string.SectionOneQuiz_11, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Similar_Triangles(R.string.SectionTwoTheoryDef_11, R.string.SectionTwoTheoryProperties_11, R.string.SectionTwoTheoryWorkedExamples_11, R.string.SectionTwoQuiz_11, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Pythagorean_Theorem(R.string.SectionThreeTheoryDef_11, R.string.SectionThreeTheoryProperties_11, R.string.SectionThreeTheoryWorkedExamples_11, R.string.SectionThreeQuiz_11, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Property_of_an_Angle_Bisector_of_a_Triangle___Proportionality_of_Segments_of_Chords_and_Secants(R.string.SectionFourTheoryDef_11, R.string.SectionFourTheoryProperties_11, R.string.SectionFourTheoryWorkedExamples_11, R.string.SectionFourQuiz_11, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Similar_Polygons(R.string.SectionFiveTheoryDef_11, R.string.SectionFiveTheoryProperties_11, R.string.SectionFiveTheoryWorkedExamples_11, R.string.SectionFiveQuiz_11, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Examples_of_Transformations_of_Figures(R.string.SectionOneTheoryDef_12, R.string.SectionOneTheoryProperties_12, R.string.SectionOneTheoryWorkedExamples_12, R.string.SectionOneQuiz_12, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Motion___Congruence_of_Figures(R.string.SectionTwoTheoryDef_12, R.string.SectionTwoTheoryProperties_12, R.string.SectionTwoTheoryWorkedExamples_12, R.string.SectionTwoQuiz_12, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Transformation_of_Similitude(R.string.SectionThreeTheoryDef_12, R.string.SectionThreeTheoryProperties_12, R.string.SectionThreeTheoryWorkedExamples_12, R.string.SectionThreeQuiz_12, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Addition_and_Subtraction_of_Vectors(R.string.SectionOneTheoryDef_13, R.string.SectionOneTheoryProperties_13, R.string.SectionOneTheoryWorkedExamples_13, R.string.SectionOneQuiz_13, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Multiplication_of_a_Vector_by_a_Number(R.string.SectionTwoTheoryDef_13, R.string.SectionTwoTheoryProperties_13, R.string.SectionTwoTheoryWorkedExamples_13, R.string.SectionTwoQuiz_13, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Coordinates_of_a_Vector_in_the_Plane(R.string.SectionThreeTheoryDef_13, R.string.SectionThreeTheoryProperties_13, R.string.SectionThreeTheoryWorkedExamples_13, R.string.SectionThreeQuiz_13, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Rotations_Through_Angles_of_Any_Measure(R.string.SectionFourTheoryDef_13, R.string.SectionFourTheoryProperties_13, R.string.SectionFourTheoryWorkedExamples_13, R.string.SectionFourQuiz_13, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Trigonometric_Functions___the_Sine_Cosine_and_Tangent_of_an_Angle(R.string.SectionFiveTheoryDef_13, R.string.SectionFiveTheoryProperties_13, R.string.SectionFiveTheoryWorkedExamples_13, R.string.SectionFiveQuiz_13, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Relationships_Between_the_Sides_and_Angles_in_a_Right_Triangle(R.string.SectionSixTheoryDef_13, R.string.SectionSixTheoryProperties_13, R.string.SectionSixTheoryWorkedExamples_13, R.string.SectionSixQuiz_13, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Metric_Relationships_in_an_Arbitrary_Triangle___Theorem_of_Sines_and_Theorem_of_Cosines(R.string.SectionSevenTheoryDef_13, R.string.SectionSevenTheoryProperties_13, R.string.SectionSevenTheoryWorkedExamples_13, R.string.SectionSevenQuiz_13, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Notion_of_the_Area_of_a_Polygon(R.string.SectionOneTheoryDef_14, R.string.SectionOneTheoryProperties_14, R.string.SectionOneTheoryWorkedExamples_14, R.string.SectionOneQuiz_14, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Areas_of_a_Parallelogram__a_Triangle_and_a_Trapezoid(R.string.SectionTwoTheoryDef_14, R.string.SectionTwoTheoryProperties_14, R.string.SectionTwoTheoryWorkedExamples_14, R.string.SectionTwoQuiz_14, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Area_of_a_Polygon___Ratio_of_the_Areas_of_Similar_Polygons(R.string.SectionThreeTheoryDef_14, R.string.SectionThreeTheoryProperties_14, R.string.SectionThreeTheoryWorkedExamples_14, R.string.SectionThreeQuiz_14, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Regular_Polygons(R.string.SectionOneTheoryDef_15, R.string.SectionOneTheoryProperties_15, R.string.SectionOneTheoryWorkedExamples_15, R.string.SectionOneQuiz_15, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Length_of_Circumferencе(R.string.SectionTwoTheoryDef_15, R.string.SectionTwoTheoryProperties_15, R.string.SectionTwoTheoryWorkedExamples_15, R.string.SectionTwoQuiz_15, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Area_of_a_Circle(R.string.SectionThreeTheoryDef_15, R.string.SectionThreeTheoryProperties_15, R.string.SectionThreeTheoryWorkedExamples_15, R.string.SectionThreeQuiz_15, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Axioms_of_Solid_Geometry(R.string.SectionOneTheoryDef_16, R.string.SectionOneTheoryProperties_16, R.string.SectionOneTheoryWorkedExamples_16, R.string.SectionOneQuiz_16, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Straight_Lines_and_Planes_in_Space(R.string.SectionTwoTheoryDef_16, R.string.SectionTwoTheoryProperties_16, R.string.SectionTwoTheoryWorkedExamples_16, R.string.SectionTwoQuiz_16, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Polyhedrons___Right_Prism__Rectangular_Parallelepiped__Pyramid_and_Regular_Pyramid(R.string.SectionThreeTheoryDef_16, R.string.SectionThreeTheoryProperties_16, R.string.SectionThreeTheoryWorkedExamples_16, R.string.SectionThreeQuiz_16, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive),
    Solids_of_Revolution___Cylinder__Cone_and_Ball(R.string.SectionFourTheoryDef_16, R.string.SectionFourTheoryProperties_16, R.string.SectionFourTheoryWorkedExamples_16, R.string.SectionFourQuiz_16, R.drawable.testone, R.drawable.testtwo, R.drawable.testthree, R.drawable.testfour, R.drawable.testfive);
    public final int theoryDef;
    public final int theoryProperties;
    public final int theoryWorkedExamples;
    public final int quiz;
    public final int requirementOne, requirementTwo, requirementThree, requirementFour, requirementFive;


    GeometrySections(int def, int properties, int examples, int quiz, int one, int two, int three, int four, int five){
        this.theoryDef = def;
        this.theoryProperties = properties;
        this.theoryWorkedExamples = examples;
        this.quiz = quiz;
        this.requirementOne = one; this.requirementTwo = two; this.requirementThree = three; this.requirementFour = four; this.requirementFive = five;
    }

    private static final String NAME = GeometrySections.class.getName();

    public void attachTo(Intent intent){
        intent.putExtra(NAME, ordinal());
    }

    public static GeometrySections detachFrom(Intent intent){
        if(!intent.hasExtra(NAME)) throw new IllegalStateException("No vacation type");
        return values()[intent.getIntExtra(NAME,-1)];
    }
}

