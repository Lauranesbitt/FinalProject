package com.example.laura.heartbeats;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.laura.heartbeats.db.TaskDbHelper;
import com.example.laura.heartbeats.db.TaskContract;
public class Main7Activity extends AppCompatActivity {



    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    String phoneNo;
    EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);


        etPhone = (EditText) findViewById(R.id.editText7);

        Button bCall = (Button) findViewById(R.id.button10);

        bCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPhone();
            }
        });
    }

    protected void callPhone() {
        phoneNo = etPhone.getText().toString();
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.CALL_PHONE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);
            }
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phoneNo));
            startActivity(callIntent);
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phoneNo));
                    try {
                        startActivity(callIntent);
                    } catch (Exception e) {

                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS failed, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }

    public static class TaskDbHelper extends SQLiteOpenHelper {

        public TaskDbHelper(Context context) {
            super(context, TaskContract.DB_NAME, null, TaskContract.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTable = "CREATE TABLE " + TaskContract.TaskEntry.TABLE + " ( " +
                    TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TaskContract.TaskEntry.TABLE);
            onCreate(db);
        }
    }
}


