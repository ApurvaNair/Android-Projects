package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView res;
        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btn;

        res=findViewById(R.id.textView);
        edtWeight=findViewById(R.id.editText1);
        edtHeightFt=findViewById(R.id.editText2);
        edtHeightIn=findViewById(R.id.editText3);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt=Integer.parseInt(edtWeight.getText().toString());
                int ft=Integer.parseInt(edtHeightFt.getText().toString());
                int in=Integer.parseInt(edtHeightIn.getText().toString());

                int totIn=ft*12+in;
                double totCm=totIn*2.53;
                double totM=totCm/100;
                double bmi=wt/(totM*totM);

                if(bmi>25)
                    res.setText("You are overweight");
                else if (bmi<18)
                    res.setText("You are underweight");
                else
                    res.setText("You are healthy!!");
            }
        });
    }
}