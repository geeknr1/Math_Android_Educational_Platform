package com.example.license_project_2.MathRoulette;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;
import com.example.license_project_2.audio.BackgroundMusicHelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.license_project_2.Games;
import com.example.license_project_2.R;

import java.util.Random;

public class RouletteMain extends AppCompatActivity {
    private static final String[] sectors = {"Algebra","Geometry","Calculus","Trigonometry"};
    private static final String[] algebraProblems = {
            "1. Solve: x^2 + 5x + 6 = 0",
            "2. Factor the quadratic equation x^2 - 5x + 6 = 0.",
            "3. Factor the quadratic equation x^2 - 4x + 4 = 0.",
            "4. Solve the inequality x + 3 < 5 + 2x.",
            "5. Solve the inequality x/5 + 3 < 8.",
            "6. Given a polynomial f(x) = x^3 - x^2 - 2x + 1. Factorize and find its roots.",
            "7. Solve 3x + 1/2 = (1/2)x - 13/2",
            "8. The sum of two numbers is 24 and their product is 128. Find the absolute difference of numbers.",
            "9. Solve 3e^x + 6 = 120",
            "10. If the sum of the squares of two real numbers is 74 and their sum is 12. Then the sum of cubes of these two numbers is ...",
            "11. Solve: x^2 - 9 = 0",
            "12. Solve: 2x^2 - 8 = 0",
            "13. Solve: x^2 + 4x + 4 = 0",
            "14. Solve: x^2 - 7x + 12 = 0",
            "15. Solve: x^2 + x - 6 = 0",
            "16. Solve: 2x + 3 = 11",
            "17. Solve: 5x - 2 = 3x + 8",
            "18. Solve: 3(x - 2) = 2(x + 1)",
            "19. Solve: x/3 + x/4 = 7",
            "20. Solve: 2x^2 + 5x - 3 = 0",
            "21. Solve: x^2 - 2x - 15 = 0",
            "22. Solve: x^2 + 6x + 9 = 0",
            "23. Solve: x^2 - 10x + 25 = 0",
            "24. Solve: 4x^2 - 36 = 0",
            "25. Solve: x^2 + 3x = 0",
            "26. Solve: 2x^2 - 3x - 2 = 0",
            "27. Simplify: (x^2 - 9) / (x - 3)",
            "28. Simplify: (x^2 - 1) / (x + 1)",
            "29. Solve the inequality 2x - 3 > 7",
            "30. Solve the inequality 3x + 1 <= 10",
            "31. Solve: log2(x) = 4",
            "32. Solve: log3(x) = 3",
            "33. Solve: 2^x = 32",
            "34. Solve: 3^x = 81",
            "35. Solve: e^x = 7",
            "36. Solve: ln(x) = 3",
            "37. Solve: |x - 3| = 5",
            "38. Solve: |2x + 1| = 7",
            "39. Find the sum of roots of x^2 - 7x + 10 = 0",
            "40. Find the product of roots of x^2 - 7x + 10 = 0",
            "41. Solve the system: x + y = 5, x - y = 1",
            "42. Solve the system: 2x + y = 7, x - y = 2",
            "43. Solve: x^2 - 5x + 6 > 0",
            "44. Solve: x^2 - 4 < 0",
            "45. Evaluate: 2^10",
            "46. Simplify: (2x^3)(3x^2)",
            "47. Simplify: (x^4)/(x^2)",
            "48. Expand: (x + 3)^2",
            "49. Expand: (x - 4)^2",
            "50. Expand: (x + 2)(x - 2)",
            "51. Expand: (2x + 1)(x - 3)",
            "52. Solve: 5x + 15 = 0",
            "53. Solve: 7x - 21 = 0",
            "54. Solve: 4x^2 = 100",
            "55. Solve: x^3 = 27",
            "56. Solve: x^3 = -8",
            "57. Find the discriminant of x^2 - 4x + 3",
            "58. Find the discriminant of x^2 + x + 1",
            "59. Solve: 2^(x+1) = 16",
            "60. Solve: 9^x = 27",
            "61. Simplify: (3x^2 - 6x) / (3x)",
            "62. Solve: x^2 + 2x - 8 = 0",
            "63. Solve: x^2 - 3x - 10 = 0",
            "64. Solve: 3x^2 - 12 = 0",
            "65. Solve: x^2 + 5x = -6",
            "66. Solve: x^2 = 0",
            "67. Solve: (x - 1)(x + 4) = 0",
            "68. Solve: (2x - 3)(x + 1) = 0",
            "69. Solve: x^2 - 8x + 15 = 0",
            "70. Solve: x^2 + 2x - 35 = 0",
            "71. Solve: 2x - 5 = x + 3",
            "72. Solve: 4(x + 1) = 3(x + 2)",
            "73. Solve: x/2 - 1 = 3",
            "74. Solve: 3x/4 = 9",
            "75. Solve: 2x + 1 = 0",
            "76. Solve: 5x^2 = 20",
            "77. Solve: x^2 - x = 0",
            "78. Solve: x^2 + x = 0",
            "79. Find the vertex x-coordinate of y = x^2 - 4x + 1",
            "80. Find the vertex y-coordinate of y = x^2 - 4x + 1",
            "81. Solve: log(x) = 2",
            "82. Solve: log(x) + log(2) = log(10)",
            "83. Solve: 4^x = 64",
            "84. Solve: e^(2x) = e^6",
            "85. Solve: 2ln(x) = ln(9)",
            "86. Solve: |x| = 9",
            "87. Solve: |3x - 6| = 0",
            "88. Solve the system: x + 2y = 8, 3x - 2y = 0",
            "89. Solve the system: 2x - y = 1, x + y = 5",
            "90. Solve: x^2 - 16 = 0",
            "91. Solve: x^2 + 7x + 10 = 0",
            "92. Solve: x^2 - x - 20 = 0",
            "93. Simplify: (x^2 - 4) / (x - 2)",
            "94. Evaluate: 3^4",
            "95. Evaluate: 5^3",
            "96. Solve: x^4 = 16",
            "97. Solve: x^2 + 4x - 12 = 0",
            "98. Solve: 3x^2 + 6x = 0",
            "99. Solve: x^2 - 11x + 30 = 0",
            "100. Solve: 2x^2 + 7x + 3 = 0"};
    private static final String[] algebraAnswers = {
            "-2, -3",
            "(x-2)*(x-3)",
            "(x-2)^2",
            "x>-2",
            "x<25",
            "1.801, 0.447, -1.248",
            "-14/5",
            "8",
            "ln(38)",
            "468",
            "3, -3",
            "2, -2",
            "-2",
            "3, 4",
            "2, -3",
            "4",
            "5",
            "8",
            "12",
            "0.5, -3",
            "5, -3",
            "-3",
            "5",
            "3, -3",
            "0, -3",
            "2, -0.5",
            "x+3",
            "x-1",
            "x>5",
            "x<=3",
            "16",
            "27",
            "5",
            "4",
            "ln(7)",
            "e^3",
            "8, -2",
            "3, -4",
            "7",
            "10",
            "x=3, y=2",
            "x=3, y=1",
            "x<2 or x>3",
            "-2<x<2",
            "1024",
            "6x^5",
            "x^2",
            "x^2+6x+9",
            "x^2-8x+16",
            "x^2-4",
            "2x^2-5x-3",
            "-3",
            "3",
            "5, -5",
            "3",
            "-2",
            "4",
            "-3",
            "3",
            "1.5",
            "x-2",
            "2, -4",
            "5, -2",
            "2, -2",
            "-2, -3",
            "0",
            "1, -4",
            "1.5, -1",
            "3, 5",
            "5, -7",
            "8",
            "2",
            "8",
            "12",
            "-0.5",
            "2, -2",
            "0, 1",
            "0, -1",
            "2",
            "-3",
            "100",
            "5",
            "3",
            "3",
            "3",
            "9, -9",
            "2",
            "x=2, y=3",
            "x=2, y=3",
            "4, -4",
            "-2, -5",
            "5, -4",
            "x+2",
            "81",
            "125",
            "2, -2",
            "2, -6",
            "0, -2",
            "5, 6",
            "-0.5, -3"};

