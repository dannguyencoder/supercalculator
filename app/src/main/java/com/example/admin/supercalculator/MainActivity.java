package com.example.admin.supercalculator;

import android.media.Image;
import android.os.IBinder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView result_tv;

    public enum Operation
    {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    String runningNumber = "";
    String leftValueStr = "";
    String rightValueStr = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        result_tv = (TextView) findViewById(R.id.result_tv);
        result_tv.setText("");

        Button one_btn = (Button) findViewById(R.id.one_btn);
        Button two_btn = (Button) findViewById(R.id.two_btn);
        Button three_btn = (Button) findViewById(R.id.three_btn);
        Button four_btn = (Button) findViewById(R.id.four_btn);
        Button five_btn = (Button) findViewById(R.id.five_btn);
        Button six_btn = (Button) findViewById(R.id.six_btn);
        Button seven_btn = (Button) findViewById(R.id.seven_btn);
        Button eight_btn = (Button) findViewById(R.id.eight_btn);
        Button nine_btn = (Button) findViewById(R.id.nine_btn);
        Button zero_btn = (Button) findViewById(R.id.zero_btn);

        ImageButton plus_imgBtn = (ImageButton) findViewById(R.id.plus_imgBtn);
        ImageButton minus_imgBtn = (ImageButton) findViewById(R.id.minus_imgBtn);
        ImageButton multiply_imgBtn = (ImageButton) findViewById(R.id.multiply_imgBtn);
        ImageButton division_imageBtn = (ImageButton) findViewById(R.id.division_imgBtn);

        ImageButton equal_imgBtn = (ImageButton) findViewById(R.id.equal_imgBtn);

        Button clear_btn = (Button) findViewById(R.id.clear_btn);

        one_btn.setOnClickListener(this);
        two_btn.setOnClickListener(this);
        three_btn.setOnClickListener(this);
        four_btn.setOnClickListener(this);
        five_btn.setOnClickListener(this);
        six_btn.setOnClickListener(this);
        seven_btn.setOnClickListener(this);
        eight_btn.setOnClickListener(this);
        nine_btn.setOnClickListener(this);
        zero_btn.setOnClickListener(this);

        plus_imgBtn.setOnClickListener(this);
        minus_imgBtn.setOnClickListener(this);
        multiply_imgBtn.setOnClickListener(this);
        division_imageBtn.setOnClickListener(this);

        equal_imgBtn.setOnClickListener(this);

        clear_btn.setOnClickListener(this);
    }

    void processOperation(Operation operation)
    {
        if (currentOperation != null)
        {
            if (runningNumber != "")
            {
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperation)
                {
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                }

                leftValueStr = String.valueOf(result);
                result_tv.setText(leftValueStr);
            }

        }
        else
        {
            leftValueStr = runningNumber;
            runningNumber = "";

        }

        currentOperation = operation;
    }

    public void numberPressed(int number)
    {
        String numberText = String.valueOf(number);
        runningNumber = runningNumber + numberText;
        result_tv.setText(runningNumber);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.one_btn:
                numberPressed(1);
                break;
            case R.id.two_btn:
                numberPressed(2);
                break;
            case R.id.three_btn:
                numberPressed(3);
                break;
            case R.id.four_btn:
                numberPressed(4);
                break;
            case R.id.five_btn:
                numberPressed(5);
                break;
            case R.id.six_btn:
                numberPressed(6);
                break;
            case R.id.seven_btn:
                numberPressed(7);
                break;
            case R.id.eight_btn:
                numberPressed(8);
                break;
            case R.id.nine_btn:
                numberPressed(9);
                break;
            case R.id.zero_btn:
                numberPressed(0);
                break;
            case R.id.plus_imgBtn:
                processOperation(Operation.ADD);
                break;
            case R.id.minus_imgBtn:
                processOperation(Operation.SUBTRACT);
                break;
            case R.id.multiply_imgBtn:
                processOperation(Operation.MULTIPLY);
                break;
            case R.id.division_imgBtn:
                processOperation(Operation.DIVIDE);
                break;
            case R.id.equal_imgBtn:
                processOperation(Operation.EQUAL);
                break;
            case R.id.clear_btn:
                leftValueStr = "";
                rightValueStr = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                result_tv.setText("0");
        }
    }
}
