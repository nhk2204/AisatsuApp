package com.example.nhk2204.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView1);
        showTimePickerDialog();

        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(hour>=2&&hour<10) {
                    textView.setText("おはよう");
                }else if(hour>=10&&hour<18){
                    textView.setText("こんにちわ");
                }else{
                    textView.setText("こんばんわ");
                }
            }
        });

        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
    }

    protected void showTimePickerDialog(){
        TimePickerDialog timePickerDialog=new TimePickerDialog(this,
            new TimePickerDialog.OnTimeSetListener(){
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hour=hourOfDay;
                }
            },
            13,
            0,
            true
        );
        timePickerDialog.show();
    }
}