    private static final String[] trigonometryProblems = {
            "1. If cosec(θ) + cot(θ) = x, find the value of cosec(θ) - cot(θ), using the trigonometry formula.",
            "2. If sin(θ)*cos(θ) = 8, find the value of (sin(θ) + cos(θ))^2 using the trigonometry Formulas.",
            "3. If sin(x) = 0.8, find the value of x in degrees.",
            "4. If sin(2θ) = 0.6 and θ is in the first quadrant, find the value of θ in radians.",
            "5. If sin(α) = 0.5 and cos(β) = 0.8, find sin(α + β).",
            "6. Calculate the value of sin(135°) using trigonometric identities.",
            "7. An electrician is climbing a 40 m long rope, which is tightly stretched and tied from the top of a vertical pole to the ground. Find the height of the pole if the angle made by the rope with the ground level is 60°.",
            "8. What is the value of cos(-15°)?",
            "9. If cos(x) = pi/3, find the value of cos(3x) (in decimal form with two decimal digit precision).",
            "10. Calculate the value of cos(120°).",
            "11. Find sin(30°)",
            "12. Find cos(60°)",
            "13. Find tan(45°)",
            "14. Find sin(90°)",
            "15. Find cos(0°)",
            "16. Find tan(0°)",
            "17. Find sin(60°)",
            "18. Find cos(30°)",
            "19. Find tan(60°). Round to 4 decimal places.",
            "20. Find sin(45°)",
            "21. Find cos(45°)",
            "22. Find sin(0°)",
            "23. Find cos(90°)",
            "24. Find tan(90°)",
            "25. Find sin(180°)",
            "26. Find cos(180°)",
            "27. Find sin(270°)",
            "28. Find cos(270°)",
            "29. Find sin(360°)",
            "30. Find tan(30°). Round to 4 decimal places.",
            "31. Find the value of sin^2(x) + cos^2(x)",
            "32. Find the period of f(x) = sin(2x) in degrees",
            "33. Find the period of f(x) = cos(x/2) in degrees",
            "34. Find the amplitude of f(x) = 3sin(x)",
            "35. Find the amplitude of f(x) = -5cos(x)",
            "36. Convert 180° to radians",
            "37. Convert 90° to radians",
            "38. Convert 60° to radians",
            "39. Convert 45° to radians",
            "40. Convert pi radians to degrees",
            "41. Convert pi/2 radians to degrees",
            "42. Convert pi/6 radians to degrees",
            "43. Convert pi/4 radians to degrees",
            "44. Find sec(60°)",
            "45. Find cosec(30°)",
            "46. Find cot(45°)",
            "47. Find tan(x) if sin(x) = 0.6 and cos(x) = 0.8",
            "48. Find sin(x) if cos(x) = 0.6 and x is in the first quadrant",
            "49. Find cos(x) if sin(x) = 0.5 and x is in the first quadrant",
            "50. Find sin(A+B) if sin(A)=0.6, cos(A)=0.8, sin(B)=0.8, cos(B)=0.6",
            "51. Find cos(2x) if cos(x) = 0.5",
            "52. Find sin(2x) if sin(x) = 0.6 and cos(x) = 0.8",
            "53. Find cos(A-B) if cos(A)=0.8, sin(A)=0.6, cos(B)=0.6, sin(B)=0.8",
            "54. In a right triangle, opposite = 4 cm, adjacent = 3 cm. Find tan of the angle.",
            "55. In a right triangle, opposite = 3 cm, hypotenuse = 5 cm. Find sin of the angle.",
            "56. In a right triangle, adjacent = 4 cm, hypotenuse = 5 cm. Find cos of the angle.",
            "57. Find the angle in degrees if tan(θ) = 1",
            "58. Find the angle in degrees if sin(θ) = 0.5",
            "59. Find the angle in degrees if cos(θ) = 0.5",
            "60. Find the angle in degrees if tan(θ) = sqrt(3). Round to nearest degree.",
            "61. Using the law of sines, if a=8, angle A=30°, angle B=45°, find b. Round to 2 decimal places.",
            "62. Using the law of cosines, find side c if a=5, b=7, C=60°. Round to 2 decimal places.",
            "63. Find the area of a triangle with sides a=5, b=8 and included angle C=30°.",
            "64. Simplify: sin(x)/cos(x)",
            "65. Simplify: 1 - cos^2(x)",
            "66. Simplify: 1 + tan^2(x)",
            "67. Simplify: 1 + cot^2(x)",
            "68. Find sin(pi/6)",
            "69. Find cos(pi/3)",
            "70. Find tan(pi/4)",
            "71. Find sin(pi/2)",
            "72. Find cos(pi)",
            "73. Find tan(pi)",
            "74. Find the range of f(x) = sin(x). Give in interval notation.",
            "75. Find the range of f(x) = cos(x). Give in interval notation.",
            "76. Find sin(-30°)",
            "77. Find cos(-60°)",
            "78. Find tan(-45°)",
            "79. A ladder 10 m long rests against a wall at 60° to the ground. Find the height it reaches. Round to 2 decimal places.",
            "80. From a point 30 m from a building, the angle of elevation of the top is 45°. Find the height.",
            "81. From a point 50 m from a tower, the angle of elevation is 30°. Find the height. Round to 2 decimal places.",
            "82. Find the exact value of sin(15°). Round to 4 decimal places.",
            "83. Find the exact value of cos(75°). Round to 4 decimal places.",
            "84. Find sin(x) + cos(x) if sin(x) = 0.6 and cos(x) = 0.8",
            "85. Find tan(x) if sin(x) = sqrt(3)/2 and cos(x) = 0.5. Round to 4 decimal places.",
            "86. Verify: sin^2(30°) + cos^2(30°) = ?",
            "87. Find the period of f(x) = tan(x) in degrees",
            "88. Find the phase shift of f(x) = sin(x - pi/4) in radians",
            "89. Find the vertical shift of f(x) = cos(x) + 3",
            "90. In triangle ABC, a=7, b=9, c=10. Find angle C using law of cosines. Round to 2 decimal places.",
            "91. Find cosec(45°). Round to 4 decimal places.",
            "92. Find sec(45°). Round to 4 decimal places.",
            "93. Find cot(60°). Round to 4 decimal places.",
            "94. Find sin(105°). Round to 4 decimal places.",
            "95. Express cos(90°-x) in terms of sin",
            "96. Express sin(90°-x) in terms of cos",
            "97. Find tan(x) if cot(x) = 2",
            "98. Find the height of a tree if its shadow is 20 m long at a sun angle of 30°. Round to 2 decimal places.",
            "99. Find sin(x) if tan(x) = 3/4 and x is in the first quadrant",
            "100. Find cos(x) if tan(x) = 3/4 and x is in the first quadrant"};
    private static final String[] trigonometryAnswers = {
            "1/x",
            "17",
            "53.13",
            "0.32175",
            "0.92",
            "0.7071",
            "34.64",
            "0.9659",
            "-0.08",
            "-0.5",
            "0.5",
            "0.5",
            "1",
            "1",
            "1",
            "0",
            "0.8660",
            "0.8660",
            "1.7321",
            "0.7071",
            "0.7071",
            "0",
            "0",
            "undefined",
            "0",
            "-1",
            "-1",
            "0",
            "0",
            "0.5774",
            "1",
            "180°",
            "720°",
            "3",
            "5",
            "pi",
            "pi/2",
            "pi/3",
            "pi/4",
            "180°",
            "90°",
            "30°",
            "45°",
            "2",
            "2",
            "1",
            "0.75",
            "0.8",
            "0.8660",
            "1",
            "-0.5",
            "0.96",
            "0.96",
            "1.3333",
            "0.6",
            "0.8",
            "45°",
            "30°",
            "60°",
            "60°",
            "11.31",
            "6.24",
            "10",
            "tan(x)",
            "sin^2(x)",
            "sec^2(x)",
            "cosec^2(x)",
            "0.5",
            "0.5",
            "1",
            "1",
            "-1",
            "0",
            "[-1,1]",
            "[-1,1]",
            "-0.5",
            "0.5",
            "-1",
            "8.66",
            "30",
            "28.87",
            "0.2588",
            "0.2588",
            "1.4",
            "1.7321",
            "1",
            "180°",
            "pi/4",
            "3",
            "69.51°",
            "1.4142",
            "1.4142",
            "0.5774",
            "0.9659",
            "sin(x)",
            "cos(x)",
            "0.5",
            "11.55",
            "0.6",
            "0.8"};

