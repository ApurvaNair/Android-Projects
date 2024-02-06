package com.example.employeesqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewContents extends AppCompatActivity {

    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contents);

        ListView listView=findViewById(R.id.listView);
        databaseHandler=new DatabaseHandler(this);

        ArrayList<String> list=new ArrayList<>();
        Cursor cursor=databaseHandler.getListContents();

        if(cursor.getCount() == 0){
            Toast.makeText(this, "Database was empty", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                list.add(cursor.getString(0));
                list.add(cursor.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
                listView.setAdapter(listAdapter);
            }
        }

    }
}