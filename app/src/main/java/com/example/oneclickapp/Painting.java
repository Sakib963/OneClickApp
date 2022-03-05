package com.example.oneclickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Painting extends AppCompatActivity {
    Button painting_service, carpentry, renovation, interior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting);

        painting_service = findViewById(R.id.painting_service_btn);
        carpentry = findViewById(R.id.carpentry_service_btn);
        renovation = findViewById(R.id.renovation_service_btn);
        interior = findViewById(R.id.interior_service_btn);

        painting_service.setOnClickListener(new View.OnClickListener() {

            Integer key = 12;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Painting.this, PaintingDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });

        carpentry.setOnClickListener(new View.OnClickListener() {

            Integer key = 13;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Painting.this, PaintingDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });

        renovation.setOnClickListener(new View.OnClickListener() {

            Integer key = 14;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Painting.this, PaintingDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });

        interior.setOnClickListener(new View.OnClickListener() {

            Integer key = 15;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Painting.this, PaintingDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });
    }
}