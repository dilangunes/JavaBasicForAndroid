package com.dilangunes.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this,"Toast Message",Toast.LENGTH_LONG).show();

    }

    public  void save(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Kaydet");
        alert.setMessage("Emin misniz?");
        alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Kaydedildi",Toast.LENGTH_LONG).show();
            }
        });

        alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Kaydedilmedi",Toast.LENGTH_LONG).show();
            }
        });

        alert.show();
    }
}