    private static final String[] calculusProblems = {
            "1. Differentiate the function f(x) = x^3 with respect to x.",
            "2. Differentiate the function f(x) = (x+1)(x+2) with respect to x.",
            "3. Differentiate the function f(x)=(x+1)/(x+2) with respect to x.",
            "4. Differentiate the function f(x) = sin(x^2) with respect to x.",
            "5. Calculate the derivative of f(x) = 3x^3.",
            "6. Find the second-order derivative of f(x) = 4x^4 + 3x^3 + 2x^2 + x + 1",
            "7. Determine the intervals where the function f(x)=x^3-6x^2+9x+15 is concave up and concave down.",
            "8. Determine the intervals where the function g(x)=2x^4-4x^3-24x^2+48x is concave up and concave down.",
            "9. Given y = x/(x^2 + 1). Find the value of the second derivative at x = 1",
            "10. Given y(x) = 3x^3 + 12x + 4. Find the value of third derivative at x = 1",
            "11. Differentiate f(x) = 5x^4",
            "12. Differentiate f(x) = x^2 + 3x + 2",
            "13. Differentiate f(x) = 7x",
            "14. Differentiate f(x) = x^(-1)",
            "15. Differentiate f(x) = sqrt(x)",
            "16. Differentiate f(x) = e^x",
            "17. Differentiate f(x) = ln(x)",
            "18. Differentiate f(x) = sin(x)",
            "19. Differentiate f(x) = cos(x)",
            "20. Differentiate f(x) = tan(x)",
            "21. Differentiate f(x) = e^(3x)",
            "22. Differentiate f(x) = ln(2x)",
            "23. Differentiate f(x) = x^5 - 2x^3 + x",
            "24. Differentiate f(x) = (x^2 + 1)^3",
            "25. Differentiate f(x) = sin(3x)",
            "26. Differentiate f(x) = cos(2x)",
            "27. Differentiate f(x) = x*sin(x)",
            "28. Differentiate f(x) = x*e^x",
            "29. Differentiate f(x) = x/sin(x)",
            "30. Find f'(2) for f(x) = x^3 - 3x",
            "31. Find f'(0) for f(x) = sin(x)",
            "32. Find f'(1) for f(x) = x^2 + 2x",
            "33. Find f'(0) for f(x) = e^x",
            "34. Integrate: x^2 dx",
            "35. Integrate: 3x dx",
            "36. Integrate: e^x dx",
            "37. Integrate: 1/x dx",
            "38. Integrate: cos(x) dx",
            "39. Integrate: sin(x) dx",
            "40. Evaluate the definite integral of x^2 from 0 to 3",
            "41. Evaluate the definite integral of 2x from 1 to 4",
            "42. Evaluate the definite integral of cos(x) from 0 to pi/2",
            "43. Evaluate the definite integral of e^x from 0 to 1. Round to 2 decimal places.",
            "44. Find the local minimum of f(x) = x^2 - 4x + 3",
            "45. Find the x-coordinate of the local minimum of f(x) = x^2 - 6x + 5",
            "46. Find the x-coordinate of the local maximum of f(x) = -x^2 + 4x",
            "47. Find the limit: lim(x->0) sin(x)/x",
            "48. Find the limit: lim(x->inf) 1/x",
            "49. Find the limit: lim(x->2) (x^2 - 4)/(x - 2)",
            "50. Find the limit: lim(x->0) (e^x - 1)/x",
            "51. Find the limit: lim(x->3) x^2 - 9",
            "52. Is f(x) = x^2 continuous at x = 2? (yes/no)",
            "53. Find the inflection point x-coordinate of f(x) = x^3 - 3x^2 + 1",
            "54. Find the second derivative of f(x) = x^4",
            "55. Find the second derivative of f(x) = sin(x)",
            "56. Find the second derivative of f(x) = e^(2x)",
            "57. Differentiate f(x) = x^2 * cos(x)",
            "58. Differentiate f(x) = ln(x^2)",
            "59. Differentiate f(x) = (2x + 1)^4",
            "60. Differentiate f(x) = tan(x^2)",
            "61. Find f''(1) for f(x) = x^4 - 2x^2",
            "62. Evaluate the definite integral of x from 0 to 5",
            "63. Evaluate the definite integral of x^3 from 0 to 2",
            "64. Find the area under f(x) = x from x=0 to x=4",
            "65. Find the area under f(x) = 2 from x=1 to x=5",
            "66. Find f'(x) if f(x) = 4",
            "67. Differentiate f(x) = x^(1/2)",
            "68. Differentiate f(x) = (x^2 + 1)/x",
            "69. Find the critical points of f(x) = x^3 - 3x",
            "70. Find the global minimum of f(x) = x^2 on [-2, 2]",
            "71. Find the global maximum of f(x) = -x^2 + 4 on [-2, 2]",
            "72. Differentiate f(x) = ln(sin(x))",
            "73. Find the limit: lim(x->inf) (2x+1)/x",
            "74. Find the limit: lim(x->0) x^2/x",
            "75. Is f(x) = 1/x continuous at x = 0? (yes/no)",
            "76. Integrate: x^3 dx",
            "77. Integrate: 5 dx",
            "78. Integrate: x^(-2) dx",
            "79. Evaluate the definite integral of sin(x) from 0 to pi",
            "80. Find the derivative of f(x) = arctan(x)",
            "81. Find the derivative of f(x) = arcsin(x)",
            "82. Find the slope of f(x) = x^2 + 3 at x = 4",
            "83. Find f'(x) for f(x) = x^0",
            "84. Differentiate f(x) = 6x^2 - 4x + 2",
            "85. Differentiate f(x) = 10x^5 - 3x^2",
            "86. Find f'(3) for f(x) = 2x^2 - x",
            "87. Find f'(2) for f(x) = x^3",
            "88. Find f''(0) for f(x) = x^3 - x",
            "89. Find f''(0) for f(x) = x^4",
            "90. Integrate: e^(2x) dx",
            "91. Integrate: sin(2x) dx",
            "92. Integrate: cos(3x) dx",
            "93. Evaluate the definite integral of e^x from 0 to ln(2)",
            "94. Find the inflection x-coordinates of f(x) = x^4 - 6x^2",
            "95. Find the limit: lim(x->1) (x^2-1)/(x-1)",
            "96. Differentiate f(x) = (sin(x))^2",
            "97. Differentiate f(x) = e^(x^2)",
            "98. Find f'(pi/2) for f(x) = sin(x)",
            "99. Find the antiderivative of 6x^2",
            "100. Find f'(x) for f(x) = 3x^2 + 2x - 1"};
    private static final String[] calculusAnswers = {
            "3x^2",
            "2x+3",
            "1/(x+2)^2",
            "2xcos(x^2)",
            "9x^2",
            "48x^2+18x+4",
            "(-∞,1)∪(3,∞) ; (1,3)",
            "(-∞,-1)∪(3,∞) ; (-1,3)",
            "0.5",
            "18",
            "20x^3",
            "2x+3",
            "7",
            "-x^(-2)",
            "1/(2*sqrt(x))",
            "e^x",
            "1/x",
            "cos(x)",
            "-sin(x)",
            "1/cos^2(x)",
            "3e^(3x)",
            "1/x",
            "5x^4-6x^2+1",
            "6x(x^2+1)^2",
            "3cos(3x)",
            "-2sin(2x)",
            "sin(x)+xcos(x)",
            "e^x+xe^x",
            "(sin(x)-xcos(x))/sin^2(x)",
            "9",
            "1",
            "4",
            "1",
            "x^3/3+C",
            "3x^2/2+C",
            "e^x+C",
            "ln|x|+C",
            "sin(x)+C",
            "-cos(x)+C",
            "9",
            "15",
            "1",
            "1.72",
            "-1",
            "3",
            "2",
            "1",
            "0",
            "4",
            "1",
            "0",
            "yes",
            "1",
            "12x^2",
            "-sin(x)",
            "4e^(2x)",
            "2xcos(x)-x^2sin(x)",
            "2/x",
            "8(2x+1)^3",
            "2x/cos^2(x^2)",
            "10",
            "12.5",
            "4",
            "8",
            "8",
            "0",
            "1/(2x^(1/2))",
            "1-1/x^2",
            "x=1, x=-1",
            "0",
            "4",
            "cos(x)/sin(x)",
            "2",
            "0",
            "no",
            "x^4/4+C",
            "5x+C",
            "-x^(-1)+C",
            "2",
            "1/(1+x^2)",
            "1/sqrt(1-x^2)",
            "8",
            "0",
            "12x-4",
            "50x^4-6x",
            "11",
            "12",
            "-6",
            "0",
            "e^(2x)/2+C",
            "-cos(2x)/2+C",
            "sin(3x)/3+C",
            "1",
            "1, -1",
            "2",
            "2sin(x)cos(x)",
            "2xe^(x^2)",
            "0",
            "2x^3+C",
            "6x+2"};

