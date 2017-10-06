package com.example.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {
    private TextView nShowInfo1;
    private TextView nShowInfo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        nShowInfo1 = (TextView)findViewById(R.id.textView3);
        nShowInfo2 = (TextView)findViewById(R.id.textView4);

            Intent intent = getIntent();
            Double bmi2 = intent.getDoubleExtra("bmi_value", 0);
            String bmiText2 = intent.getStringExtra("bmi_text");
            String result2 = String.format("ค่า BMI ที่ได้ คือ %.2f\n", bmi2);
            String result3 = String.format("อยู่ในเกณฑ์: %s",bmiText2 );
            nShowInfo1.setText(result2);
            nShowInfo2.setText(result3);
    }
}
