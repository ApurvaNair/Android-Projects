package com.example.background;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btn;
    LinearLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        l1=findViewById(R.id.layoutView);

        btn.setOnClickListener(view ->{
            int randomColor= Color.rgb((int) (Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
            l1.setBackgroundColor(randomColor);
        });


    }
}