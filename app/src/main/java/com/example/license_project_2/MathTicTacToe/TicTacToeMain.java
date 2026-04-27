package com.example.license_project_2.MathTicTacToe;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.text.DecimalFormat;

import com.example.license_project_2.Games;
import com.example.license_project_2.R;

public class TicTacToeMain extends AppCompatActivity {
    private TextView selectedOne, selectedTwo, selectedThree, selectedFour, selectedFive,
                        selectedSix, selectedSeven, selectedEight, selectedNine;
    private TextView gridOne, gridTwo, gridThree, gridFour, gridFive, gridSix, gridSeven,
                        gridEight, gridNine;
    private ImageView signOne, signTwo, signThree, signFour, signFive, signSix;
    private TextView columnAnsOne, columnAnsTwo, columnAnsThree, checkAnswer;
    private ImageButton resetValues, quitGame;
    private int[] possibleNumbers = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    };

    private int selectOne = 0, selectTwo = 0, selectThree = 0, selectFour = 0, selectFive = 0, selectSix = 0,
            selectSeven = 0,  selectEight = 0, selectNine = 0, numberGridOne, numberGridTwo, numberGridThree,
            numberGridFour, numberGridFive, numberGridSix, numberGridSeven, numberGridEight, numberGridNine,
            resultOne, resultTwo, resultThree, clickIndex = 0, gridClickIndex = 0;

    private String valueGridOne, valueGridTwo, valueGridThree, valueGridFour, valueGridFive, valueGridSix, valueGridSeven,
                   valueGridEight, valueGridNine;
    private int numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix, numberSeven, numberEight, numberNine;
    private double divResultOne, divResultTwo, divResultThree;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private static final Random random = new Random();
    private Animation bounceAnimationOne, bounceAnimationTwo, bounceAnimationCheck;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.math_tictactoe);

        selectedOne = findViewById(R.id.firstNumber); selectedTwo = findViewById(R.id.secondNumber);
        selectedThree = findViewById(R.id.thirdNumber); selectedFour = findViewById(R.id.fourthNumber);
        selectedFive = findViewById(R.id.fifthNumber); selectedSix = findViewById(R.id.sixthNumber);
        selectedSeven = findViewById(R.id.seventhNumber); selectedEight = findViewById(R.id.eighthNumber);
        selectedNine = findViewById(R.id.ninthNumber);

        selectedOne.setVisibility(View.VISIBLE); selectedTwo.setVisibility(View.VISIBLE);
        selectedThree.setVisibility(View.VISIBLE); selectedFour.setVisibility(View.VISIBLE);
        selectedFive.setVisibility(View.VISIBLE); selectedSix.setVisibility(View.VISIBLE);
        selectedSeven.setVisibility(View.VISIBLE); selectedEight.setVisibility(View.VISIBLE);
        selectedNine.setVisibility(View.VISIBLE);

        gridOne = findViewById(R.id.chosenOne); gridTwo = findViewById(R.id.chosenTwo);
        gridThree = findViewById(R.id.chosenThree); gridFour = findViewById(R.id.chosenFour);
        gridFive = findViewById(R.id.chosenFive); gridSix = findViewById(R.id.chosenSix);
        gridSeven = findViewById(R.id.chosenSeven); gridEight = findViewById(R.id.chosenEight);
        gridNine = findViewById(R.id.chosenNine);

        gridOne.setVisibility(View.VISIBLE); gridTwo.setVisibility(View.VISIBLE); gridThree.setVisibility(View.VISIBLE);
        gridFour.setVisibility(View.VISIBLE); gridFive.setVisibility(View.VISIBLE); gridSix.setVisibility(View.VISIBLE);
        gridSeven.setVisibility(View.VISIBLE); gridEight.setVisibility(View.VISIBLE); gridNine.setVisibility(View.VISIBLE);

        signOne = findViewById(R.id.signOne); signTwo = findViewById(R.id.signTwo); signThree = findViewById(R.id.signThree);
        signFour = findViewById(R.id.signFour); signFive = findViewById(R.id.signFive); signSix = findViewById(R.id.signSix);

        signOne.setVisibility(View.VISIBLE); signTwo.setVisibility(View.VISIBLE); signThree.setVisibility(View.VISIBLE);
        signFour.setVisibility(View.VISIBLE); signFive.setVisibility(View.VISIBLE); signSix.setVisibility(View.VISIBLE);

        columnAnsOne = findViewById(R.id.resultOne); columnAnsTwo = findViewById(R.id.resultTwo);
        columnAnsThree = findViewById(R.id.resultThree); checkAnswer = findViewById(R.id.checking);

        columnAnsOne.setVisibility(View.VISIBLE); columnAnsTwo.setVisibility(View.VISIBLE);
        columnAnsThree.setVisibility(View.VISIBLE); checkAnswer.setVisibility(View.VISIBLE);

        resetValues = findViewById(R.id.resetValues); quitGame = findViewById(R.id.quitGame);
        resetValues.setVisibility(View.VISIBLE); quitGame.setVisibility(View.VISIBLE);

        gridOne.setText("0"); gridTwo.setText("0"); gridThree.setText("0"); gridFour.setText("0"); gridFive.setText("0");
        gridSix.setText("0"); gridSeven.setText("0"); gridEight.setText("0"); gridNine.setText("0");

        valuesFound();
        plusPlus();
        selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
        selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
        selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
        setResultValuesForPlusPlus();

        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer.startAnimation(bounceAnimationCheck);
                checkResultValuesForPlusPlus(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, resultOne);
                checkResultValuesForPlusPlus(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, resultTwo);
                checkResultValuesForPlusPlus(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, resultThree);
            }
        });

        bounceAnimationOne = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceAnimationCheck = AnimationUtils.loadAnimation(this, R.anim.bounce);
        resetValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetValues.startAnimation(bounceAnimationOne);
                clickIndex += 1;
                gridClickIndex = 0;

                gridOne.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridTwo.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridThree.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridFour.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridFive.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridSix.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridSeven.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridEight.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridNine.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));

                gridOne.setText("0"); gridTwo.setText("0"); gridThree.setText("0"); gridFour.setText("0"); gridFive.setText("0");
                gridSix.setText("0"); gridSeven.setText("0"); gridEight.setText("0"); gridNine.setText("0");
                gridOne.setTextColor(Color.parseColor("#ff0000")); gridTwo.setTextColor(Color.parseColor("#ff0000"));
                gridThree.setTextColor(Color.parseColor("#ff0000")); gridFour.setTextColor(Color.parseColor("#ff0000"));
                gridFive.setTextColor(Color.parseColor("#ff0000")); gridSix.setTextColor(Color.parseColor("#ff0000"));
                gridSeven.setTextColor(Color.parseColor("#ff0000")); gridEight.setTextColor(Color.parseColor("#ff0000"));
                gridNine.setTextColor(Color.parseColor("#ff0000"));

                columnAnsOne.setTextColor(Color.parseColor("#000000")); columnAnsTwo.setTextColor(Color.parseColor("#000000"));
                columnAnsThree.setTextColor(Color.parseColor("#000000"));

                if(clickIndex % 16 == 1){
                    valuesFound(); plusPlus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForPlusPlus();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForPlusPlus(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, resultOne);
                            checkResultValuesForPlusPlus(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, resultTwo);
                            checkResultValuesForPlusPlus(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, resultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 2){
                    valuesFound(); minusMinus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForMinusMinus();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForMinusMinus(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, resultOne);
                            checkResultValuesForMinusMinus(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, resultTwo);
                            checkResultValuesForMinusMinus(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, resultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 3){
                    valuesFound(); plusMinus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForPlusMinus();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForPlusMinus(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, resultOne);
                            checkResultValuesForPlusMinus(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, resultTwo);
                            checkResultValuesForPlusMinus(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, resultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 4){
                    valuesFound(); minusPlus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForMinusPlus();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForMinusPlus(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, resultOne);
                            checkResultValuesForMinusPlus(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, resultTwo);
                            checkResultValuesForMinusPlus(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, resultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 5){
                    valuesFound(); productProduct(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForProductProduct();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForProductProduct(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, resultOne);
                            checkResultValuesForProductProduct(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, resultTwo);
                            checkResultValuesForProductProduct(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, resultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 6){
                    valuesFound(); divisionDivision(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForDivisionDivision();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForDivisionDivision(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, divResultOne);
                            checkResultValuesForDivisionDivision(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, divResultTwo);
                            checkResultValuesForDivisionDivision(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, divResultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 11){
                    valuesFound(); productDivision(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForProductDivision();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForProductDivision(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, divResultOne);
                            checkResultValuesForProductDivision(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, divResultTwo);
                            checkResultValuesForProductDivision(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, divResultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 12){
                    valuesFound(); divisionProduct(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForDivisionProduct();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForDivisionProduct(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, divResultOne);
                            checkResultValuesForDivisionProduct(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, divResultTwo);
                            checkResultValuesForDivisionProduct(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, divResultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 7){
                    valuesFound(); plusProduct(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForPlusProduct();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForPlusProduct(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, resultOne);
                            checkResultValuesForPlusProduct(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, resultTwo);
                            checkResultValuesForPlusProduct(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, resultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 8){
                    valuesFound(); productPlus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForProductPlus();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForProductPlus(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, resultOne);
                            checkResultValuesForProductPlus(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, resultTwo);
                            checkResultValuesForProductPlus(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, resultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 9){
                    valuesFound(); minusProduct(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForMinusProduct();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForMinusProduct(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, resultOne);
                            checkResultValuesForMinusProduct(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, resultTwo);
                            checkResultValuesForMinusProduct(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, resultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 10){
                    valuesFound(); productMinus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForProductMinus();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForProductMinus(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, resultOne);
                            checkResultValuesForProductMinus(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, resultTwo);
                            checkResultValuesForProductMinus(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, resultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 13){
                    valuesFound(); divisionPlus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForDivisionPlus();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForDivisionPlus(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, divResultOne);
                            checkResultValuesForDivisionPlus(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, divResultTwo);
                            checkResultValuesForDivisionPlus(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, divResultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 14){
                    valuesFound(); plusDivision(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForPlusDivision();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForPlusDivision(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, divResultOne);
                            checkResultValuesForPlusDivision(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, divResultTwo);
                            checkResultValuesForPlusDivision(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, divResultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 15){
                    valuesFound(); divisionMinus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForDivisionMinus();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForDivisionMinus(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, divResultOne);
                            checkResultValuesForDivisionMinus(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, divResultTwo);
                            checkResultValuesForDivisionMinus(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, divResultThree);
                        }
                    });
                }
                if(clickIndex % 16 == 0){
                    valuesFound(); minusDivision(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForMinusDivision();

                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkAnswer.startAnimation(bounceAnimationCheck);
                            checkResultValuesForMinusDivision(selectOne, selectTwo, selectThree, gridOne, gridTwo, gridThree, columnAnsOne, divResultOne);
                            checkResultValuesForMinusDivision(selectFour, selectFive, selectSix, gridFour, gridFive, gridSix, columnAnsTwo, divResultTwo);
                            checkResultValuesForMinusDivision(selectSeven, selectEight, selectNine, gridSeven, gridEight, gridNine, columnAnsThree, divResultThree);
                        }
                    });
                }
            }
        });

        bounceAnimationTwo = AnimationUtils.loadAnimation(this, R.anim.bounce);
        quitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitGame.startAnimation(bounceAnimationTwo);
                gridClickIndex = 0;
                clickIndex = 0;
                startActivity(new Intent(TicTacToeMain.this, Games.class));
            }
        });


    }

    public void checkEquality(){
        ArrayList<Integer>numbers = new ArrayList<>(Arrays.asList(selectOne, selectTwo, selectThree, selectFour, selectFive, selectSix, selectSeven, selectEight, selectNine));
        Set<Integer> set = new LinkedHashSet<>(numbers);
        numbers.clear();
        numbers.addAll(set);
        int counterNumbers = numbers.size(), newNumber;
        while(counterNumbers < 9){
            newNumber = possibleNumbers[random.nextInt(possibleNumbers.length)];
            if(!(numbers.contains(newNumber))) {
                numbers.add(newNumber);
                counterNumbers++;
            }
        }
        selectOne = numbers.get(0); selectTwo = numbers.get(1); selectThree = numbers.get(2);
        selectFour = numbers.get(3); selectFive = numbers.get(4); selectSix = numbers.get(5);
        selectSeven = numbers.get(6); selectEight = numbers.get(7); selectNine = numbers.get(8);
    }
    public void valuesFound(){
        selectOne = possibleNumbers[random.nextInt(possibleNumbers.length)];
        selectTwo = possibleNumbers[random.nextInt(possibleNumbers.length)];
        selectThree = possibleNumbers[random.nextInt(possibleNumbers.length)];
        selectFour = possibleNumbers[random.nextInt(possibleNumbers.length)];
        selectFive = possibleNumbers[random.nextInt(possibleNumbers.length)];
        selectSix = possibleNumbers[random.nextInt(possibleNumbers.length)];
        selectSeven = possibleNumbers[random.nextInt(possibleNumbers.length)];
        selectEight = possibleNumbers[random.nextInt(possibleNumbers.length)];
        selectNine = possibleNumbers[random.nextInt(possibleNumbers.length)];

        checkEquality();

        selectedOne.setText(String.valueOf(selectOne));
        selectedTwo.setText(String.valueOf(selectTwo));
        selectedThree.setText(String.valueOf(selectThree));
        selectedFour.setText(String.valueOf(selectFour));
        selectedFive.setText(String.valueOf(selectFive));
        selectedSix.setText(String.valueOf(selectSix));
        selectedSeven.setText(String.valueOf(selectSeven));
        selectedEight.setText(String.valueOf(selectEight));
        selectedNine.setText(String.valueOf(selectNine));
    }

    public void plusPlus(){
        signOne.setImageResource(R.drawable.plus); signTwo.setImageResource(R.drawable.plus);
        signThree.setImageResource(R.drawable.plus); signFour.setImageResource(R.drawable.plus);
        signFive.setImageResource(R.drawable.plus); signSix.setImageResource(R.drawable.plus);
    }

    public void minusMinus(){
        signOne.setImageResource(R.drawable.minus); signTwo.setImageResource(R.drawable.minus);
        signThree.setImageResource(R.drawable.minus); signFour.setImageResource(R.drawable.minus);
        signFive.setImageResource(R.drawable.minus); signSix.setImageResource(R.drawable.minus);
    }
    public void plusMinus(){
        signOne.setImageResource(R.drawable.plus); signTwo.setImageResource(R.drawable.minus);
        signThree.setImageResource(R.drawable.plus); signFour.setImageResource(R.drawable.minus);
        signFive.setImageResource(R.drawable.plus); signSix.setImageResource(R.drawable.minus);
    }
    public void minusPlus(){
        signOne.setImageResource(R.drawable.minus); signTwo.setImageResource(R.drawable.plus);
        signThree.setImageResource(R.drawable.minus); signFour.setImageResource(R.drawable.plus);
        signFive.setImageResource(R.drawable.minus); signSix.setImageResource(R.drawable.plus);
    }
    public void productProduct(){
        signOne.setImageResource(R.drawable.product); signTwo.setImageResource(R.drawable.product);
        signThree.setImageResource(R.drawable.product); signFour.setImageResource(R.drawable.product);
        signFive.setImageResource(R.drawable.product); signSix.setImageResource(R.drawable.product);
    }
    public void divisionDivision(){
        signOne.setImageResource(R.drawable.division); signTwo.setImageResource(R.drawable.division);
        signThree.setImageResource(R.drawable.division); signFour.setImageResource(R.drawable.division);
        signFive.setImageResource(R.drawable.division); signSix.setImageResource(R.drawable.division);
    }
    public void productDivision(){
        signOne.setImageResource(R.drawable.product); signTwo.setImageResource(R.drawable.division);
        signThree.setImageResource(R.drawable.product); signFour.setImageResource(R.drawable.division);
        signFive.setImageResource(R.drawable.product); signSix.setImageResource(R.drawable.division);
    }
    public void divisionProduct(){
        signOne.setImageResource(R.drawable.division); signTwo.setImageResource(R.drawable.product);
        signThree.setImageResource(R.drawable.division); signFour.setImageResource(R.drawable.product);
        signFive.setImageResource(R.drawable.division); signSix.setImageResource(R.drawable.product);
    }
    public void plusProduct(){
        signOne.setImageResource(R.drawable.plus); signTwo.setImageResource(R.drawable.product);
        signThree.setImageResource(R.drawable.plus); signFour.setImageResource(R.drawable.product);
        signFive.setImageResource(R.drawable.plus); signSix.setImageResource(R.drawable.product);
    }
    public void productPlus(){
        signOne.setImageResource(R.drawable.product); signTwo.setImageResource(R.drawable.plus);
        signThree.setImageResource(R.drawable.product); signFour.setImageResource(R.drawable.plus);
        signFive.setImageResource(R.drawable.product); signSix.setImageResource(R.drawable.plus);
    }
    public void minusProduct(){
        signOne.setImageResource(R.drawable.minus); signTwo.setImageResource(R.drawable.product);
        signThree.setImageResource(R.drawable.minus); signFour.setImageResource(R.drawable.product);
        signFive.setImageResource(R.drawable.minus); signSix.setImageResource(R.drawable.product);
    }
    public void productMinus(){
        signOne.setImageResource(R.drawable.product); signTwo.setImageResource(R.drawable.minus);
        signThree.setImageResource(R.drawable.product); signFour.setImageResource(R.drawable.minus);
        signFive.setImageResource(R.drawable.product); signSix.setImageResource(R.drawable.minus);
    }
    public void plusDivision(){
        signOne.setImageResource(R.drawable.plus); signTwo.setImageResource(R.drawable.division);
        signThree.setImageResource(R.drawable.plus); signFour.setImageResource(R.drawable.division);
        signFive.setImageResource(R.drawable.plus); signSix.setImageResource(R.drawable.division);
    }
    public void divisionPlus(){
        signOne.setImageResource(R.drawable.division); signTwo.setImageResource(R.drawable.plus);
        signThree.setImageResource(R.drawable.division); signFour.setImageResource(R.drawable.plus);
        signFive.setImageResource(R.drawable.division); signSix.setImageResource(R.drawable.plus);
    }
    public void minusDivision(){
        signOne.setImageResource(R.drawable.minus); signTwo.setImageResource(R.drawable.division);
        signThree.setImageResource(R.drawable.minus); signFour.setImageResource(R.drawable.division);
        signFive.setImageResource(R.drawable.minus); signSix.setImageResource(R.drawable.division);
    }
    public void divisionMinus(){
        signOne.setImageResource(R.drawable.division); signTwo.setImageResource(R.drawable.minus);
        signThree.setImageResource(R.drawable.division); signFour.setImageResource(R.drawable.minus);
        signFive.setImageResource(R.drawable.division); signSix.setImageResource(R.drawable.minus);
    }

    public void checkButtonPressedTwice(TextView selectedSlot, TextView grid){
        if(selectedSlot.getBackground() instanceof ColorDrawable){
            ColorDrawable colorDrawable = (ColorDrawable) selectedSlot.getBackground();
            int colorCode = colorDrawable.getColor(), colorRed = ContextCompat.getColor(selectedSlot.getContext(), R.color.red);
            if(colorCode == colorRed){
                grid.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                grid.setText("0");
                gridClickIndex = gridClickIndex - 1;
            }
        }
    }

    public void gridSelected(TextView gridX, int selectNumber, TextView selectedSlot){
        checkButtonPressedTwice(selectedSlot, gridX);
        gridX.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button, null));
        gridX.setText(String.valueOf(selectNumber));
        selectedSlot.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button_2, null));
        selectedSlot.setTextColor(Color.parseColor("#000000"));
    }
    public void selectNumber(TextView selectedSlot, int selectNumber){
        selectedSlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridClickIndex++;
                if(gridClickIndex == 1)
                    gridSelected(gridOne, selectNumber, selectedSlot);
                if(gridClickIndex == 2)
                    gridSelected(gridTwo, selectNumber, selectedSlot);
                if(gridClickIndex == 3)
                    gridSelected(gridThree, selectNumber, selectedSlot);
                if(gridClickIndex == 4)
                    gridSelected(gridFour, selectNumber, selectedSlot);
                if(gridClickIndex == 5)
                    gridSelected(gridFive, selectNumber, selectedSlot);
                if(gridClickIndex == 6)
                    gridSelected(gridSix, selectNumber, selectedSlot);
                if(gridClickIndex == 7)
                    gridSelected(gridSeven, selectNumber, selectedSlot);
                if(gridClickIndex == 8)
                    gridSelected(gridEight, selectNumber, selectedSlot);
                if(gridClickIndex == 9)
                    gridSelected(gridNine, selectNumber, selectedSlot);
            }
        });
    }

    public void checkEqualityTwo(int[] select){
        ArrayList<Integer>numbers = new ArrayList<>(Arrays.asList(numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix, numberSeven, numberEight, numberNine));
        Set<Integer> set = new LinkedHashSet<>(numbers);
        numbers.clear();
        numbers.addAll(set);
        int counterNumbers = numbers.size(), newNumber;
        while(counterNumbers < 9){
            newNumber = select[random.nextInt(select.length)];
            if(!(numbers.contains(newNumber))) {
                numbers.add(newNumber);
                counterNumbers++;
            }
        }
        numberOne = numbers.get(0); numberTwo = numbers.get(1); numberThree = numbers.get(2);
        numberFour = numbers.get(3); numberFive = numbers.get(4); numberSix = numbers.get(5);
        numberSeven = numbers.get(6); numberEight = numbers.get(7); numberNine = numbers.get(8);
    }

    public void setFactors(){
        int[] selectedNumbers = {selectOne, selectTwo, selectThree, selectFour, selectFive, selectSix, selectSeven, selectEight, selectNine};
        numberOne = selectedNumbers[random.nextInt(selectedNumbers.length)];
        numberTwo = selectedNumbers[random.nextInt(selectedNumbers.length)];
        numberThree = selectedNumbers[random.nextInt(selectedNumbers.length)];
        numberFour = selectedNumbers[random.nextInt(selectedNumbers.length)];
        numberFive = selectedNumbers[random.nextInt(selectedNumbers.length)];
        numberSix = selectedNumbers[random.nextInt(selectedNumbers.length)];
        numberSeven = selectedNumbers[random.nextInt(selectedNumbers.length)];
        numberEight = selectedNumbers[random.nextInt(selectedNumbers.length)];
        numberNine = selectedNumbers[random.nextInt(selectedNumbers.length)];

        checkEqualityTwo(selectedNumbers);
    }

    public void correct(TextView gridx, TextView gridy, TextView gridz, TextView columnAnsx){
        gridx.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button_two, null));
        gridy.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button_two, null));
        gridz.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button_two, null));
        columnAnsx.setTextColor(Color.parseColor("#15ff00"));
    }

    public void wrong(TextView gridx, TextView gridy, TextView gridz, TextView columnAnsx){
        gridx.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button_three, null));
        gridx.setTextColor(Color.parseColor("#ffffff"));
        gridy.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button_three, null));
        gridy.setTextColor(Color.parseColor("#ffffff"));
        gridz.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button_three, null));
        gridz.setTextColor(Color.parseColor("#ffffff"));
        columnAnsx.setTextColor(Color.parseColor("#ff0000"));
    }

    public void setResultValuesForPlusPlus(){
        setFactors();
        resultOne = numberOne + numberTwo + numberThree; resultTwo = numberFour + numberFive + numberSix;
        resultThree = numberSeven + numberEight + numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void checkResultValuesForPlusPlus(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, int resultX){
        if(gridClickIndex == 9 && factorOne + factorTwo + factorThree == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && factorOne + factorTwo + factorThree != resultX) {
            wrong(gridX, gridY, gridZ, columnAnsX);
        }
    }

    public void setResultValuesForMinusMinus(){
        setFactors();
        resultOne = numberOne - numberTwo - numberThree; resultTwo = numberFour - numberFive - numberSix;
        resultThree = numberSeven - numberEight - numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void checkResultValuesForMinusMinus(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, int resultX){
        if(gridClickIndex == 9 && factorOne - factorTwo - factorThree == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && factorOne - factorTwo - factorThree != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForPlusMinus(){
        setFactors();
        resultOne = numberOne + numberTwo - numberThree; resultTwo = numberFour + numberFive - numberSix;
        resultThree = numberSeven + numberEight - numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void checkResultValuesForPlusMinus(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, int resultX){
        if(gridClickIndex == 9 && factorOne + factorTwo - factorThree == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && factorOne + factorTwo - factorThree != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForMinusPlus(){
        setFactors();
        resultOne = numberOne - numberTwo + numberThree; resultTwo = numberFour - numberFive + numberSix;
        resultThree = numberSeven - numberEight + numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void checkResultValuesForMinusPlus(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, int resultX){
        if(gridClickIndex == 9 && factorOne - factorTwo + factorThree == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && factorOne - factorTwo + factorThree != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForProductProduct(){
        setFactors();
        resultOne = numberOne * numberTwo * numberThree; resultTwo = numberFour * numberFive * numberSix;
        resultThree = numberSeven * numberEight * numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void checkResultValuesForProductProduct(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, int resultX){
        if(gridClickIndex == 9 && factorOne * factorTwo * factorThree == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && factorOne * factorTwo * factorThree != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForDivisionDivision(){
        setFactors();
        divResultOne = ((double)numberOne) / ((double)numberTwo) / ((double)numberThree);
        divResultTwo = ((double)numberFour) / ((double)numberFive) / ((double)numberSix);
        divResultThree = ((double)numberSeven) / ((double)numberEight) / ((double)numberNine);
        columnAnsOne.setText(String.valueOf(decimalFormat.format(divResultOne)));
        columnAnsTwo.setText(String.valueOf(decimalFormat.format(divResultTwo)));
        columnAnsThree.setText(String.valueOf(decimalFormat.format(divResultThree)));
    }

    public void checkResultValuesForDivisionDivision(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, double resultX){
        if(gridClickIndex == 9 && ((double)factorOne) / ((double)factorTwo) / ((double)factorThree) == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && ((double)factorOne) / ((double)factorTwo) / ((double)factorThree) != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForProductDivision(){
        setFactors();
        divResultOne = ((double)numberOne) * ((double)numberTwo) / ((double)numberThree);
        divResultTwo = ((double)numberFour) * ((double)numberFive) / ((double)numberSix);
        divResultThree = ((double)numberSeven) * ((double)numberEight) / ((double)numberNine);
        columnAnsOne.setText(String.valueOf(decimalFormat.format(divResultOne)));
        columnAnsTwo.setText(String.valueOf(decimalFormat.format(divResultTwo)));
        columnAnsThree.setText(String.valueOf(decimalFormat.format(divResultThree)));
    }

    public void checkResultValuesForProductDivision(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, double resultX){
        if(gridClickIndex == 9 && ((double)factorOne) * ((double)factorTwo) / ((double)factorThree) == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && ((double)factorOne) * ((double)factorTwo) / ((double)factorThree) != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForDivisionProduct(){
        setFactors();
        divResultOne = ((double)numberOne) / ((double)numberTwo) * ((double)numberThree);
        divResultTwo = ((double)numberFour) / ((double)numberFive) * ((double)numberSix);
        divResultThree = ((double)numberSeven) / ((double)numberEight) * ((double)numberNine);
        columnAnsOne.setText(String.valueOf(decimalFormat.format(divResultOne)));
        columnAnsTwo.setText(String.valueOf(decimalFormat.format(divResultTwo)));
        columnAnsThree.setText(String.valueOf(decimalFormat.format(divResultThree)));
    }

    public void checkResultValuesForDivisionProduct(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, double resultX){
        if(gridClickIndex == 9 && ((double)factorOne) / ((double)factorTwo) * ((double)factorThree) == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && ((double)factorOne) / ((double)factorTwo) * ((double)factorThree) != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForPlusProduct(){
        setFactors();
        resultOne = numberOne + numberTwo * numberThree; resultTwo = numberFour + numberFive * numberSix;
        resultThree = numberSeven + numberEight * numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void checkResultValuesForPlusProduct(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, int resultX){
        if(gridClickIndex == 9 && factorOne + factorTwo * factorThree == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && factorOne + factorTwo * factorThree != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForProductPlus(){
        setFactors();
        resultOne = numberOne * numberTwo + numberThree; resultTwo = numberFour * numberFive + numberSix;
        resultThree = numberSeven * numberEight + numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void checkResultValuesForProductPlus(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, int resultX){
        if(gridClickIndex == 9 && factorOne * factorTwo + factorThree == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && factorOne * factorTwo + factorThree != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForMinusProduct(){
        setFactors();
        resultOne = numberOne - numberTwo * numberThree; resultTwo = numberFour - numberFive * numberSix;
        resultThree = numberSeven - numberEight * numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void checkResultValuesForMinusProduct(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, int resultX){
        if(gridClickIndex == 9 && factorOne - factorTwo * factorThree == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && factorOne - factorTwo * factorThree != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForProductMinus(){
        setFactors();
        resultOne = numberOne * numberTwo - numberThree; resultTwo = numberFour * numberFive - numberSix;
        resultThree = numberSeven * numberEight - numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void checkResultValuesForProductMinus(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, int resultX){
        if(gridClickIndex == 9 && factorOne * factorTwo - factorThree == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && factorOne * factorTwo - factorThree != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForPlusDivision(){
        setFactors();
        divResultOne = ((double)numberOne) + ((double)numberTwo) / ((double)numberThree);
        divResultTwo = ((double)numberFour) + ((double)numberFive) / ((double)numberSix);
        divResultThree = ((double)numberSeven) + ((double)numberEight) / ((double)numberNine);
        columnAnsOne.setText(String.valueOf(decimalFormat.format(divResultOne)));
        columnAnsTwo.setText(String.valueOf(decimalFormat.format(divResultTwo)));
        columnAnsThree.setText(String.valueOf(decimalFormat.format(divResultThree)));
    }

    public void checkResultValuesForPlusDivision(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, double resultX){
        if(gridClickIndex == 9 && ((double)factorOne) + ((double)factorTwo) / ((double)factorThree) == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && ((double)factorOne) + ((double)factorTwo) / ((double)factorThree) != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForDivisionPlus(){
        setFactors();
        divResultOne = ((double)numberOne) / ((double)numberTwo) + ((double)numberThree);
        divResultTwo = ((double)numberFour) / ((double)numberFive) + ((double)numberSix);
        divResultThree = ((double)numberSeven) / ((double)numberEight) + ((double)numberNine);
        columnAnsOne.setText(String.valueOf(decimalFormat.format(divResultOne)));
        columnAnsTwo.setText(String.valueOf(decimalFormat.format(divResultTwo)));
        columnAnsThree.setText(String.valueOf(decimalFormat.format(divResultThree)));
    }

    public void checkResultValuesForDivisionPlus(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, double resultX){
        if(gridClickIndex == 9 && ((double)factorOne) / ((double)factorTwo) + ((double)factorThree) == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && ((double)factorOne) / ((double)factorTwo) + ((double)factorThree) != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForMinusDivision(){
        setFactors();
        divResultOne = ((double)numberOne) - ((double)numberTwo) / ((double)numberThree);
        divResultTwo = ((double)numberFour) - ((double)numberFive) / ((double)numberSix);
        divResultThree = ((double)numberSeven) - ((double)numberEight) / ((double)numberNine);
        columnAnsOne.setText(String.valueOf(decimalFormat.format(divResultOne)));
        columnAnsTwo.setText(String.valueOf(decimalFormat.format(divResultTwo)));
        columnAnsThree.setText(String.valueOf(decimalFormat.format(divResultThree)));
    }

    public void checkResultValuesForMinusDivision(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, double resultX){
        if(gridClickIndex == 9 && ((double)factorOne) - ((double)factorTwo) / ((double)factorThree) == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && ((double)factorOne) - ((double)factorTwo) / ((double)factorThree) != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setResultValuesForDivisionMinus(){
        setFactors();
        divResultOne = ((double)numberOne) / ((double)numberTwo) - ((double)numberThree);
        divResultTwo = ((double)numberFour) / ((double)numberFive) - ((double)numberSix);
        divResultThree = ((double)numberSeven) / ((double)numberEight) - ((double)numberNine);
        columnAnsOne.setText(String.valueOf(decimalFormat.format(divResultOne)));
        columnAnsTwo.setText(String.valueOf(decimalFormat.format(divResultTwo)));
        columnAnsThree.setText(String.valueOf(decimalFormat.format(divResultThree)));
    }

    public void checkResultValuesForDivisionMinus(int factorOne, int factorTwo, int factorThree, TextView gridX, TextView gridY, TextView gridZ, TextView columnAnsX, double resultX){
        if(gridClickIndex == 9 && ((double)factorOne) / ((double)factorTwo) - ((double)factorThree) == resultX)
            correct(gridX, gridY, gridZ, columnAnsX);
        else if (gridClickIndex == 9 && ((double)factorOne) / ((double)factorTwo) - ((double)factorThree) != resultX)
            wrong(gridX, gridY, gridZ, columnAnsX);
    }

    public void setInitialSlotDesign(){
        selectedOne.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedOne.setTextColor(Color.parseColor("#ffffff"));
        selectedTwo.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedTwo.setTextColor(Color.parseColor("#ffffff"));
        selectedThree.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedThree.setTextColor(Color.parseColor("#ffffff"));
        selectedFour.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedFour.setTextColor(Color.parseColor("#ffffff"));
        selectedFive.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedFive.setTextColor(Color.parseColor("#ffffff"));
        selectedSix.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedSix.setTextColor(Color.parseColor("#ffffff"));
        selectedSeven.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedSeven.setTextColor(Color.parseColor("#ffffff"));
        selectedEight.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedEight.setTextColor(Color.parseColor("#ffffff"));
        selectedNine.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedNine.setTextColor(Color.parseColor("#ffffff"));
    }
}