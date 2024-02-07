package com.example.prac4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e1=findViewById(R.id.editTextNumber);
        EditText e2=findViewById(R.id.editTextNumber2);
        Button btnadd=findViewById(R.id.button);
        Button btnsub=findViewById(R.id.button4);
        Button btnmul=findViewById(R.id.button2);
        Button btndiv=findViewById(R.id.button3);
        Button btnclr=findViewById(R.id.button5);
        TextView txtres=findViewById(R.id.textView);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((e1.getText().length()>0) && (e2.getText().length()>0)){
                    double opr1 = Double.parseDouble(e1.getText().toString());
                    double opr2 = Double.parseDouble(e2.getText().toString());
                    double result = opr1 + opr2;
                    txtres.setText(Double.toString(result));
                }
                else {
                    Toast toast= Toast.makeText(MainActivity.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((e1.getText().length()>0) && (e2.getText().length()>0)){
                    double opr1 = Double.parseDouble(e1.getText().toString());
                    double opr2 = Double.parseDouble(e2.getText().toString());
                    double result = opr1 - opr2;
                    txtres.setText(Double.toString(result));
                }
                else {
                    Toast toast= Toast.makeText(MainActivity.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((e1.getText().length()>0) && (e2.getText().length()>0)){
                    double opr1 = Double.parseDouble(e1.getText().toString());
                    double opr2 = Double.parseDouble(e2.getText().toString());
                    double result = opr1 * opr2;
                    txtres.setText(Double.toString(result));
                }
                else {
                    Toast toast= Toast.makeText(MainActivity.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((e1.getText().length()>0) && (e2.getText().length()>0)){
                    double opr1 = Double.parseDouble(e1.getText().toString());
                    double opr2 = Double.parseDouble(e2.getText().toString());
                    double result = opr1 / opr2;
                    txtres.setText(Double.toString(result));
                }
                else {
                    Toast toast= Toast.makeText(MainActivity.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
                txtres.setText("0.00");
                e1.requestFocus();
            }
        });
    }
}