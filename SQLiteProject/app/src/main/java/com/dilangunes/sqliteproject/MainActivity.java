package com.dilangunes.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY, name VARCHAR, age INT)");

            //database.execSQL("INSERT INTO musicians (name,age) VALUES ('Dilan',28)");
           // database.execSQL("INSERT INTO musicians (name,age) VALUES ('Barış',18)");

            Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE id=2",null);

            int nameIndex =  cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");
            int idIndex = cursor.getColumnIndex("id");

            while (cursor.moveToNext()){
                System.out.println("Name: "  + cursor.getString(nameIndex));
                System.out.println("Age: " +  cursor.getInt(ageIndex));
                System.out.println("Id: " + cursor.getInt(idIndex));
            }

            cursor.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
