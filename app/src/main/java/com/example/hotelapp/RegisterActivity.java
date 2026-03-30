package com.example.hotelapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText username, email, password, confirmPassword;
    Button registerBtn;
    TextView goLogin;
    FirebaseAuth auth;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        registerBtn = findViewById(R.id.registerBtn);
        goLogin = findViewById(R.id.goLogin);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance().getReference("Users");

        //Navigate to Login
        goLogin.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        });

        // Register Button
        registerBtn.setOnClickListener(v -> {

            String user = username.getText().toString().trim();
            String e = email.getText().toString().trim();
            String p = password.getText().toString().trim();
            String cp = confirmPassword.getText().toString().trim();

            //Proper validations

            if (user.isEmpty()) {
                Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show();
                return;
            }

            if (e.isEmpty()) {
                Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
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

            if (cp.isEmpty()) {
                Toast.makeText(this, "Please confirm password", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!p.equals(cp)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // Firebase Register
            auth.createUserWithEmailAndPassword(e, p)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {

                            String userId = auth.getCurrentUser().getUid();

                            // Save user data
                            User userObj = new User(e);
                            db.child(userId).setValue(userObj);

                            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();

                            // Go to login
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            finish();

                        } else {
                            Toast.makeText(this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}