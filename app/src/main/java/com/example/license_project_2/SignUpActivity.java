package com.example.license_project_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignUpActivity extends AppCompatActivity {

    EditText signupName, signupSurname, signupUsername, signupEmail, signupPassword, signupConfirmPassword;
    TextView loginRedirectText;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        signupName            = findViewById(R.id.textNameID);
        signupSurname         = findViewById(R.id.textSurnameID);
        signupUsername        = findViewById(R.id.textUsernameID);
        signupEmail           = findViewById(R.id.textEmailID);
        signupPassword        = findViewById(R.id.textPasswordID);
        signupConfirmPassword = findViewById(R.id.textConfirmPasswordID);
        loginRedirectText     = findViewById(R.id.LogInRedirectText);
        signupButton          = findViewById(R.id.SignUpButtonID);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUser();
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
    }

    public void checkUser() {
        String name            = signupName.getText().toString().trim();
        String surname         = signupSurname.getText().toString().trim();
        String username        = signupUsername.getText().toString().trim();
        String email           = signupEmail.getText().toString().trim();
        String emailRegexPattern = "^[a-zA-Z0-9._%+\\-]+@[a-zA-Z0-9.\\-]+\\.[a-zA-Z]{2,}$";
        String password        = signupPassword.getText().toString().trim();
        String confirmPassword = signupConfirmPassword.getText().toString().trim();

        if (name.isEmpty() || !Character.isUpperCase(name.charAt(0))) {
            signupName.setError("'A-Z' as starting letter");
            signupName.requestFocus();
            return;
        }
        if (surname.isEmpty() || !Character.isUpperCase(surname.charAt(0))) {
            signupSurname.setError("'A-Z' as starting letter");
            signupSurname.requestFocus();
            return;
        }
        if (email.isEmpty() || !email.matches(emailRegexPattern)) {
            signupEmail.setError("Invalid email address");
            signupEmail.requestFocus();
            return;
        }
        if (!password.equals(confirmPassword)) {
            signupConfirmPassword.setError("Passwords don't match");
            signupConfirmPassword.requestFocus();
            return;
        }
        if (password.length() < 8) {
            signupPassword.setError("Password must have at least 8 characters");
            signupPassword.requestFocus();
            return;
        }

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDB = reference.orderByChild("username").equalTo(username);
        checkUserDB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    signupUsername.setError("Username Taken");
                    signupUsername.requestFocus();
                } else {
                    signupUsername.setError(null);
                    HelperClass helperClass = new HelperClass(name, surname, username, email, password);
                    reference.child(username).setValue(helperClass);
                    Toast.makeText(SignUpActivity.this, "You've signed up!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SignUpActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}