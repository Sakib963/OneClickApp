package com.example.oneclickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
    TextView textview_no_one, textview_no_two, textview_no_three, textview_no_four,textview_no_five,textview_no_six,textview_no_seven,textview_no_eight,
            textview_name_one, textview_name_two, textview_name_three, textview_name_four,textview_name_five,textview_name_six,textview_name_seven,textview_name_eight,
            textview_quantity_one,textview_quantity_two,textview_quantity_three,textview_quantity_four,textview_quantity_five,textview_quantity_six,textview_quantity_seven,textview_quantity_eight,
            textview_price_one, textview_price_two, textview_price_three, textview_price_four,textview_price_five,textview_price_six,textview_price_seven;
    Button order_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        textview_no_one = findViewById(R.id.row_two_textview_one);
        textview_no_two = findViewById(R.id.row_three_textview_one);
        textview_no_three = findViewById(R.id.row_four_textview_one);
        textview_no_four = findViewById(R.id.row_five_textview_one);
        textview_no_five = findViewById(R.id.row_six_textview_one);

        textview_name_one = findViewById(R.id.row_two_textview_two);
        textview_name_two = findViewById(R.id.row_three_textview_two);
        textview_name_three = findViewById(R.id.row_four_textview_two);
        textview_name_four = findViewById(R.id.row_five_textview_two);
        textview_name_five = findViewById(R.id.row_six_textview_two);
        textview_name_six = findViewById(R.id.row_seven_textview_two);
        textview_name_seven = findViewById(R.id.row_eight_textview_two);

        textview_quantity_one = findViewById(R.id.row_two_textview_three);
        textview_quantity_two = findViewById(R.id.row_three_textview_three);
        textview_quantity_three = findViewById(R.id.row_four_textview_three);
        textview_quantity_four = findViewById(R.id.row_five_textview_three);
        textview_quantity_five = findViewById(R.id.row_six_textview_three);
        textview_quantity_six = findViewById(R.id.row_seven_textview_three);
        textview_quantity_seven = findViewById(R.id.row_eight_textview_three);

        textview_price_one = findViewById(R.id.row_two_textview_four);
        textview_price_two = findViewById(R.id.row_three_textview_four);
        textview_price_three = findViewById(R.id.row_four_textview_four);
        textview_price_four = findViewById(R.id.row_five_textview_four);
        textview_price_five = findViewById(R.id.row_six_textview_four);
        textview_price_six = findViewById(R.id.row_seven_textview_four);
        textview_price_seven = findViewById(R.id.row_eight_textview_four);

        order_now = findViewById(R.id.order_now_button);


        Intent intent = getIntent();
        String q1 = intent.getStringExtra("napa");
        Integer i1 = Integer.parseInt(q1);

        String q2 = intent.getStringExtra("seclo");
        Integer i2 = Integer.parseInt(q2);

        String q3 = intent.getStringExtra("bandage");
        Integer i3 = Integer.parseInt(q3);

        String q4 = intent.getStringExtra("savlon_cream");
        Integer i4 = Integer.parseInt(q4);

        String q5 = intent.getStringExtra("sanitary");
        Integer i5 = Integer.parseInt(q5);

        String q6 = intent.getStringExtra("savlon_liquid");
        Integer i6 = Integer.parseInt(q6);

        String q7 = intent.getStringExtra("dettol");
        Integer i7 = Integer.parseInt(q7);

        Double price = 0.0;

        if (i1 != 0)
        {
            price = i1*40.0;
            textview_name_one.setText("Napa Extend");
            textview_quantity_one.setText(String.valueOf(i1));
            textview_price_one.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i2 != 0)
        {
            price = i2*60.0;
            textview_name_two.setText("Seclo");
            textview_quantity_two.setText(String.valueOf(i2));
            textview_price_two.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i3 != 0)
        {
            price = i3*60.0;
            textview_name_three.setText("Bandage");
            textview_quantity_three.setText(String.valueOf(i3));
            textview_price_three.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i4 != 0)
        {
            price = i4*60.0;
            textview_name_four.setText("Savlon Cream");
            textview_quantity_four.setText(String.valueOf(i4));
            textview_price_four.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i5 != 0)
        {
            price = i5*100.0;
            textview_name_five.setText("Sanitary Napkin");
            textview_quantity_five.setText(String.valueOf(i5));
            textview_price_five.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i6 != 0)
        {
            price = i6*100.0;
            textview_name_six.setText("Savlon Liquid");
            textview_quantity_six.setText(String.valueOf(i6));
            textview_price_six.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i7 != 0)
        {
            price = i7*38.0;
            textview_name_seven.setText("Dettol");
            textview_quantity_seven.setText(String.valueOf(i7));
            textview_price_seven.setText(String.valueOf(price));
            price = 0.0;
        }

        order_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = String.valueOf(i1);
                String s2 = String.valueOf(i2);
                String s3 = String.valueOf(i3);
                String s4 = String.valueOf(i4);
                String s5 = String.valueOf(i5);
                String s6 = String.valueOf(i6);
                String s7 = String.valueOf(i7);

                Intent intent = new Intent(CartActivity.this, MedicineOrderActivity.class);
                intent.putExtra("napa", s1);
                intent.putExtra("seclo", s2);
                intent.putExtra("bandage", s3);
                intent.putExtra("savlon_cream", s4);
                intent.putExtra("sanitary", s5);
                intent.putExtra("savlon_liquid", s6);
                intent.putExtra("dettol", s7);
                startActivity(intent);
            }
        });

    }
}