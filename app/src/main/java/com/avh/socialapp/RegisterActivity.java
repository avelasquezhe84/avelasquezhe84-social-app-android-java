package com.avh.socialapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    // Views
    EditText mEmailEt, mPasswordEt;
    Button mRegisterBtn;

    // Progress Bar to display while registering user
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // ActionBar and title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Create Account");

        // Enable back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        // Init
        mEmailEt = findViewById(R.id.emailEt);
        mPasswordEt = findViewById(R.id.passwordEt);
        mRegisterBtn = findViewById(R.id.registerBtn);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering user...");

        // Handle Register Btn Click
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Input email, password
                String email = mEmailEt.getText().toString().trim();
                String password = mPasswordEt.getText().toString().trim();

                // Validate
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    // Set error and focus to email ET
                    mEmailEt.setError("Invalid Email");
                    mEmailEt.setFocusable(true);
                } else if (password.length() < 6) {
                    // Set error and focus to password ET
                    mPasswordEt.setError("Password length must be at least 6 characters");
                    mPasswordEt.setFocusable(true);
                } else {
                    registerUser(email, password);
                }

            }
        });

    }

    private void registerUser(String email, String password) {
        // Email and password patterns are valid, show progress dialog and start registering user
        
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go to previous activity
        return super.onSupportNavigateUp();
    }
}