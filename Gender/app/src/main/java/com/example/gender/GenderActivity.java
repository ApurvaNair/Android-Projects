package com.example.gender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        TextView display=findViewById(R.id.textView2);
        TextView selectedOptions= findViewById(R.id.textView3);

        Intent intent = getIntent();
        String value = intent.getStringExtra("gender");
        selectedOptions.setText(value);

    }
}