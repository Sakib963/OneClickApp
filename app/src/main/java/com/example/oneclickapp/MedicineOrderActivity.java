package com.example.oneclickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MedicineOrderActivity extends AppCompatActivity {
    TextView textview_no_one, textview_no_two, textview_no_three, textview_no_four,textview_no_five,textview_no_six,textview_no_seven,textview_no_eight,
            textview_name_one, textview_name_two, textview_name_three, textview_name_four,textview_name_five,textview_name_six,textview_name_seven,textview_name_eight,
            textview_quantity_one,textview_quantity_two,textview_quantity_three,textview_quantity_four,textview_quantity_five,textview_quantity_six,textview_quantity_seven,textview_quantity_eight,
            textview_price_one, textview_price_two, textview_price_three, textview_price_four,textview_price_five,textview_price_six,textview_price_seven,
    total_price_text;
    EditText name, phone, address;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference().child("Orders");
    FirebaseAuth mAuth;


    Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_order);

        name = findViewById(R.id.name_edit_text);
        phone = findViewById(R.id.contact_number_edit_text);
        address = findViewById(R.id.address_edit_text);

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

        total_price_text = findViewById(R.id.total_price);

        mAuth = FirebaseAuth.getInstance();

        order = findViewById(R.id.order_button);

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

        Double price = 0.0, sub_total = 0.0;

        if (i1 != 0)
        {
            price = i1*40.0;
            sub_total = sub_total+price;
            textview_name_one.setText("Napa Extend");
            textview_quantity_one.setText(String.valueOf(i1));
            textview_price_one.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i2 != 0)
        {
            price = i2*60.0;
            sub_total = sub_total+price;
            textview_name_two.setText("Seclo");
            textview_quantity_two.setText(String.valueOf(i2));
            textview_price_two.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i3 != 0)
        {
            price = i3*60.0;
            sub_total = sub_total+price;
            textview_name_three.setText("Bandage");
            textview_quantity_three.setText(String.valueOf(i3));
            textview_price_three.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i4 != 0)
        {
            price = i4*60.0;
            sub_total = sub_total+price;
            textview_name_four.setText("Savlon Cream");
            textview_quantity_four.setText(String.valueOf(i4));
            textview_price_four.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i5 != 0)
        {
            price = i5*100.0;
            sub_total = sub_total+price;
            textview_name_five.setText("Sanitary Napkin");
            textview_quantity_five.setText(String.valueOf(i5));
            textview_price_five.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i6 != 0)
        {
            price = i6*100.0;
            sub_total = sub_total+price;
            textview_name_six.setText("Savlon Liquid");
            textview_quantity_six.setText(String.valueOf(i6));
            textview_price_six.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i7 != 0)
        {
            price = i7*38.0;
            sub_total = sub_total+price;
            textview_name_seven.setText("Dettol");
            textview_quantity_seven.setText(String.valueOf(i7));
            textview_price_seven.setText(String.valueOf(price));
            price = 0.0;
        }

        total_price_text.setText(String.valueOf(sub_total));

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(name.getText().toString()) && !TextUtils.isEmpty(phone.getText().toString())
                        && !TextUtils.isEmpty(address.getText().toString()))
                {
                    String user_full_name = name.getText().toString();
                    String user_contact = phone.getText().toString();
                    String user_address = address.getText().toString();
                    String med_one = textview_name_one.getText().toString();
                    String med_two = textview_name_two.getText().toString();
                    String med_three = textview_name_three.getText().toString();
                    String med_four = textview_name_four.getText().toString();
                    String med_five = textview_name_five.getText().toString();
                    String med_six = textview_name_six.getText().toString();
                    String med_seven = textview_name_seven.getText().toString();
                    String qua_one = textview_quantity_one.getText().toString();
                    String qua_two = textview_quantity_two.getText().toString();
                    String qua_three = textview_quantity_three.getText().toString();
                    String qua_four = textview_quantity_four.getText().toString();
                    String qua_five = textview_quantity_five.getText().toString();
                    String qua_six = textview_quantity_six.getText().toString();
                    String qua_seven = textview_quantity_seven.getText().toString();
                    String order_id = databaseReference.push().getKey();

                    HashMap<String, String> usermap = new HashMap<>();
                    usermap.put("orderID", order_id);
                    usermap.put("name", user_full_name);
                    usermap.put("contact", user_contact);
                    usermap.put("address", user_address);
                    usermap.put("med_one", med_one);
                    usermap.put("med_two", med_two);
                    usermap.put("med_three", med_three);
                    usermap.put("med_four", med_four);
                    usermap.put("med_five", med_five);
                    usermap.put("med_six", med_six);
                    usermap.put("med_seven", med_seven);
                    usermap.put("qua_one", qua_one);
                    usermap.put("qua_two", qua_two);
                    usermap.put("qua_three", qua_three);
                    usermap.put("qua_four", qua_four);
                    usermap.put("qua_five", qua_five);
                    usermap.put("qua_six", qua_six);
                    usermap.put("qua_seven", qua_seven);

                    databaseReference.child("orderID").child(order_id).setValue(usermap);

                    Toast.makeText(MedicineOrderActivity.this, "Order Successfully Received.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MedicineOrderActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}