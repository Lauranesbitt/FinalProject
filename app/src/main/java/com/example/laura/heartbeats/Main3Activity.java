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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {

    private EditText LoginEmail;
    private EditText LoginPass;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        LoginEmail = (EditText) findViewById(R.id.LoginEmail);
        LoginPass = (EditText) findViewById(R.id.LoginPass);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void Login_Click(View v) {
        final ProgressDialog progressDialog = ProgressDialog.show(Main3Activity.this, "Please wait...", "Processing...", true);
        (firebaseAuth.signInWithEmailAndPassword(LoginEmail.getText().toString(), LoginPass.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressDialog.dismiss();

                if (task.isSuccessful()) {
                    Toast.makeText(Main3Activity.this, "Login success", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Main3Activity.this, Main4Activity.class);
                    i.putExtra("Email:",firebaseAuth.getCurrentUser().getEmail());
                    startActivity(i);
                }
                else{
                    Log.e("ERROR",task.getException().toString());
                    Toast.makeText(Main3Activity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}