    private static final String[] geometryProblems = {
            "1. Two triangles are similar. The sides of the first triangle are 6 cm, 8 cm, and 10 cm. The shortest side of the second triangle is 3 cm. Find the lengths of the other two sides of the second triangle.",
            "2. In a right triangle, one leg is 9 cm and the hypotenuse is 15 cm. Find the length of the other leg.",
            "3. Find the area of a triangle with sides 7 cm, 8 cm, and 9 cm.",
            "4. In a triangle, one angle is 35 degrees and another angle is 65 degrees. Find the measure of the third angle.",
            "5. In a quadrilateral ABCD, the measures of the angles are angle A = 4x, angle B = 3x+10, angle C = 2x, and angle D = x+20. Find the value of x and the measure of each angle.",
            "6. The lengths of the adjacent sides of a parallelogram are 6cm and 7cm. Find its perimeter.",
            "7. Three angles of a quadrilateral are 60°, 85°, 101°. Find out the fourth angle.",
            "8. In parallelogram ABCD, if the diagonals intersect at right angles and the lengths of the diagonals are 12 cm and 16 cm, find the area of the parallelogram.",
            "9. In parallelogram ABCD, if angle A = 3x + 10° and angle C = 2x + 30°, find the value of x.",
            "10. In parallelogram PQRS, if PQ = 5x - 7, QR = 2x + 3, and PQ = QR, find the value of x.",
            "11. Find the area of a circle with radius 7 cm. Use pi = 3.14.",
            "12. Find the circumference of a circle with radius 5 cm. Use pi = 3.14.",
            "13. Find the area of a rectangle with length 12 cm and width 8 cm.",
            "14. Find the perimeter of a rectangle with length 10 cm and width 6 cm.",
            "15. Find the area of a square with side 9 cm.",
            "16. Find the perimeter of a square with side 11 cm.",
            "17. Find the area of a right triangle with legs 6 cm and 8 cm.",
            "18. Find the hypotenuse of a right triangle with legs 5 cm and 12 cm.",
            "19. Find the hypotenuse of a right triangle with legs 8 cm and 15 cm.",
            "20. Find the area of a trapezoid with parallel sides 5 cm, 9 cm and height 4 cm.",
            "21. Find the volume of a cube with side 4 cm.",
            "22. Find the surface area of a cube with side 3 cm.",
            "23. Find the volume of a rectangular box 3 cm x 4 cm x 5 cm.",
            "24. Find the volume of a cylinder with radius 3 cm and height 7 cm. Use pi = 3.14.",
            "25. Find the volume of a sphere with radius 3 cm. Use pi = 3.14.",
            "26. Find the volume of a cone with radius 4 cm and height 9 cm. Use pi = 3.14.",
            "27. Find the surface area of a sphere with radius 5 cm. Use pi = 3.14.",
            "28. Find the diagonal of a square with side 6 cm. Round to 2 decimal places.",
            "29. Find the area of an equilateral triangle with side 6 cm. Round to 2 decimal places.",
            "30. A rectangle has area 48 cm^2 and length 8 cm. Find its width.",
            "31. A rectangle has perimeter 36 cm and length 10 cm. Find its width.",
            "32. Find the radius of a circle with area 78.5 cm^2. Use pi = 3.14.",
            "33. Find the side of a square with perimeter 52 cm.",
            "34. Find the area of a rhombus with diagonals 10 cm and 14 cm.",
            "35. Find the interior angle sum of a hexagon.",
            "36. Find the interior angle sum of a pentagon.",
            "37. Find each interior angle of a regular hexagon.",
            "38. Find each interior angle of a regular pentagon.",
            "39. Find each interior angle of a regular octagon.",
            "40. In a triangle, two angles are 47° and 63°. Find the third.",
            "41. Find the exterior angle of a regular triangle.",
            "42. Find the exterior angle of a regular hexagon.",
            "43. Two parallel lines are cut by a transversal. One co-interior angle is 70°. Find the other.",
            "44. Find the length of an arc with radius 6 cm and central angle 60°. Use pi = 3.14.",
            "45. Find the area of a sector with radius 4 cm and central angle 90°. Use pi = 3.14.",
            "46. A triangle has base 10 cm and height 7 cm. Find its area.",
            "47. Two sides of a right triangle are 7 cm and 24 cm (legs). Find the hypotenuse.",
            "48. Find the perimeter of a triangle with sides 5 cm, 7 cm, 9 cm.",
            "49. Find the missing side: right triangle with hypotenuse 10 cm and one leg 6 cm.",
            "50. Find the missing side: right triangle with hypotenuse 13 cm and one leg 5 cm.",
            "51. A square has diagonal 10 cm. Find its side length. Round to 2 decimal places.",
            "52. Find the area of a parallelogram with base 8 cm and height 5 cm.",
            "53. Find the circumference of a circle with diameter 14 cm. Use pi = 3.14.",
            "54. Find the area of a circle with diameter 12 cm. Use pi = 3.14.",
            "55. A cylinder has radius 5 cm and height 10 cm. Find its lateral surface area. Use pi = 3.14.",
            "56. Find the number of diagonals of a hexagon.",
            "57. Find the number of diagonals of a pentagon.",
            "58. Find the number of diagonals of an octagon.",
            "59. The ratio of two supplementary angles is 2:3. Find the smaller angle.",
            "60. Two complementary angles differ by 14°. Find the smaller angle.",
            "61. Find the area of an isosceles triangle with base 8 cm and equal sides 5 cm.",
            "62. In triangle ABC, AB = 5 cm, BC = 12 cm, angle B = 90°. Find AC.",
            "63. A cone has slant height 10 cm and radius 6 cm. Find its lateral surface area. Use pi = 3.14.",
            "64. A sphere has volume 523.33 cm^3. Find its radius. Use pi = 3.14.",
            "65. Find the perimeter of a semicircle with radius 7 cm. Use pi = 3.14.",
            "66. Find the area of a semicircle with radius 7 cm. Use pi = 3.14.",
            "67. In a right triangle, legs are 3 cm and 4 cm. Find the area.",
            "68. Find the volume of a triangular prism with base area 15 cm^2 and height 8 cm.",
            "69. A rectangle has a diagonal of 13 cm and one side of 5 cm. Find the other side.",
            "70. Find the surface area of a cylinder with radius 3 cm and height 5 cm. Use pi = 3.14.",
            "71. Find each interior angle of a regular decagon.",
            "72. Find the number of sides of a regular polygon whose interior angle is 150°.",
            "73. Find the number of sides of a regular polygon whose exterior angle is 45°.",
            "74. Three sides of a triangle are 3 cm, 4 cm, 5 cm. Is it right-angled? (yes/no)",
            "75. Find the area of a kite with diagonals 6 cm and 10 cm.",
            "76. A chord of a circle is 16 cm and the radius is 10 cm. Find the distance from the center to the chord.",
            "77. Find the angle subtended at the center by an arc of length 6.28 cm in a circle of radius 2 cm.",
            "78. Two angles of a triangle are 55° and 75°. Find the third.",
            "79. Find the volume of a pyramid with base area 36 cm^2 and height 9 cm.",
            "80. Find the area of a regular hexagon with side 6 cm. Round to 2 decimal places.",
            "81. A square and a circle have the same perimeter. The square has side 7 cm. Find the circle's radius. Use pi = 3.14. Round to 2 decimal places.",
            "82. Find the median length from vertex A to side BC in an equilateral triangle with side 8 cm. Round to 2 decimal places.",
            "83. Find the area of a trapezoid with parallel sides 6 cm and 10 cm and height 5 cm.",
            "84. A rectangle's length is twice its width. Its perimeter is 48 cm. Find the length.",
            "85. A rectangle's length is three times its width. Its area is 75 cm^2. Find the width.",
            "86. Find the surface area of a rectangular box 4 cm x 5 cm x 6 cm.",
            "87. Two similar rectangles have lengths 8 cm and 12 cm. The shorter one has width 5 cm. Find the width of the larger.",
            "88. Find the perimeter of a regular pentagon with side 9 cm.",
            "89. Find the perimeter of a regular octagon with side 5 cm.",
            "90. Find the area of a circle with circumference 31.4 cm. Use pi = 3.14.",
            "91. A right triangle has area 30 cm^2 and one leg 6 cm. Find the other leg.",
            "92. Find the angle in a semicircle (angle subtended by diameter at circumference).",
            "93. Find the perimeter of an equilateral triangle with side 13 cm.",
            "94. Find the area of a square with diagonal 8 cm.",
            "95. Find the height of an equilateral triangle with side 10 cm. Round to 2 decimal places.",
            "96. In a triangle, angle A = 2x, angle B = 3x, angle C = x. Find angle C.",
            "97. Find the interior angle sum of a decagon.",
            "98. A right triangle has hypotenuse 26 cm and one leg 10 cm. Find the other leg.",
            "99. Find the area of a rhombus with diagonals 8 cm and 6 cm.",
            "100. Find the perimeter of a rhombus with diagonals 16 cm and 12 cm."};
    private static final String[] geometryAnswers = {
            "4, 5",
            "12",
            "26.83",
            "80",
            "132, 109, 66, 53",
            "26",
            "114°",
            "96",
            "20",
            "10",
            "153.86",
            "31.4",
            "96",
            "32",
            "81",
            "44",
            "24",
            "13",
            "17",
            "28",
            "64",
            "54",
            "60",
            "197.82",
            "113.04",
            "150.72",
            "314",
            "8.49",
            "15.59",
            "6",
            "8",
            "5",
            "13",
            "70",
            "720°",
            "540°",
            "120°",
            "108°",
            "135°",
            "70°",
            "120°",
            "60°",
            "110°",
            "6.28",
            "12.56",
            "35",
            "25",
            "21",
            "8",
            "12",
            "7.07",
            "40",
            "43.96",
            "113.04",
            "314",
            "9",
            "5",
            "20",
            "72°",
            "38°",
            "12",
            "13",
            "188.4",
            "5",
            "35.98",
            "76.93",
            "6",
            "120",
            "12",
            "150.72",
            "144°",
            "12",
            "8",
            "yes",
            "30",
            "6",
            "180°",
            "50°",
            "108",
            "93.53",
            "4.46",
            "6.93",
            "40",
            "16",
            "5",
            "148",
            "7.5",
            "45",
            "40",
            "78.5",
            "10",
            "90°",
            "39",
            "32",
            "8.66",
            "30°",
            "1440°",
            "24",
            "24",
            "40"};
    private static final int[] sectorDegrees = new int[sectors.length];
    private static final Random random = new Random();
    private int degree = 0, degreeAlg = 0, degreeGeo = 0, degreeTrigo = 0, degreeCalc = 0, degreeAnsAlg = 0, degreeAnsGeo = 0, degreeAnsTrigo = 0, degreeAnsCalc = 0;
    private boolean isSpinning = false;
    private ImageView spinningWheel;
    private ImageButton backButton;
    private TextView requirement;
    private EditText answer;
    private ImageButton checkAnswer;
    private Animation zoomInAnimation;

