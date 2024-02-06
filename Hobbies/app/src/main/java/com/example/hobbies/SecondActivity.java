package com.example.hobbies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView display=findViewById(R.id.textView2);
        TextView selectedOptions= findViewById(R.id.textView3);

        Intent intent = getIntent();

        StringBuilder selectedOptionsText = new StringBuilder();

        if (intent.hasExtra("checkbox1")) {
            selectedOptionsText.append(intent.getStringExtra("checkbox1")).append("\n");
        }

        if (intent.hasExtra("checkbox2")) {
            selectedOptionsText.append(intent.getStringExtra("checkbox2")).append("\n");
        }

        if (intent.hasExtra("checkbox3")) {
            selectedOptionsText.append(intent.getStringExtra("checkbox3")).append("\n");
        }

        if (intent.hasExtra("checkbox4")) {
            selectedOptionsText.append(intent.getStringExtra("checkbox4")).append("\n");
        }

        if(intent.hasExtra("text")){
            display.setVisibility(View.INVISIBLE);
           selectedOptionsText.append(intent.getStringExtra("text")).append("\n");
        }

        selectedOptions.setText(selectedOptionsText.toString());
    }
}