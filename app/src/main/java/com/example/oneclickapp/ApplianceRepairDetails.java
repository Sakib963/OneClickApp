package com.example.oneclickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ApplianceRepairDetails extends AppCompatActivity {

    Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_repair_details);

        proceed = findViewById(R.id.proceed_btn);

        Intent i = getIntent();
        String q = i.getStringExtra("key");
        Integer pro = Integer.parseInt(q);

        proceed.setOnClickListener(new View.OnClickListener() {

            String s1 = String.valueOf(pro);

            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApplianceRepairDetails.this, OrderActivity.class);
                i.putExtra("AcRepair", s1);
                startActivity(i);
            }
        });
    }
}