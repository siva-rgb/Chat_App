package com.example.sheardpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Final extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        textView=findViewById(R.id.highscore);
        SharedPreferences pref=getSharedPreferences("MyData",MODE_PRIVATE);
        int score= pref.getInt("HighScore",0);
        textView.setText("High Score = "+score);
    }
}
