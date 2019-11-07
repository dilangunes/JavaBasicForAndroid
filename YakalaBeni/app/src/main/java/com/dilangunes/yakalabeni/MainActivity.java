package com.dilangunes.yakalabeni;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;

    TextView textView;
    Integer scoreCount;
    CountDownTimer countDownTimer;
    TextView textView2;

    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageArray = new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};
        hideImages();

        textView = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView);
        scoreCount = 0;

        new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
                 textView2.setText("Süre: " + l / 1000);
            }

            @Override
            public void onFinish() {
                textView2.setText("Süre Bitti!");
                handler.removeCallbacks(runnable);

                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setTitle("Yeniden?");
                alertBuilder.setMessage("Oyun yeniden başlasın mı :)");
                alertBuilder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //restart

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });

                alertBuilder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Sıkıldın mı :(",Toast.LENGTH_LONG).show();
                    }
                });
                alertBuilder.show();
            }


        }.start();
    }

    public  void scoreCount(View view){

        scoreCount ++;
        textView.setText("Score: " + scoreCount);
    }

    public void hideImages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(runnable,400);
            }
        };

        handler.post(runnable);
    }
}
