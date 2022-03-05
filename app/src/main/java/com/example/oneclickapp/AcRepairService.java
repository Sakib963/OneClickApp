package com.example.oneclickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcRepairService extends AppCompatActivity {
    Button ac_servicing, ac_cooling, ac_install;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_repair_service);
        ac_servicing = findViewById(R.id.ac_servicing_btn);
        ac_cooling = findViewById(R.id.ac_cooling_btn);
        ac_install = findViewById(R.id.ac_installation_btn);


        ac_servicing.setOnClickListener(new View.OnClickListener() {
            Integer key = 1;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(AcRepairService.this, AcRepairOrder_Details.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });
        ac_cooling.setOnClickListener(new View.OnClickListener() {
            Integer key = 2;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(AcRepairService.this, AcRepairOrder_Details.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });
        ac_install.setOnClickListener(new View.OnClickListener() {
            Integer key = 3;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(AcRepairService.this, AcRepairOrder_Details.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });
    }
}