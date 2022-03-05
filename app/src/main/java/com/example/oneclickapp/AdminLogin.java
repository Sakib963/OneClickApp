package com.example.oneclickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    TextView admin, passAdmin;
    Button login_admin;
    ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        admin = findViewById(R.id.admin_name_text);
        passAdmin = findViewById(R.id.admin_pass_text);
        login_admin = findViewById(R.id.login_admin_btn);

        loadingBar = new ProgressDialog(this);

        login_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String admin_password, admin_email;
                admin_password = passAdmin.getText().toString();
                admin_email = admin.getText().toString();

                if (TextUtils.isEmpty(admin_email)){
                    admin.setError("Email cannot be empty");
                    admin.requestFocus();
                    loadingBar.dismiss();
                }
                else if (TextUtils.isEmpty(admin_password)){
                    passAdmin.setError("Password cannot be empty");
                    passAdmin.requestFocus();
                    loadingBar.dismiss();
                }
                else {
                    if (admin_email.equals("admin") && admin_password.equals("admin123") )
                    {
                        Toast.makeText(AdminLogin.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AdminLogin.this, AdminPanel.class);
                        startActivity(intent);
                        loadingBar.dismiss();
                    }
                    else
                    {
                        Toast.makeText(AdminLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                }
            }
        });
    }
}