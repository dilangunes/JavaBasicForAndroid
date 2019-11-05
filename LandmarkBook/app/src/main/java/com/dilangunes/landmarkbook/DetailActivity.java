package com.dilangunes.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView landmarkNameText = findViewById(R.id.txtLandmarkName);
        TextView countryNameText = findViewById(R.id.txtCountryName);

        Intent intent  = getIntent();
        String nameTxt = intent.getStringExtra("name");
        String countryTxt = intent.getStringExtra("countryNames");

        landmarkNameText.setText(nameTxt);
        countryNameText.setText(countryTxt);

        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosemImage());


    }
}
