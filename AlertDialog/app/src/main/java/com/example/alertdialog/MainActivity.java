package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder alert1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alert1 =new AlertDialog.Builder(this);
        alert1.setTitle("AlertDialog Example");
        alert1.setIcon(R.drawable.baseline_question_mark_24);
        alert1.setCancelable(false);
        alert1.setMessage("Are you sure you want to continue?");
        alert1.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(MainActivity.this,"You choose Yes", Toast.LENGTH_LONG).show();
                 }
        });
        alert1.setNegativeButton("No",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {
                finish();
                Toast.makeText(MainActivity.this,"You choose No",Toast.LENGTH_LONG).show();
            }
        });
        alert1.show();
    }
}