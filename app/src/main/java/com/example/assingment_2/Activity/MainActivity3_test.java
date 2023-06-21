package com.example.assingment_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3_test extends AppCompatActivity {

    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

         tv1 = findViewById(R.id.textBackground1);
         tv2=findViewById(R.id.textBackground2);

        Intent intent= getIntent();
        String name=intent.getExtras().getString("subjectName"+" Exam: ");
        String test=intent.getExtras().getString("testText");

        tv1.setText(name);
        tv2.setText(test);

    }
}
