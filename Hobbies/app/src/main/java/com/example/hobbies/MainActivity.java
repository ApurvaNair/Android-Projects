package com.example.hobbies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox cb1=(CheckBox) findViewById(R.id.checkBox1);
        CheckBox cb2=(CheckBox) findViewById(R.id.checkBox2);
        CheckBox cb3=(CheckBox) findViewById(R.id.checkBox3);
        CheckBox cb4=(CheckBox) findViewById(R.id.checkBox4);
        Button b1=(Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);


                if(cb1.isChecked())
                {
                    intent.putExtra("checkbox1","Singing");
                }
                if(cb2.isChecked())
                {
                    intent.putExtra("checkbox2","Reading");
                }
                if(cb3.isChecked())
                {
                    intent.putExtra("checkbox3","Dancing");
                }
                if(cb4.isChecked())
                {
                    intent.putExtra("checkbox4","Drawing");
                }

                if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()){

                    intent.putExtra("text","Please select one option!");
                }
                startActivity(intent);
            }
        });
    }
}