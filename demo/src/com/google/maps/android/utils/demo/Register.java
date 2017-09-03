package com.google.maps.android.utils.demo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private TextView title;
    private EditText mEmail, mPasswd;
    private ProgressBar progressBar;
    private Button signUp, backBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        title = (TextView) findViewById(R.id.signUp);
        mEmail = (EditText) findViewById(R.id.email);
        mPasswd = (EditText) findViewById(R.id.passwd);
        signUp = (Button) findViewById(R.id.signupBtn);
        backBtn = (Button) findViewById(R.id.bckBtn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();


        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(v.getContext(), Login.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startSignUp();
            }
        });
    }

    public void notifyUser(String message){

        Toast.makeText(Register.this, message, Toast.LENGTH_SHORT).show();
    }

    public void startSignUp(){

        String email = mEmail.getText().toString().trim();
        String password = mPasswd.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            notifyUser("Enter email address!");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            notifyUser("Enter password!");
            return;
        }

        if (password.length() < 6) {
            notifyUser("Password too short, enter minimum 6 characters!");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        //create user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        notifyUser("Registration Complete!!");
                        progressBar.setVisibility(View.GONE);
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            notifyUser("Authentication failed." + task.getException());

                        } else {
                            startActivity(new Intent(Register.this, MainActivity.class));
                            finish();
                        }
                    }
                });

    }
    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}

