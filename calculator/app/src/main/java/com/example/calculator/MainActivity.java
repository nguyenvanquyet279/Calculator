package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ed1;
    private Boolean isNewOp = true;
    private String oldNum = "";
    private String cal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if (isNewOp) {
            ed1.setText("");
        }
        isNewOp = false;
        String number = ed1.getText().toString();
        switch (view.getId()) {
            case R.id.but1:
                number += "1";
                break;
            case R.id.but2:
                number += "2";
                break;
            case R.id.but3:
                number += "3";
                break;
            case R.id.but4:
                number += "4";
                break;
            case R.id.but5:
                number += "5";
                break;
            case R.id.but6:
                number += "6";
                break;
            case R.id.but7:
                number += "7";
                break;
            case R.id.but8:
                number += "8";
                break;
            case R.id.but9:
                number += "9";
                break;
            case R.id.but0:
                number += "0";
                break;
            case R.id.butDot:
                number += ".";
                break;
        }
        ed1.setText(number);
    }

    public void calculationEvent(View view) {
        isNewOp = true;
        oldNum = ed1.getText().toString();
        switch (view.getId()) {
            case R.id.butDivide:
                cal = "/";
                break;
            case R.id.butMulti:
                cal = "*";
                break;
            case R.id.butAdd:
                cal = "+";
                break;
            case R.id.butSub:
                cal = "-";
                break;
        }
    }

    public void equalEvent(View view) {
        String number = ed1.getText().toString();
        double result = 0.0;
        switch (cal) {
            case "/":
                result = Double.parseDouble(oldNum) / Double.parseDouble(number);
                break;
            case "*":
                result = Double.parseDouble(oldNum) * Double.parseDouble(number);
                break;
            case "+":
                result = Double.parseDouble(oldNum) + Double.parseDouble(number);
                break;
            case "-":
                result = Double.parseDouble(oldNum) - Double.parseDouble(number);
                break;
        }
        ed1.setText(result + "");
    }

    public void cleanEvent(View view) {
        ed1.setText("0");
        isNewOp = true;
    }

    public void delEvent(View view) {
        String number = ed1.getText().toString();
        System.out.println(number + " " + number.length());
        if (number.length() > 1) {
            number = number.substring(0, number.length() - 1);
            ed1.setText(number);
        } else {
            ed1.setText("0");
            isNewOp = true;
        }
    }

    public void percentEvent(View view) {
        Double per = Double.parseDouble(ed1.getText().toString()) / 100;
        ed1.setText(per + "");
        isNewOp = true;
    }
}