    private BackgroundMusicHelper musicHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_roulette);
        musicHelper = new BackgroundMusicHelper();

        final ImageButton spinButton = findViewById(R.id.SpinTheWheel);
        spinningWheel = findViewById(R.id.imageMathContent);
        backButton = findViewById(R.id.back);
        requirement = findViewById(R.id.selectedProblem);
        answer = findViewById(R.id.answerGiven);
        checkAnswer = findViewById(R.id.checkAnswer);

        getDegreeforSectors();
        spinButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if(!isSpinning){
                    answer.setText("");
                    answer.setTextColor(R.color.black);
                    spin();
                    isSpinning = true;
                }
            }
        });

        zoomInAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButton.startAnimation(zoomInAnimation);
                startActivity(new Intent(RouletteMain.this, Games.class));
            }
        });
    }

    private void spin(){
        degree = random.nextInt(sectors.length-1);
        degreeAlg = random.nextInt(algebraProblems.length-1);
        degreeCalc = random.nextInt(calculusProblems.length-1);
        degreeTrigo = random.nextInt(trigonometryProblems.length-1);
        degreeGeo = random.nextInt(geometryProblems.length-1);
        RotateAnimation rotateAnimation = new RotateAnimation(0, (360 * sectors.length) + sectorDegrees[degree],
                                                             RotateAnimation.RELATIVE_TO_SELF, 0.51f, RotateAnimation.RELATIVE_TO_SELF, 0.51f);
        rotateAnimation.setDuration(2500);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                requirement.setVisibility(GONE);
                checkAnswer.setVisibility(GONE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                checkAnswer.setVisibility(VISIBLE);
                Toast.makeText(RouletteMain.this, "You've chosen " + sectors[sectors.length - (degree + 1)], Toast.LENGTH_SHORT).show();
                isSpinning = false;

                if(sectors[sectors.length - (degree + 1)].equals("Algebra")){
                    SpannableString algebraString = new SpannableString(algebraProblems[degreeAlg]);
                    requirement.setText(algebraString);
                    requirement.setVisibility(VISIBLE);

                    degreeAnsAlg = degreeAlg;
                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String stringAnswer = answer.getText().toString().trim();
                            if(stringAnswer.equals(algebraAnswers[degreeAnsAlg])){
                                answer.setTextColor(Color.GREEN);
                                Toast.makeText(RouletteMain.this, "Correct answer", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                answer.setTextColor(Color.RED);
                                Toast.makeText(RouletteMain.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


                if(sectors[sectors.length - (degree + 1)].equals("Calculus")){
                    SpannableString calculusString = new SpannableString(calculusProblems[degreeCalc]);
                    requirement.setText(calculusString);
                    requirement.setVisibility(VISIBLE);

                    degreeAnsCalc = degreeCalc;
                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String stringAnswer = answer.getText().toString().trim();
                            if(stringAnswer.equals(calculusAnswers[degreeAnsCalc])){
                                answer.setTextColor(Color.GREEN);
                                Toast.makeText(RouletteMain.this, "Correct answer", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                answer.setTextColor(Color.RED);
                                Toast.makeText(RouletteMain.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


                if(sectors[sectors.length - (degree + 1)].equals("Trigonometry")){
                    SpannableString trigonometryString = new SpannableString(trigonometryProblems[degreeTrigo]);
                    requirement.setText(trigonometryString);
                    requirement.setVisibility(VISIBLE);

                    degreeAnsTrigo = degreeTrigo;
                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String stringAnswer = answer.getText().toString().trim();
                            if(stringAnswer.equals(trigonometryAnswers[degreeAnsTrigo])){
                                answer.setTextColor(Color.GREEN);
                                Toast.makeText(RouletteMain.this, "Correct answer", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                answer.setTextColor(Color.RED);
                                Toast.makeText(RouletteMain.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


                if(sectors[sectors.length - (degree + 1)].equals("Geometry")){
                    SpannableString geometryString = new SpannableString(geometryProblems[degreeGeo]);
                    requirement.setText(geometryString);
                    requirement.setVisibility(VISIBLE);

                    degreeAnsGeo = degreeGeo;
                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String stringAnswer = answer.getText().toString().trim();
                            if(stringAnswer.equals(geometryAnswers[degreeAnsGeo])){
                                answer.setTextColor(Color.GREEN);
                                Toast.makeText(RouletteMain.this, "Correct answer", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                answer.setTextColor(Color.RED);
                                Toast.makeText(RouletteMain.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        spinningWheel.startAnimation(rotateAnimation);
    }

    private void getDegreeforSectors(){
        int sectorDegree = 360 / sectors.length;
        for(int i = 0; i < sectors.length; i++){
            sectorDegrees[i] = (i+1) * sectorDegree;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        musicHelper.start(this, R.raw.fileone);
    }

    @Override
    protected void onPause() {
        musicHelper.pause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        musicHelper.stop();
        super.onDestroy();
    }
}
