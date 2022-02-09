package com.nehaanand.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculations;
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculations = findViewById(R.id.PreviousCalculationView);
        display = findViewById(R.id.displayEditText);

        // stopping the default keyboard from popping up
        display.setShowSoftInputOnFocus(false);

    }

    // Whatever string is present in the display, we are storing it in old string.
    // Then we are trying to add on the next clicked digit in such a manner that the
    // old string and the new number added will be side by side with the help of
    // format method.
    // Then this new string is added back to the display to show.
    private void updateText(String stringtoAdd){
        String oldstring = display.getText().toString();
        int cursorPosition = display.getSelectionStart();
        String leftstring = oldstring.substring(0, cursorPosition);
        String rightstring = oldstring.substring(cursorPosition);
        display.setText(String.format("%s%s%s", leftstring, stringtoAdd, rightstring));
        display.setSelection(cursorPosition + stringtoAdd.length());

    }
    public void zerobuttonPush(View view ){
        updateText(getResources().getString(R.string.zeroText));
    }

    public void onebuttonPush(View view ){
        updateText(getResources().getString(R.string.oneText));
    }

    public void twobuttonPush(View view ){
        updateText(getResources().getString(R.string.twoText));
    }

    public void threebuttonPush(View view ){
        updateText(getResources().getString(R.string.threeText));
    }

    public void fourbuttonPush(View view ){
        updateText(getResources().getString(R.string.fourText));
    }

    public void fivebuttonPush(View view ){
        updateText(getResources().getString(R.string.fiveText));
    }

    public void sixbuttonPush(View view ){
        updateText(getResources().getString(R.string.sixText));
    }

    public void sevenbuttonPush(View view ){
        updateText(getResources().getString(R.string.sevenText));
    }

    public void eightbuttonPush(View view ){
        updateText(getResources().getString(R.string.eightText));
    }

    public void ninebuttonPush(View view ){
        updateText(getResources().getString(R.string.nineText));
    }

    public void multiplybuttonPush(View view ){
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void dividebuttonPush(View view ){
        updateText(getResources().getString(R.string.divideText));
    }

    public void subtractbuttonPush(View view ){
        updateText(getResources().getString(R.string.subtractText));
    }

    public void addbuttonPush(View view ){
        updateText(getResources().getString(R.string.addText));
    }

    public void clearbuttonPush(View view ){
        display.setText("");
        previousCalculations.setText("");
    }

    public void parOpenbuttonPush(View view ){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void parClosedbuttonPush(View view ){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    public void decimalbuttonPush(View view ){
        updateText(getResources().getString(R.string.decimalText));
    }

    public void equalsbuttonPush(View view ){
        String userExpression = display.getText().toString();

        previousCalculations.setText(userExpression);
        userExpression = userExpression.replaceAll(getResources().getString(R.string.divideText), "/");
        userExpression = userExpression.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression((userExpression));
        String result = String.valueOf(exp.calculate());

        display.setText(result);

        display.setSelection(result.length());
    }

    public void backspacebuttonPush(View view){
        // to store the current position of cursor
        int cursorposition = display.getSelectionStart();
        int textlength = display.getText().length();

        // to determine whether or not we have some positions to delete.
        // if we are going to remove some characters, we need to make sure that
        // the cursor position isn't at the poition 0 ( which indicates that the the cursor
        // is present at the beginning of the number and the is nothing before it to delete)
        // the other case indicates that if there are no numbers to delete then there is no need to
        // apply backspace
        if(cursorposition != 0 && textlength != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorposition-1, cursorposition, "");
            display.setText(selection);
            display.setSelection(cursorposition-1);
        }
    }

    public void trigSinbuttonPush(View view){
        updateText("sin(");
    }

    public void trigCosbuttonPush(View view){
        updateText("cos(");
    }

    public void trigTanbuttonPush(View view){
        updateText("tan(");
    }

    public void trigSinInversebuttonPush(View view){
        updateText("arcsin(");
    }

    public void trigCosInversebuttonPush(View view){
        updateText("arccos(");
    }

    public void trigTanInversebuttonPush(View view){
        updateText("arctan(");
    }

    public void logbuttonPush(View view){
        updateText("log(");
    }

    public void naturallogbuttonPush(View view){
        updateText("ln(");
    }

    public void underrootbuttonPush(View view){
        updateText("sqrt(");
    }

    public void exponentbuttonPush(View view){
        updateText("e");
    }

    public void pibuttonPush(View view){
        updateText("pi");
    }

    public void absolutebuttonPush(View view){
        updateText("abs(");
    }

    public void primebuttonPush(View view){
        updateText("ispr(");
    }

    public void xsqaurebuttonPush(View view){
        updateText("^(2)");
    }

    public void xpowerybuttonPush(View view){
        updateText("^(");
    }
}