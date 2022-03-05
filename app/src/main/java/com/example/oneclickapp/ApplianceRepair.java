package com.example.oneclickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ApplianceRepair extends AppCompatActivity {

    Button oven_repair, tv_repair, refrigerator_repair, washing_machine_repair, ips_repair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_repair);

        oven_repair = findViewById(R.id.oven_repair_services_btn);
        tv_repair = findViewById(R.id.tv_repair_services_btn);
        refrigerator_repair = findViewById(R.id.refrigerator_repair_services_btn);
        washing_machine_repair = findViewById(R.id.washing_machine_repair_services_btn);
        ips_repair = findViewById(R.id.ips_repair_services_btn);


        oven_repair.setOnClickListener(new View.OnClickListener() {

            Integer key = 4;
            String keey = String.valueOf(key);


            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApplianceRepair.this, ApplianceRepairDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });

        tv_repair.setOnClickListener(new View.OnClickListener() {

            Integer key = 5;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApplianceRepair.this, ApplianceRepairDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });

        refrigerator_repair.setOnClickListener(new View.OnClickListener() {

            Integer key = 6;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApplianceRepair.this, ApplianceRepairDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });

        washing_machine_repair.setOnClickListener(new View.OnClickListener() {

            Integer key = 7;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApplianceRepair.this, ApplianceRepairDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });

        ips_repair.setOnClickListener(new View.OnClickListener() {

            Integer key = 8;
            String keey = String.valueOf(key);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApplianceRepair.this, ApplianceRepairDetails.class);
                i.putExtra("key", keey);
                startActivity(i);
            }
        });
    }
}