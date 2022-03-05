package com.example.oneclickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EmergencyMedicineActivity extends AppCompatActivity {

    Button proceed, napa_extend, seclo, savlon_liquid, savlon_cream, sanitary_pad, dettol, bandage;

    FloatingActionButton floatingActionButton;

    int napa_num=0, seclo_num=0, savlon_liq_num=0, savlon_cream_num=0, sanitary_num=0, dettol_num=0, bandage_num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_medicine);

        proceed = findViewById(R.id.proceed_button);
        napa_extend = findViewById(R.id.napa_extend_button);
        seclo = findViewById(R.id.seclo_button);
        savlon_liquid = findViewById(R.id.savlon_liquid_button);
        savlon_cream = findViewById(R.id.savlon_button);
        sanitary_pad = findViewById(R.id.sanitary_pad_button);
        dettol = findViewById(R.id.dettol_button);
        bandage = findViewById(R.id.bandage_button);

        floatingActionButton = findViewById(R.id.floating_button);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (napa_num ==0 && seclo_num == 0 && bandage_num == 0 && savlon_cream_num == 0 &&
                        sanitary_num == 0 && savlon_liq_num == 0 && dettol_num == 0)
                {
                    proceed.setError("No Item is Selected");
                    Toast.makeText(EmergencyMedicineActivity.this, "No Item is Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String s1 = String.valueOf(napa_num);
                    String s2 = String.valueOf(seclo_num);
                    String s3 = String.valueOf(bandage_num);
                    String s4 = String.valueOf(savlon_cream_num);
                    String s5 = String.valueOf(sanitary_num);
                    String s6 = String.valueOf(savlon_liq_num);
                    String s7 = String.valueOf(dettol_num);

                    Intent intent = new Intent(EmergencyMedicineActivity.this, MedicineOrderActivity.class);
                    intent.putExtra("napa", s1);
                    intent.putExtra("seclo", s2);
                    intent.putExtra("bandage", s3);
                    intent.putExtra("savlon_cream", s4);
                    intent.putExtra("sanitary", s5);
                    intent.putExtra("savlon_liquid", s6);
                    intent.putExtra("dettol", s7);
                    startActivity(intent);

                }
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (napa_num ==0 && seclo_num == 0 && bandage_num == 0 && savlon_cream_num == 0 &&
                sanitary_num == 0 && savlon_liq_num == 0 && dettol_num == 0)
                {
                    Toast.makeText(EmergencyMedicineActivity.this, "No Product is Added", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String s1 = String.valueOf(napa_num);
                    String s2 = String.valueOf(seclo_num);
                    String s3 = String.valueOf(bandage_num);
                    String s4 = String.valueOf(savlon_cream_num);
                    String s5 = String.valueOf(sanitary_num);
                    String s6 = String.valueOf(savlon_liq_num);
                    String s7 = String.valueOf(dettol_num);

                    Intent intent = new Intent(EmergencyMedicineActivity.this, CartActivity.class);
                    intent.putExtra("napa", s1);
                    intent.putExtra("seclo", s2);
                    intent.putExtra("bandage", s3);
                    intent.putExtra("savlon_cream", s4);
                    intent.putExtra("sanitary", s5);
                    intent.putExtra("savlon_liquid", s6);
                    intent.putExtra("dettol", s7);
                    startActivity(intent);
                }
            }
        });

        napa_extend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);
                napa_num = napa_num+1;
            }
        });

        seclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);
                seclo_num = seclo_num+1;
            }
        });

        savlon_liquid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);
                savlon_liq_num= savlon_liq_num+1;
            }
        });
        savlon_cream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);
                savlon_cream_num = savlon_cream_num+1;
            }
        });
        dettol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);
                dettol_num = dettol_num+1;
            }
        });

        sanitary_pad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);
                sanitary_num =sanitary_num+1;
            }
        });

        bandage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);
                bandage_num = bandage_num+1;
            }
        });

    }
}