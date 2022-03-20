package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ed1, ed2, ed3;
    private Boolean isNewOp1 = true, isNewOp2 = true, isNewOp3 = true;
    private String oldNum = "";
    private String cal = "", oldCal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editText1);
        ed2 = findViewById(R.id.editText2);
        ed3 = findViewById(R.id.editText3);
    }

    public String checkInt(double number) {
        String cutResult = number + "";
        String[] array = cutResult.split("\\.");
        if (array[1].equals("0")) {
            return array[0];
        } else {
            return (number + "");
        }
    }

    public void numberEvent(View view) {
        if (isNewOp3 && isNewOp2 && isNewOp1) {
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
        } else if (isNewOp3) {
            ed3.setText("");
        }
        isNewOp3 = false;
        isNewOp2 = false;
        isNewOp1 = false;
        String number = ed3.getText().toString();
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
        ed3.setText(number);
    }

    public void calculationEvent(View view) {
        String number1 = ed1.getText().toString();
        String number3 = ed3.getText().toString();
        if (number3.length() == 0) {
            System.out.println(1);
        } else if (number1.length() != 0 && oldCal != "") {
            switch (oldCal) {
                case "/":
                    oldNum = (Double.parseDouble(number1) / Double.parseDouble(number3)) + "";
                    break;
                case "*":
                    oldNum = (Double.parseDouble(number1) * Double.parseDouble(number3)) + "";
                    break;
                case "+":
                    oldNum = (Double.parseDouble(number1) + Double.parseDouble(number3)) + "";
                    break;
                case "-":
                    oldNum = (Double.parseDouble(number1) - Double.parseDouble(number3)) + "";
                    break;
            }
        } else {
            oldNum = number3;
        }
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
        oldCal = cal;
        isNewOp3 = true;
        isNewOp2 = false;
        isNewOp1 = false;
        ed1.setText(checkInt(Double.parseDouble(oldNum)));
        ed2.setText(cal);
        ed3.setText("");
    }

    public void equalEvent(View view) {
        String number1 = ed1.getText().toString();
        String number3 = ed3.getText().toString();
        double result = 0.0;
        switch (cal) {
            case "/":
                result = Double.parseDouble(oldNum) / Double.parseDouble(number3);
                break;
            case "*":
                result = Double.parseDouble(oldNum) * Double.parseDouble(number3);
                break;
            case "+":
                result = Double.parseDouble(oldNum) + Double.parseDouble(number3);
                break;
            case "-":
                result = Double.parseDouble(oldNum) - Double.parseDouble(number3);
                break;
        }
        if (number1.length() == 0) {
            result = Double.parseDouble(number3);
        }
        ed3.setText(checkInt(result));
        ed1.setText(number1 + " " + cal + " " + number3);
        ed2.setText("=");
        isNewOp3 = true;
        isNewOp2 = true;
        isNewOp1 = true;
        cal = "";
        oldCal = "";
    }

    public void cleanEvent(View view) {
        ed1.setText("");
        ed2.setText("");
        ed3.setText("0");
        isNewOp3 = true;
    }

    public void delEvent(View view) {
        String number = ed3.getText().toString();
        if (number.length() > 1) {
            number = number.substring(0, number.length() - 1);
            ed3.setText(number);
        } else {
            ed3.setText("0");
            isNewOp3 = true;
        }
    }

    public void percentEvent(View view) {
        Double per = Double.parseDouble(ed3.getText().toString()) / 100;
        ed3.setText(per + "");
        isNewOp3 = true;
    }
}