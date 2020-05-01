package com.example.sheardpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton pg_1_op_1, pg_1_op_2, pg_1_op_3, pg_1_op_4;
    Button next;
    int total=0;
    SharedPreferences pref;
    Button highscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pg_1_op_1 = findViewById(R.id.pg_1_op_1);
        pg_1_op_2 = findViewById(R.id.pg_1_opt_2);
        pg_1_op_3 = findViewById(R.id.pg_1_op_3);
        pg_1_op_4 = findViewById(R.id.pg_1_op_4);
        next=findViewById(R.id.next);
        highscore=findViewById(R.id.highscore);

        pref=getSharedPreferences("MyData",MODE_PRIVATE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edit=pref.edit();
                if(pg_1_op_1.isChecked())
                {
                    total=total+10;
                }
                edit.putInt("HighScore",total);
                edit.commit();
                Intent intent=new Intent(MainActivity.this,Nextpage.class);
                startActivity(intent);

            }
        });
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Final.class);
                
            }
        });

    }


}
