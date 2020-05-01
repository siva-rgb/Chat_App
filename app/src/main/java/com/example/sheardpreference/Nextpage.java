package com.example.sheardpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Nextpage extends AppCompatActivity {
    RadioButton pg_2_op_1,pg_2_op_2,pg_2_op_3,pg_2_op_4;
    Button submit;
    int total=0;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextpage);
        pg_2_op_1=findViewById(R.id.pg_2_op_1);
        pg_2_op_2=findViewById(R.id.pg_2_op_2);
        pg_2_op_3=findViewById(R.id.pg_2_op_3);
        pg_2_op_4=findViewById(R.id.pg_2_op_4);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref=getSharedPreferences("MyData",MODE_PRIVATE);
                total=pref.getInt("HighScore",0);
                if (pg_2_op_1.isChecked())
                {
                    total=total+10;
                }
                SharedPreferences.Editor edit=pref.edit();
                edit.putInt("HighScore",total);
                edit.commit();//save to data we need comit
                Intent intent=new Intent(Nextpage.this,Final.class);
                startActivity(intent);
            }
        });

    }
}
