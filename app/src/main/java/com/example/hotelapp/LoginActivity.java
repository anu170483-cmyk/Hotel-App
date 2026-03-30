package com.example.hotelapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText email, password;
    Button loginBtn;
    TextView goRegister;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        goRegister = findViewById(R.id.goRegister);

        auth = FirebaseAuth.getInstance();

        //  Styled clickable text
        SpannableString ss = new SpannableString("New user? Register here");
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), 10, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        goRegister.setText(ss);

        //  Navigate to Register
        goRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        //  Login Button
        loginBtn.setOnClickListener(v -> {

            String e = email.getText().toString().trim();
            String p = password.getText().toString().trim();

            //  Proper validation (improved)
            if (e.isEmpty()) {
                Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
                Toast.makeText(this, "Enter valid email", Toast.LENGTH_SHORT).show();
                return;
            }

            if (p.isEmpty()) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
                return;
            }

            if (p.length() < 6) {
                Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                return;
            }

            //  Firebase Login
            auth.signInWithEmailAndPassword(e, p).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LoginActivity.this, HotelActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}