package com.example.oneclickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button order_btn, apply;
    EditText name, phone, address, promo;
    TextView service_name, service_price, etDate;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference().child("Orders");
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        name = findViewById(R.id.name_edit_text);
        phone = findViewById(R.id.contact_number_edit_text);
        order_btn = findViewById(R.id.order_process_btn);
        address = findViewById(R.id.address_edit_text);
        service_name = findViewById(R.id.row_two_textview_one);
        service_price = findViewById(R.id.row_two_textview_two);
        etDate = findViewById(R.id.et_date);

        promo = findViewById(R.id.promo_code_edit_text);
        apply = findViewById(R.id.apply_btn);

        mAuth = FirebaseAuth.getInstance();

        Spinner spinner = findViewById(R.id.spinner_time);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);



        Intent intent = getIntent();
        String check = intent.getStringExtra("AcRepair");
        Integer num = Integer.parseInt(check);

        if (num == 1)
        {
            service_name.setText("AC Repair");
            service_price.setText("500.0");
        }
        else if (num == 2)
        {
            service_name.setText("AC Cooling Problem");
            service_price.setText("450.0");
        }
        else if (num == 3)
        {
            service_name.setText("AC Installation");
            service_price.setText("1000.0");
        }
        else if (num == 4)
        {
            service_name.setText("Oven Repair");
            service_price.setText("400.0");
        }
        else if (num == 5)
        {
            service_name.setText("TV Repair");
            service_price.setText("500.0");
        }
        else if (num == 6)
        {
            service_name.setText("Refrigerator Repair");
            service_price.setText("1000.0");
        }
        else if (num == 7)
        {
            service_name.setText("Washing Machine Repair");
            service_price.setText("800.0");
        }
        else if (num == 8)
        {
            service_name.setText("IPS Repair");
            service_price.setText("600.0");
        }
        else if (num == 9)
        {
            service_name.setText("House Shifting");
            service_price.setText("2000.0");
        }
        else if (num == 10)
        {
            service_name.setText("Commercial Shifting");
            service_price.setText("6000.0");
        }
        else if (num == 11)
        {
            service_name.setText("Pickup Rental");
            service_price.setText("5000.0");
        }
        else if (num == 12)
        {
            service_name.setText("Painting Service");
            service_price.setText("2000.0");
        }
        else if (num == 13)
        {
            service_name.setText("Carpentry Service");
            service_price.setText("3000.0");
        }
        else if (num == 14)
        {
            service_name.setText("Renovation Service");
            service_price.setText("1500.0");
        }
        else if (num == 15)
        {
            service_name.setText("Interior Service");
            service_price.setText("10000.0");
        }

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String promo_code, price_string;
                promo_code = promo.getText().toString();
                price_string = service_price.getText().toString();

                Double price;
                price = Double.parseDouble(String.valueOf(price_string));

                if (promo_code.equals("OneClick100"))
                {
                    price = price - 100.0;
                    service_price.setText(String.valueOf(price));
                }
                else if (promo_code.equals("OneClick50"))
                {
                    price = price - 50.0;
                    service_price.setText(String.valueOf(price));
                }
                apply.setEnabled(false);
            }
        });



        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        OrderActivity.this, new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day){
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                },year, month, day);
                datePickerDialog.show();
            }
        });

        order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(name.getText().toString()) && !TextUtils.isEmpty(phone.getText().toString())
                        && !TextUtils.isEmpty(address.getText().toString()) && !TextUtils.isEmpty(etDate.getText().toString())
                        && spinner.getSelectedItem() != null && spinner.getSelectedItem() != "Here.....")
                {
                    String user_full_name = name.getText().toString();
                    String user_contact = phone.getText().toString();
                    String user_address = address.getText().toString();
                    String service = service_name.getText().toString();
                    String price = service_price.getText().toString();
                    String date = etDate.getText().toString();
                    String time = spinner.getSelectedItem().toString();
                    String order_id = databaseReference.push().getKey();

                    HashMap<String, String> usermap = new HashMap<>();
                    usermap.put("orderID", order_id);
                    usermap.put("name", user_full_name);
                    usermap.put("contact", user_contact);
                    usermap.put("address", user_address);
                    usermap.put("service_name", service);
                    usermap.put("service_price", price);
                    usermap.put("service_date", date);
                    usermap.put("service_time", time);

                    databaseReference.child("orderID").child(order_id).setValue(usermap);

                    Toast.makeText(OrderActivity.this, "Order Successfully Received.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(OrderActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
                else
                {
                    order_btn.setError("Address must be filled.");

                    if (TextUtils.isEmpty(name.getText().toString()))
                    {
                        name.setError("");
                        Toast.makeText(OrderActivity.this, "Full Name must be given", Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(phone.getText().toString()))
                    {
                        phone.setError("");
                        Toast.makeText(OrderActivity.this, "Phone number should be given", Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(address.getText().toString()))
                    {
                        address.setError("");
                        Toast.makeText(OrderActivity.this, "Address should be given", Toast.LENGTH_SHORT).show();
                    }
                    if (spinner.getSelectedItem() == "Here....." || spinner.getSelectedItem() == null)
                    {
                        Toast.makeText(OrderActivity.this, "Time Should be given", Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(etDate.getText().toString()))
                    {
                        Toast.makeText(OrderActivity.this, "Date Should be selected.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}