package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1=findViewById(R.id.button1);
        Button btn2=findViewById(R.id.button2);

        String phone_no="123456789";
        btn1.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+phone_no));
            startActivity(intent);

            Toast.makeText(MainActivity.this, "You have clicked Implicit button", Toast.LENGTH_SHORT).show();
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You have clicked Explicit button", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), ActivityOne.class);
                startActivity(i);
            }
        });
    }
}