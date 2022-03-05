package com.example.oneclickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Shifting extends AppCompatActivity {

    Button house_shifting, commercial_shifting, pickup_rental;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shifting);

        house_shifting = findViewById(R.id.house_shifting_btn);
        commercial_shifting = findViewById(R.id.commercial_shifting_btn);
        pickup_rental = findViewById(R.id.pickup_rental_btn);


        house_shifting.setOnClickListener(new View.OnClickListener() {

            Integer key = 9;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Shifting.this, ShiftingDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });

        commercial_shifting.setOnClickListener(new View.OnClickListener() {

            Integer key = 10;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Shifting.this, ShiftingDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });

        pickup_rental.setOnClickListener(new View.OnClickListener() {

            Integer key = 11;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Shifting.this, ShiftingDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });
    }
}