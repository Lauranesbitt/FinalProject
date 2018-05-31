package com.example.laura.heartbeats;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
//import android.widget.Button;ipackage com.example.laura.heartbeats2;


import android.widget.Button;

public class MainActivity extends AppCompatActivity {;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showActivity2 = (Button) findViewById(R.id.button);
        Button showActivity3 = (Button) findViewById(R.id.button2);




        showActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
            }
        });
        showActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);
            }
        });




    }

    /**
     * Created by laura on 29/05/2018.
     */
    public static class TaskContract {
        public static final String DB_NAME = "com.example.laura.heartbeats.db";
        public static final int DB_VERSION = 1;

        public class TaskEntry implements BaseColumns {
            public static final String TABLE = "tasks";

            public static final String COL_TASK_TITLE = "title";
        }
    }
}

