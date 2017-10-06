package com.example.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private EditText nHeightEditText, nWeightEditText; //สร้างตัวแปรของแต่ละอีเว้นท์ขึ้นมา***
    private Button nCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nHeightEditText = (EditText)findViewById(R.id.height_edit_text); //นำตัวแปรที่สร้างขึ้นมาconnectด้วยidของเหตุการณ์นั้นๆ
        nWeightEditText = (EditText)findViewById(R.id.weight_edit_text);
        nCalculateButton = (Button)findViewById(R.id.calculate_button);

        //MyListenner listenner = new MyListenner();
        //nCalculateButton.setOnClickListener(this);


        nCalculateButton.setOnClickListener(new View.OnClickListener(){ //ผูกlistenerกับเหตุการณ์ที่เราต้องการดักจับ
        @Override
        public void onClick(View v){ //ทำการoverideเมธอดของเหตุการณ์onClickหรือclickของปุ่มนี้ จากนั้น ระบุcodeการทำงานต่างๆลงภายในเมธอด
            String heightText = nHeightEditText.getText().toString(); //variableเชื่อมต่อและเก็บค่าความสูงจากobjectที่สร้างไว้ แล้วแปลงไปเป็นstring
            Double height  = Double.valueOf(heightText); //variableเก็บค่าความสูง รวมถึงแปลงไปเป็นdouble
            String weightText = nWeightEditText.getText().toString();
            Double weight = Double.valueOf(weightText);
            Double bmi = weight/((height/100)*(height/100)); //variableเก็บค่าของการคำนวณbmi
            String bmiText = getBmiText(bmi); //variableค่าbmiที่พร้อมใช้ในการแสดงผลหรือข้อความ
            String result = String.format("ค่า BMI ที่ได้ คือ %.2f\n\nอยูในเกณฑ์ : %s",bmi,bmiText); //variableสร้างข้อความการแสดงผล รวมถึงค่าbmiที่เราได้เตรียมไว้แล้ว(เป็นข้อความบนหน้าจอจริงๆ)
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this); //เรียกใช้dialog หรือ กล่องข้อความที่จะpop-upขึ้นมา โดยสร้างobjectขึ้นมาใหม่แล้วconnectกับตัวเอง(MainActivity.this)
            dialog.setTitle("BMI Result"); //สร้างข้อความเพื่อแสดงบนdialog(บนสุดหรือหัวเรื่อง)
            dialog.setMessage(result); //นำค่าหรือresultที่เราสร้างไว้มาแสดงผลขึ้นบนdialog
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() { //สร้างปุ่มบนdialogเพื่อกด"ตกลง"หรือปิดการแสดงผล
                @Override
                public void onClick(DialogInterface dialog, int which) { //overideเมธอดเพื่อสร้างเหตุการณ์clickบนdialogที่ต้องการ(ปุ่มokจะขึ้นอยู่ที่มุมล่างขวา)
                    finish(); //คำสั่งหยุดหรือปิดการแสดงผล เมื่อมีการclick(ตามลักษณะของเมธอดที่เรากำนหนด ในที่นี้คือ onClick หรือ การclick)
                }
            });
                //dialog.show(); //แสดงdialogพร้อมทั้งค่าbmiต่างๆขึ้นบนหน้าจอ

            Intent intent = new Intent(MainActivity.this, BmiResultActivity.class);
            intent.putExtra("bmi_value", bmi);
            intent.putExtra("bmi_text", bmiText);
            startActivity(intent);
                }
            });
        }
    private String getBmiText(Double bmi) {
        String bmiText = "";
        if(bmi < 18.5){
            bmiText = "น้ำหนักน้อยกว่าปกติ";
        }
        else if (bmi < 25){
            bmiText = "น้ำหนักปกติ";
        }
        else if (bmi < 30){
            bmiText = "น้ำหนักมากกว่าปกติ (ท้วม)";
        }
        else{
            bmiText = "น้ำหนักมากกว่าปกติ (อ้วน)";
        }
        return bmiText;
        }
    }

    /*private class MyListenner implements View.OnClickListenner{

        @Override
        public void OnClick(View v){
            Toast t = Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}*/
