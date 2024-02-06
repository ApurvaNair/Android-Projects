package com.example.employeesqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,surname;
    Button add,del,update,view;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHandler(this);

        name = findViewById(R.id.edt1);
        surname = findViewById(R.id.edt2);
        add = findViewById(R.id.button);
        update = findViewById(R.id.button2);
        del = findViewById(R.id.button3);
        view = findViewById(R.id.button4);
        addData();
        updatedData();
        delData();
        viewData();
    }
    public void addData(){
        add.setOnClickListener(view -> {
            boolean isInserted = db.insertData(name.getText().toString(),surname.getText().toString());

            if (isInserted) {
                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
            }

        });
    }
    public void updatedData(){
        update.setOnClickListener(view -> {
            boolean isUpdated = db.updateData(name.getText().toString(),surname.getText().toString());

            if (isUpdated) {
                Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
            }

        });
    }
    public void delData(){
        del.setOnClickListener(view -> {
            Integer deleted= db.deleteData(name.getText().toString());

            if (deleted > 0){
                Toast.makeText(MainActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void viewData(){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ViewContents.class);
                startActivity(i);
            }
        });
    }
    }