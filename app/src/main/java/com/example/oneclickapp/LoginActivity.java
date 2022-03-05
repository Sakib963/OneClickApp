package com.example.oneclickapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {
    TextView click;
    EditText email, password;
    Button login_button;
    FirebaseAuth auth;
    ProgressDialog loadingBar;
    ImageView img;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        img = findViewById(R.id.logowithbackground);

        click = findViewById(R.id.click_here_textview);
        email = findViewById(R.id.email_login_textview);
        password = findViewById(R.id.password_login_text);
        login_button = findViewById(R.id.loginButton);
        loadingBar = new ProgressDialog(this);

        auth = FirebaseAuth.getInstance();
        int clickcount = 0;

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingBar.setTitle("Logging In");
                loadingBar.setMessage("Please wait, while we're checking...");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
                LoginUser();
            }
        });
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;

                if (count == 5) {
                    Toast.makeText(getApplicationContext(), "You are 2 Click away to ADMIN mode", Toast.LENGTH_SHORT).show();
                }
                if (count == 6) {
                    Toast.makeText(getApplicationContext(), "You are 1 Click away to ADMIN mode", Toast.LENGTH_SHORT).show();
                }
                if (count == 7) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setCancelable(false);
                    builder.setTitle("Are You Sure??");
                    builder.setMessage("You Want To Go Admin Mode??");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(LoginActivity.this, AdminLogin.class);
                            startActivity(intent);
                        }
                    });
                    builder.show();
                    count = 0;

                }
            }
        });

    }

    private void LoginUser() {
        String user_password, user_email;
        user_password = password.getText().toString();
        user_email = email.getText().toString();

        if (TextUtils.isEmpty(user_email)){
            email.setError("Email cannot be empty");
            email.requestFocus();
            loadingBar.dismiss();
        }
        else if (TextUtils.isEmpty(user_password)){
            password.setError("Password cannot be empty");
            password.requestFocus();
            loadingBar.dismiss();
        }
        else
        {
            auth.signInWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(LoginActivity.this, "Logged in Succesfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        loadingBar.dismiss();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Login Failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                }
            });
        }
        loadingBar.dismiss();
    }

}
