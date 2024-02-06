package com.example.gender;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rg=(RadioGroup) findViewById(R.id.radioGroup);
        Button b1=(Button) findViewById(R.id.button);

        b1.setOnClickListener(view -> {
                Intent intent=new Intent(getApplicationContext(), GenderActivity.class);
                int id=rg.getCheckedRadioButtonId();
                RadioButton r1=(RadioButton) findViewById(id);
                if(r1.isChecked())
                intent.putExtra("gender",r1.getText().toString());
                startActivity(intent);
    });
    };
}