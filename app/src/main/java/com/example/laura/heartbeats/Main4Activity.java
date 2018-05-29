package com.example.laura.heartbeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button showActivity5 = (Button) findViewById(R.id.button5);

        Button showActivity7 = (Button) findViewById(R.id.button7);
        Button showActivity8 = (Button) findViewById(R.id.button8);

        showActivity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main5Activity.class);
                startActivity(intent);
            }
        });






        showActivity7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main7Activity.class);
                startActivity(intent);
            }
        });


        showActivity8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main8Activity.class);
                startActivity(intent);
            }
        });



    }

}
