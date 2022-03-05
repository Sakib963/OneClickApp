package com.example.oneclickapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class RegisterActivity extends AppCompatActivity {
    EditText fullname, phone,email_address, pass;
    Button regButton;
    ProgressDialog loadingBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname = findViewById(R.id.full_name_register_textview);
        phone = findViewById(R.id.phone_number_register_textview);
        email_address = findViewById(R.id.email_register_textview);
        pass = findViewById(R.id.password_register_textview);
        loadingBar = new ProgressDialog(this);
        regButton = findViewById(R.id.register_button);
        auth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingBar.setTitle("Creating Account");
                loadingBar.setMessage("Please wait, while we're checking...");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
                CreateAccount();
            }
        });
    }

    private void CreateAccount() {
        String user_name, user_phone, user_password, user_email;

        user_name = fullname.getText().toString();
        user_phone = phone.getText().toString();
        user_password = pass.getText().toString();
        user_email = email_address.getText().toString();

        if (TextUtils.isEmpty(user_name)){
            Toast.makeText(this, "Name is Required.", Toast.LENGTH_SHORT).show();
            loadingBar.dismiss();
        }
        else if (TextUtils.isEmpty(user_phone)){
            Toast.makeText(this, "Phone Number is Required.", Toast.LENGTH_SHORT).show();
            loadingBar.dismiss();
        }
        else if (TextUtils.isEmpty(user_email)){
            email_address.setError("Email cannot be empty");
            email_address.requestFocus();
            loadingBar.dismiss();
        }
        else if (TextUtils.isEmpty(user_password)){
            pass.setError("Password cannot be empty");
            pass.requestFocus();
            loadingBar.dismiss();
        }
        else if (user_password.length()<6){
            Toast.makeText(this, "Password must have atleast 6 characters.", Toast.LENGTH_SHORT).show();
            loadingBar.dismiss();
        }
        else
        {
            auth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registered Succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        loadingBar.dismiss();
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "An error occured." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                }
            });
        }
        loadingBar.dismiss();
    }
}
