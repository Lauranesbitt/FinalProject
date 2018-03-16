package com.example.laura.heartbeats;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class Main2Activity extends AppCompatActivity {
    private EditText Email;
    private EditText Password;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Pass);
        firebaseAuth = FirebaseAuth.getInstance();
    }
   public void Register_Click(View v){
       final ProgressDialog progressDialog = ProgressDialog.show(Main2Activity.this, "Please wait...", "Processing...", true);
       (firebaseAuth.createUserWithEmailAndPassword(Email.getText().toString(),Password.getText().toString())).addOnCompleteListener(new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {

               progressDialog.dismiss();
               if(task.isSuccessful()){
                   Toast.makeText(Main2Activity.this, "Registration successful", Toast.LENGTH_LONG).show();
                   Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                   startActivity(i);
               }

           }
       });
   }
}
