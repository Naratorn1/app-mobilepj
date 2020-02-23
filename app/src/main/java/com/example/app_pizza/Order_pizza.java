package com.example.app_pizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Order_pizza extends AppCompatActivity {
    EditText name_product,txt_firstname,txt_lastname,txt_phone,txt_address,txt_qty;
    Button btn_submit,btn_cancel;
    String name;
    DatabaseReference reff;
    Order order;
    long Maxid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pizza);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("name");
            name_product = findViewById(R.id.name_product);
            name_product.setText(name);
        }
        txt_firstname = (EditText) findViewById(R.id.first_name);
        txt_lastname = (EditText) findViewById(R.id.last_name);
        txt_phone = (EditText) findViewById(R.id.phone_number);
        txt_qty = (EditText) findViewById(R.id.qty_order);
        txt_address = (EditText) findViewById(R.id.address);
        btn_submit = (Button) findViewById(R.id.submit);
        btn_cancel = (Button) findViewById(R.id.button2);
        reff = FirebaseDatabase.getInstance().getReference().child("Order");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    Maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        order = new Order();
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_firstname.setText("");
                txt_qty.setText("");
                txt_phone.setText("");
                txt_address.setText("");
                txt_lastname.setText("");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // yourMethod();
                        Intent intent = new Intent(Order_pizza.this,MainActivity.class);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long phone = Long.parseLong(txt_phone.getText().toString().trim());
                Integer qty = Integer.parseInt(txt_qty.getText().toString().trim());
                order.setFirst_name(txt_firstname.getText().toString().trim());
                order.setLast_name(txt_lastname.getText().toString().trim());
                order.setAddress(txt_address.getText().toString().trim());
                order.setName_product(name);
                order.setPhone(phone);
                order.setQty_order(qty);
                reff.child(String.valueOf(Maxid+1)).setValue(order);
                Toast.makeText(Order_pizza.this,"Data base Insert ",Toast.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // yourMethod();
                        Intent intent = new Intent(Order_pizza.this,check_value.class);
                        startActivity(intent);
                    }
                }, 5000);

            }
        });
    }
}
