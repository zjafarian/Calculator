package com.example.calculator.contorller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.R;
import com.example.calculator.model.Calculator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class CalculatorActivity extends AppCompatActivity {
    public static final String INPUT_SAVE = "input_save";
    public static final String RESULT_SAVE = "result_save";
    public static final String CALCULATOR_SAVE = "calculator_save";
    private MaterialTextView mTextInput;
    private TextView mResultText;
    private Button mButtonDelete;
    private Button mButtonDecimal;
    private Button mButtonDivision;
    private Button mButtonEqual;
    private Button mButtonMulti;
    private Button mButtonSum;
    private Button mButtonSub;
    private Button mButtonZero;
    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;
    private Button mButtonFour;
    private Button mButtonFive;
    private Button mButtonSix;
    private Button mButtonSeven;
    private Button mButtonEight;
    private Button mButtonNine;
    private String result;
    private String input = "";
    private String memory = "";
    Calculator calculator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setId();
        if (savedInstanceState != null) {
            input = savedInstanceState.getString(INPUT_SAVE);
            result = savedInstanceState.getString(RESULT_SAVE);
            calculator = (Calculator) savedInstanceState.getSerializable(CALCULATOR_SAVE);
            mTextInput.setText(input);
            mResultText.setText(result);
        }
        listener();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INPUT_SAVE, input);
        outState.putString(RESULT_SAVE, result);
        outState.putSerializable(CALCULATOR_SAVE, calculator);
    }

    private void resultCal() {
        if (!input.isEmpty()) {
            calculator = new Calculator(input);
            result = calculator.getResultCalculator();
            mResultText.setText(result);
            mTextInput.setText(result);
            input = result;
        } else {
            Toast toast = Toast.makeText(CalculatorActivity.this, R.string.empty,
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
        }


    }

    private void setId() {
        mTextInput = findViewById(R.id.txt_operation);
        mResultText = findViewById(R.id.text_result);
        mButtonDelete = findViewById(R.id.btn_delete);
        mButtonDivision = findViewById(R.id.btn_division);
        mButtonMulti = findViewById(R.id.btn_multi);
        mButtonSub = findViewById(R.id.btn_subtraction);
        mButtonSum = findViewById(R.id.btn_sum);
        mButtonEqual = findViewById(R.id.btn_equal);
        mButtonDecimal = findViewById(R.id.btn_decimal);
        mButtonZero = findViewById(R.id.btn_zero);
        mButtonOne = findViewById(R.id.btn_one);
        mButtonTwo = findViewById(R.id.btn_two);
        mButtonThree = findViewById(R.id.btn_three);
        mButtonFour = findViewById(R.id.btn_four);
        mButtonFive = findViewById(R.id.btn_five);
        mButtonSix = findViewById(R.id.btn_six);
        mButtonSeven = findViewById(R.id.btn_seven);
        mButtonEight = findViewById(R.id.btn_eight);
        mButtonNine = findViewById(R.id.btn_nine);
        mTextInput.setTextColor(Color.WHITE);
        mTextInput.setTextSize(24);
        mResultText.setTextColor(Color.WHITE);
        mResultText.setTextSize(24);
    }

    private void listener() {
        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = mTextInput.getText().toString();
                String newInput = "";
                for (int i = 0; i < input.length() - 1; i++) {
                    newInput += input.charAt(i);
                }
                input = newInput;
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_delete,
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            }
        });

        mButtonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.isEmpty() && !result.isEmpty())
                    input += result;

                input += "/";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_division,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });

        mButtonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.isEmpty() && !result.isEmpty())
                    input += result;
                input += "*";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_multi,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();


            }
        });

        mButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.isEmpty() && !result.isEmpty())
                    input += result;
                input += "-";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_subtraction,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            }
        });

        mButtonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.isEmpty() && !result.isEmpty())
                    input += result;
                input += "+";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_sum,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            }
        });

        mButtonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal();
            }
        });

        mButtonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += ".";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_decimal,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });

        mButtonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "0";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_zero,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });

        mButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "1";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_one,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });

        mButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "2";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_two,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });

        mButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "3";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_three,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });

        mButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "4";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_four,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });

        mButtonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "5";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_five,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });

        mButtonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "6";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_six,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });

        mButtonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "7";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_seven,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });

        mButtonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "8";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text_eight,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });

        mButtonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "9";
                mTextInput.setText(input);
                Toast toast = Toast.makeText(CalculatorActivity.this, R.string.text__nine,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }
        });
    }
}