package com.example.license_project_2.MathComplete;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.license_project_2.Games;
import com.example.license_project_2.R;

public class CompleteMain extends AppCompatActivity {
    private TextView problemOne, problemTwo;
    private EditText answerOne, answerTwo;
    private TextView checkOne, checkTwo;
    private Button previous, level, next, quit;
    private static final String[] requirements = {"1. A salesman sold twice as much pears in the afternoon than in the morning.\n If he sold 360 kilograms of pears that day, how many kilograms did he sell in the morning and how many in the afternoon?",
                                                  "2. Mary, Peter, and Lucy were picking chestnuts. Mary picked twice as much chestnuts than Peter. Lucy picked 2 kg more than Peter. Together the three of them picked 26 kg of chestnuts.\n How many kilograms did each of them pick?",
                                                  "3. Sophia finished 2/3 of a book. She calculated that she finished 90 more pages than she has yet to read.\n How long is her book?",
                                                  "4. A farming field can be ploughed by 6 tractors in 4 days. When 6 tractors work together, each of them ploughs 120 hectares a day. If two of the tractors were moved to another field, then the remaining 4 tractors could plough the same field in 5 days.\n How many hectares a day would one tractor plough then?",
                                                  "5. A student chose a number, multiplied it by 2, then subtracted 138 from the result and got 102.\n What was the number he chose?",
                                                  "6. I chose a number and divide it by 5. Then I subtracted 154 from the result and got 6.\n What was the number I chose?",
                                                  "7. The distance between two towns is 380 km. At the same moment, a passenger car and a truck start moving towards each other from different towns. They meet 4 hours later.\n If the car drives 5 km/hr faster than the truck, what are their speeds?",
                                                  "8. One side of a rectangle is 3 cm shorter than the other side. If we increase the length of each side by 1 cm, then the area of the rectangle will increase by 18 cm2. Find the lengths of all sides.",
                                                  "9. The first year, two cows produced 8100 litres of milk. The second year their production increased by 15% and 10% respectively, and the total amount of milk increased to 9100 litres a year.\n How many litres were milked from each cow each year?",
                                                  "10. The distance between stations A and B is 148 km. An express train left station A towards station B with the speed of 80 km/hr. At the same time, a freight train left station B towards station A with the speed of 36 km/hr. They met at station C at 12 pm, and by that time the express train stopped at at intermediate station for 10 min and the freight train stopped for 5 min. Find:" +
                                                          "\n a) The distance between stations C and B." +
                                                          "\n b) The time when the freight train left station B.",
                                                  "11. Susan drives from city A to city B. After two hours of driving she noticed that she covered 80 km and calculated that, if she continued driving at the same speed, she would end up been 15 minutes late. So she increased her speed by 10 km/hr and she arrived at city B 36 minutes earlier than she planned." +
                                                          "\nFind the distance between cities A and B.",
                                                  "12. To deliver an order on time, a company has to make 25 parts a day. After making 25 parts per day for 3 days, the company started to produce 5 more parts per day, and by the last day of work 100 more parts than planned were produced. \n Find how many parts the company made and how many days this took.",
                                                  "13. There are 24 students in a seventh grade class. They decided to plant birches and roses at the school's backyard. While each girl planted 3 roses, every three boys planted 1 birch. By the end of the day they planted 24 plants.\n How many birches and roses were planted?",
                                                  "14. A car left town A towards town B driving at a speed of V = 32 km/hr. After 3 hours on the road the driver stopped for 15 min in town C. Because of a closed road he had to change his route, making the trip 28 km longer. He increased his speed to V = 40 km/hr but still he was 30 min late. Find:\n" +
                                                          "a) The distance the car has covered.\n" +
                                                          "b) The time that took it to get from C to B.\n",
                                                  "15. If a farmer wants to plough a farm field on time, he must plough 120 hectares a day. For technical reasons he ploughed only 85 hectares a day, hence he had to plough 2 more days than he planned and he still has 40 hectares left.\n What is the area of the farm field and how many days the farmer planned to work initially?",
                                                  "16. A woodworker normally makes a certain number of parts in 24 days. But he was able to increase his productivity by 5 parts per day, and so he not only finished the job in only 22 days but also he made 80 extra parts.\n How many parts does the woodworker normally makes per day and how many pieces does he make in 24 days?",
                                                  "17. A biker covered half the distance between two towns in 2 hr 30 min. After that he increased his speed by 2 km/hr. He covered the second half of the distance in 2 hr 20 min.\n Find the distance between the two towns and the initial speed of the biker.",
                                                  "18. A train covered half of the distance between stations A and B at the speed of 48 km/hr, but then it had to stop for 15 min. To make up for the delay, it increased its speed by 5/3 m/sec and it arrived to station B on time.\n Find the distance between the two stations and the speed of the train after the stop.",
                                                  "19. Elizabeth can get a certain job done in 15 days, and Tony can finish only 75% of that job within the same time. Tony worked alone for several days and then Elizabeth joined him, so they finished the rest of the job in 6 days, working together.\n" +
                                                          "For how many days have each of them worked and what percentage of the job have each of them completed?",
                                                  "20. A farmer planned to plough a field by doing 120 hectares a day. After two days of work he increased his daily productivity by 25% and he finished the job two days ahead of schedule." +
                                                          "\n a) What is the area of the field?" +
                                                          "\n b) In how many days did the farmer get the job done?" +
                                                          "\n c) In how many days did the farmer plan to get the job done?",
                                                  "21. To mow a grass field a team of mowers planned to cover 15 hectares a day. After 4 working days they increased the daily productivity by 33×(1/3)%, and finished the work 1 day earlier than it was planned." +
                                                          "\n a) What is the area of the grass field?" +
                                                          "\n b) How many days did it take to mow the whole field?" +
                                                          "\n c) How many days were scheduled initially for this job?",
                                                  "22. A train travels from station A to station B. If the train leaves station A and makes 75 km/hr, it arrives at station B 48 minutes ahead of scheduled. If it made 50 km/hr, then by the scheduled time of arrival it would still have 40 km more to go to station B. Find:" +
                                                          "\n a) The distance between the two stations;" +
                                                          "\n b) The time it takes the train to travel from A to B according to the schedule;" +
                                                          "\n c) The speed of the train when it's on schedule.",
                                                  "23. A bus travels from town A to town B. If the bus's speed is 50 km/hr, it will arrive in town B 42 min later than scheduled. If the bus increases its speed by 50/9 m/sec, it will arrive in town B 30 min earlier than scheduled. Find:" +
                                                          "\n a) The distance between the two towns;" +
                                                          "\n b) The bus's scheduled time of arrival in B;" +
                                                          "\n c) The speed of the bus when it's on schedule.",
                                                  "24. Adding Whole Numbers and Fractions with Like Denominators: At lunchtime, an ice cream parlor served 6 ¼ scoops of chocolate ice cream, 5 ¾ scoops of vanilla and 2 ¾ scoops of strawberry.\n How many scoops of ice cream did the parlor serve in total?",
                                                  "25. Subtracting Whole Numbers and Fractions with Like Denominators: For a party, Jaime had 5 ⅓ bottles of cola for her friends to drink. She drank ⅓ of a bottle herself. Her friends drank 3 ⅓.\n How many bottles of cola does Jaime have left?",
                                                  "26. Adding Fractions with Unlike Denominators: Kevin completed ½ of an assignment at school. When he was home that evening, he completed ⅚ of another assignment.\n How many assignments did Kevin complete?",
                                                  "27. Subtracting Fractions with Unlike Denominators: Packing school lunches for her kids, Patty used ⅞ of a package of ham. She also used ½ of a package of turkey.\n How much more ham than turkey did Patty use?",
                                                  "28. Multiplying Fractions: During gym class on Wednesday, the students ran for ¼ of a kilometre. On Thursday, they ran ½ as many kilometres as on Wednesday.\n How many kilometres did the students run on Thursday? Write your answer as a fraction.",
                                                  "29. Dividing Fractions: A clothing manufacturer uses ⅕ of a bottle of colour dye to make one pair of pants. The manufacturer used ⅘ of a bottle yesterday.\n How many pairs of pants did the manufacturer make?",
                                                  "30. Multiplying Fractions with Whole Numbers: Mark drank ⅚ of a carton of milk this week. Frank drank 7 times more milk than Mark.\n How many cartons of milk did Frank drink? Write your answer as a fraction, or as a whole or mixed number.",
                                                  "31. Dividing Money: Robert spent $184.59 to buy 3 hockey sticks.\n If each hockey stick was the same price, how much did 1 cost?",
                                                  "32. Adding Money with Decimals: You went to the store and bought gum for $1.25 and a sucker for $0.50.\n How much was your total?",
                                                  "33. Subtracting Money with Decimals: You went to the store with $5.50. You bought gum for $1.25, a chocolate bar for $1.15 and a sucker for $0.50.\n How much money do you have left?",
                                                  "34. Applying Proportional Relationships to Money: Jakob wants to invite 20 friends to his birthday, which will cost his parents $250.\n If he decides to invite 15 friends instead, how much money will it cost his parents? Assume the relationship is directly proportional.",
                                                  "35. Applying Percentages to Money: Retta put $100.00 in a bank account that gains 20% interest annually. How much interest will be accumulated in 1 year? And if she makes no withdrawals, how much money will be in the account after 1 year?",
                                                  "36. Finding a Missing Number: The ratio of Jenny’s trophies to Meredith’s trophies is 7:4. Jenny has 28 trophies.\n How many does Meredith have?",
                                                  "37. Finding Missing Numbers: The ratio of Jenny’s trophies to Meredith’s trophies is 7:4. The difference between the numbers is 12.\n What are the numbers?",
                                                  "38. Comparing Ratios: The school’s junior band has 10 saxophone players and 20 trumpet players. The school’s senior band has 18 saxophone players and 29 trumpet players.\n Which band has the higher ratio of trumpet to saxophone players?",
                                                  "39. Determining Percentages: Mary surveyed students in her school to find out what their favourite sports were. Out of 1,200 students, 455 said hockey was their favourite sport.\n What percentage of students said hockey was their favourite sport?",
                                                  "40. Determining Percent of Change:A decade ago, Oakville’s population was 67,624 people. Now, it is 190% larger.\n What is Oakville’s current population?",
                                                  "41. Determining Percents of Numbers: At the ice skate rental stand, 60% of 120 skates are for boys.\n If the rest of the skates are for girls, how many are there?",
                                                  "42. Calculating Averages: For 4 weeks, William volunteered as a helper for swimming classes. The first week, he volunteered for 8 hours. He volunteered for 12 hours in the second week, and another 12 hours in the third week. The fourth week, he volunteered for 9 hours.\n For how many hours did he volunteer per week, on average?",
                                                  "43. Understanding the Premise of Probability: John wants to know his class’s favourite TV show, so he surveys all of the boys.\n Will the sample be representative or biased?",
                                                  "44. Understanding Tangible Probability: The faces on a fair number die are labelled 1, 2, 3, 4, 5 and 6. You roll the die 12 times.\n How many times should you expect to roll a 1?",
                                                  "45. Exploring Complementary Events: The numbers 1 to 50 are in a hat. If the probability of drawing an even number is 25/50, what is the probability of NOT drawing an even number? Express this probability as a fraction.",
                                                  "46. Exploring Experimental Probability: A pizza shop has recently sold 15 pizzas. 5 of those pizzas were pepperoni.\n Answering with a fraction, what is the experimental probability that he next pizza will be pepperoni?",
                                                  "47. Introducing Data Relationships: Maurita and Felice each take 4 tests. Here are the results of Maurita’s 4 tests: 4, 4, 4, 4. Here are the results for 3 of Felice’s 4 tests: 3, 3, 3.\n If Maurita’s mean for the 4 tests is 1 point higher than Felice’s, what’s the score of Felice’s 4th test?",
                                                  "48. Introducing Proportional Relationships: Store A is selling 7 pounds of bananas for $7.00. Store B is selling 3 pounds of bananas for $6.00.\n Which store has the better deal?",
                                                  "49. Writing Equations for Proportional Relationships: Lionel loves soccer, but has trouble motivating himself to practice. So, he incentivizes himself through video games. There is a proportional relationship between the amount of drills Lionel completes, in x, and for how many hours he plays video games, in y. When Lionel completes 10 drills, he plays video games for 30 minutes. Write the equation for the relationship between x and y.",
                                                  "50. Introducing Perimeter: The theatre has 4 chairs in a row. There are 5 rows.\n Using rows as your unit of measurement, what is the perimeter?",
                                                  "51. Introducing Area: The theatre has 4 chairs in a row. There are 5 rows.\n How many chairs are there in total?",
                                                  "52. Introducing Volume: Aaron wants to know how much candy his container can hold. The container is 20 centimetres tall, 10 centimetres long and 10 centimetres wide.\n What is the container’s volume?",
                                                  "53. Understanding 2D Shapes: Kevin draws a shape with 4 equal sides. What shape did he draw?",
                                                  "54. Finding the Perimeter of 2D Shapes: Mitchell wrote his homework questions on a piece of square paper. Each side of the paper is 8 centimetres.\n What is the perimeter?",
                                                  "55. Determining the Area of 2D Shapes: A single trading card is 9 centimetres long by 6 centimetres wide.\n What is its area?",
                                                  "56. Understanding 3D Shapes: Martha draws a shape that has 6 square faces. What shape did she draw?\n",
                                                  "57. Determining the Surface Area of 3D Shapes: What is the surface area of a cube that has a width of 2cm, height of 2 cm and length of 2 cm?\n",
                                                  "58. Determining the Volume of 3D Shapes: Aaron’s candy container is 20 centimetres tall, 10 centimetres long and 10 centimetres wide. Bruce’s container is 25 centimetres tall, 9 centimetres long and 9 centimetres wide. Find the volume of each container.\n Based on volume, whose container can hold more candy?",
                                                  "59. Identifying Right-Angled Triangles: A triangle has the following side lengths: 3 cm, 4 cm and 5 cm. Is this triangle a right-angled triangle?\n",
                                                  "60. Identifying Equilateral Triangles: A triangle has the following side lengths: 4 cm, 4 cm and 4 cm. What kind of triangle is it?",
                                                  "61. Identifying Isosceles Triangles: A triangle has the following side lengths: 4 cm, 5 cm and 5 cm. What kind of triangle is it?",
                                                  "62. Identifying Scalene Triangles: A triangle has the following side lengths: 4 cm, 5 cm and 6 cm. What kind of triangle is it?\n",
                                                  "63. Finding the Perimeter of Triangles: Luigi built a tent in the shape of an equilateral triangle. The perimeter is 21 metres.\n What is the length of each of the tent’s sides?",
                                                  "64. Determining the Area of Triangles: What is the area of a triangle with a base of 2 units and a height of 3 units?",
                                                  "65. Applying Pythagorean Theorem: A right triangle has one non-hypotenuse side length of 3 inches and the hypotenuse measures 5 inches.\n What is the length of the other non-hypotenuse side?",
                                                  "66. Finding a Circle’s Diameter: Jasmin bought a new round backpack. Its area is 370 square centimetres. What is the round backpack’s diameter?",
                                                  "67. Finding a Circle's Area: Captain America’s circular shield has a diameter of 76.2 centimetres. What is the area of his shield?",
                                                  "68. Finding a Circle’s Radius: Skylar lives on a farm, where his dad keeps a circular corn maze. The corn maze has a diameter of 2 kilometres. What is the maze’s radius?",
                                                  "69. Identifying Independent and Dependent Variables: Victoria is baking muffins for her class. The number of muffins she makes is based on how many classmates she has. For this equation, m is the number of muffins and c is the number of classmates.\n Which variable is independent and which variable is dependent?",
                                                  "70. Writing Variable Expressions for Addition: Last soccer season, Trish scored g goals. Alexa scored 4 more goals than Trish. Write an expression that shows how many goals Alexa scored.",
                                                  "71. Writing Variable Expressions for Subtraction: Elizabeth eats a healthy, balanced breakfast b times a week. Madison sometimes skips breakfast. In total, Madison eats 3 fewer breakfasts a week than Elizabeth. Write an expression that shows how many times a week Madison eats breakfast.",
                                                  "72. Writing Variable Expressions for Multiplication: Last hockey season, Jack scored g goals. Patrik scored twice as many goals than Jack. Write an expression that shows how many goals Patrik scored.",
                                                  "73. Writing Variable Expressions for Division: Amanda has c chocolate bars. She wants to distribute the chocolate bars evenly among 3 friends. Write an expression that shows how many chocolate bars 1 of her friends will receive.",
                                                  "74. Solving Two-Variable Equations: This equation shows how the amount Lucas earns from his after-school job depends on how many hours he works:e = 12h. The variable h represents how many hours he works. The variable e represents how much money he earns.\n How much money will Lucas earn after working for 6 hours?"};
    private int wordProblemIndexOne = 0, wordProblemIndexTwo = 1, sectionIndex = 0, buttonIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_complete);
        SpannableString problemStringOne = new SpannableString(requirements[wordProblemIndexOne]);
        SpannableString problemStringTwo = new SpannableString(requirements[wordProblemIndexTwo]);

        problemOne = findViewById(R.id.selectedProblem);
        problemTwo = findViewById(R.id.selectedProblemTwo);
        answerOne = findViewById(R.id.answerGiven);
        answerTwo = findViewById(R.id.answerGivenTwo);
        checkOne = findViewById(R.id.checkAnswer);
        checkTwo = findViewById(R.id.checkAnswerTwo);
        previous = findViewById(R.id.previous);
        level = findViewById(R.id.current);
        next = findViewById(R.id.next);
        quit = findViewById(R.id.quitButton);

        problemOne.setText(problemStringOne);
        problemTwo.setText(problemStringTwo);

        if(sectionIndex == 0) {
            problemOne.setVisibility(View.VISIBLE);
            problemTwo.setVisibility(View.VISIBLE);
            answerOne.setVisibility(View.VISIBLE);
            answerTwo.setVisibility(View.VISIBLE);
            checkOne.setVisibility(View.VISIBLE);
            checkTwo.setVisibility(View.VISIBLE);
            previous.setVisibility(View.VISIBLE);
            level.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
            quit.setVisibility(View.VISIBLE);
        }

        level.setText(String.valueOf(buttonIndex));

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonIndex >= 1 && buttonIndex <=37) {
                    level.setText(String.valueOf(buttonIndex + 1));
                    SpannableString newProblemStringOne = new SpannableString(requirements[wordProblemIndexOne - 1]);
                    SpannableString newProblemStringTwo = new SpannableString(requirements[wordProblemIndexTwo - 1]);
                    problemOne.setText(newProblemStringOne);
                    problemTwo.setText(newProblemStringTwo);

                    problemOne.setVisibility(View.VISIBLE);
                    problemTwo.setVisibility(View.VISIBLE);
                    answerOne.setVisibility(View.VISIBLE);
                    answerTwo.setVisibility(View.VISIBLE);
                    checkOne.setVisibility(View.VISIBLE);
                    checkTwo.setVisibility(View.VISIBLE);
                    previous.setVisibility(View.VISIBLE);
                    level.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                    quit.setVisibility(View.VISIBLE);
                }
                else if(buttonIndex < 1) {
                    buttonIndex = buttonIndex - 1;
                    level.setText(String.valueOf(buttonIndex));
                    SpannableString newProblemStringOne = new SpannableString(requirements[0]);
                    SpannableString newProblemStringTwo = new SpannableString(requirements[1]);
                    problemOne.setText(newProblemStringOne);
                    problemTwo.setText(newProblemStringTwo);

                    problemOne.setVisibility(View.VISIBLE);
                    problemTwo.setVisibility(View.VISIBLE);
                    answerOne.setVisibility(View.VISIBLE);
                    answerTwo.setVisibility(View.VISIBLE);
                    checkOne.setVisibility(View.VISIBLE);
                    checkTwo.setVisibility(View.VISIBLE);
                    previous.setVisibility(View.VISIBLE);
                    level.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                    quit.setVisibility(View.VISIBLE);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonIndex >= 1 && buttonIndex <=37) {
                    level.setText(buttonIndex + 1);
                    SpannableString newProblemStringOne = new SpannableString(requirements[wordProblemIndexOne + 1]);
                    SpannableString newProblemStringTwo = new SpannableString(requirements[wordProblemIndexTwo + 1]);
                    problemOne.setText(newProblemStringOne);
                    problemTwo.setText(newProblemStringTwo);

                    problemOne.setVisibility(View.VISIBLE);
                    problemTwo.setVisibility(View.VISIBLE);
                    answerOne.setVisibility(View.VISIBLE);
                    answerTwo.setVisibility(View.VISIBLE);
                    checkOne.setVisibility(View.VISIBLE);
                    checkTwo.setVisibility(View.VISIBLE);
                    previous.setVisibility(View.VISIBLE);
                    level.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                    quit.setVisibility(View.VISIBLE);
                }
                else if(buttonIndex > 37) {
                    buttonIndex = buttonIndex - 1;
                    SpannableString newProblemStringOne = new SpannableString(requirements[73]);
                    SpannableString newProblemStringTwo = new SpannableString(requirements[74]);
                    problemOne.setText(newProblemStringOne);
                    problemTwo.setText(newProblemStringTwo);

                    problemOne.setVisibility(View.VISIBLE);
                    problemTwo.setVisibility(View.VISIBLE);
                    answerOne.setVisibility(View.VISIBLE);
                    answerTwo.setVisibility(View.VISIBLE);
                    checkOne.setVisibility(View.VISIBLE);
                    checkTwo.setVisibility(View.VISIBLE);
                    previous.setVisibility(View.VISIBLE);
                    level.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                    quit.setVisibility(View.VISIBLE);
                }
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompleteMain.this, Games.class));
            }
        });
    }
}
