/*
    Author: Nadir Kheiralla
    Title: Android Scientific Calculator
    Description: Basic scientific calculator for android using java
 */
package com.brutalsoftwares.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);

        //Hides keyboard while in application
        display.setShowSoftInputOnFocus(false);
    }
    //Method on displaying and reading the text input by user
    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();

        //Variables in order to make edits based on cursor position
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        //properly format based on cursor position and bringing all text together
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    //Methods for each of the buttons to display the proper strings when button clicked
    public void zeroBTNPush(View view) {
        updateText(getResources().getString(R.string.zeroText));
    }
    public void oneBTNPush(View view) {
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoBTNPush(View view) {
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeBTNPush(View view) {
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourBTNPush(View view) {
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveBTNPush(View view) {
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixBTNPush(View view) {
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenBTNPush(View view) {
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightBTNPush(View view) {
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineBTNPush(View view) {
        updateText(getResources().getString(R.string.nineText));
    }
    public void multiplyBTNPush(View view) {
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void divideBTNPush(View view) {
        updateText(getResources().getString(R.string.divideText));
    }
    public void subtractBTNPush(View view) {
        updateText(getResources().getString(R.string.subtractText));
    }
    public void addBTNPush(View view) {
        updateText(getResources().getString(R.string.addText));
    }
    public void parOpenBTNPush(View view) {
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void parCloseBTNPush(View view) {
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }
    public void decimalBTNPush(View view) {
        updateText(getResources().getString(R.string.decimalText));
    }
    public void clearBTNPush(View view) {
        display.setText("");
        previousCalculation.setText("");
    }
    public void backspaceBTNPush(View view) {
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();

        //Checks if the cursor is in the correct position to run the method
        if (cursorPos != 0 && textLength != 0) {
            //Method for manipulating the text for the backspace button
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }
    public void equalsBTNPush(View view) {
        String userExpression = display.getText().toString();
        previousCalculation.setText(userExpression);
        /*
            Converting and evaluating expressions using external library
            Method requires MXparser library in order to run properly
        */
        Expression expression = new Expression(userExpression);
        String result = String.valueOf(expression.calculate());
    }
    public void trigSinBTNPush(View view) {
        updateText("sin(");
    }
    public void trigCosBTNPush(View view) {
        updateText("cos(");
    }
    public void trigTanBTNPush(View view) {
        updateText("tg(");
    }
    public void trigArcSinBTNPush(View view) {
        updateText("arcsin(");
    }
    public void trigArcCosBTNPush(View view) {
        updateText("arccos(");
    }
    public void trigArcTanBTNPush(View view) {
        updateText("arctg(");
    }
    public void logBTNPush(View view) {
        updateText("log(");
    }
    public void naturalLogBTNPush(View view) {
        updateText("ln(");
    }
    public void squareRootBTNPush(View view) {
        updateText("sqrt(");
    }
    public void exponentBTNPush(View view) {
        updateText("e");
    }
    public void piBTNPush(View view) {
        updateText("pi(");
    }
    public void absoluteValueBTNPush(View view) {
        updateText("abs(");
    }
    public void isPrimeBTNPush(View view) {
        updateText("ispr(");
    }
    public void squaredBTNPush(View view) {
        updateText("^(2)");
    }
    public void powerBTNPush(View view) {
        updateText("^(");
    }
}