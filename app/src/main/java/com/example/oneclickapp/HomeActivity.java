package com.example.oneclickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    Button logout, appliance, ac_repair, shifting, paint, orders, contact, promo_code, emergency;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout = findViewById(R.id.logout_button);
        mAuth = FirebaseAuth.getInstance();
        appliance = findViewById(R.id.appliance_repair_btn);
        ac_repair = findViewById(R.id.ac_repair_btn);
        shifting = findViewById(R.id.shifting_btn);
        paint = findViewById(R.id.painting_btn);
        orders = findViewById(R.id.orders_btn);
        contact = findViewById(R.id.contact_us_btn);
        promo_code = findViewById(R.id.promo_code_btn);
        emergency = findViewById(R.id.emergency_btn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });


        appliance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, ApplianceRepair.class);
                startActivity(i);
            }
        });

        ac_repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, AcRepairService.class);
                startActivity(i);
            }
        });

        shifting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, Shifting.class);
                startActivity(i);
            }
        });

        paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, Painting.class);
                startActivity(i);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, ContactUsActivity.class);
                startActivity(i);
            }
        });

        promo_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, PromoCode.class);
                startActivity(intent);
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, EmergencyMedicineActivity.class));
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser == null)
        {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        }
    }

}