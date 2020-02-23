package com.example.app_pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    Button btn_pizza1,btn_pizza2,btn_pizza3,btn_pizza4,btn_pizza5,btn_pizza6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_pizza1 = findViewById(R.id.pizza1);
        btn_pizza2 = findViewById(R.id.pizza2);
        btn_pizza3 = findViewById(R.id.pizza3);
        btn_pizza4 = findViewById(R.id.pizza4);
        btn_pizza5 = findViewById(R.id.pizza5);
        btn_pizza6 = findViewById(R.id.pizza6);

        btn_pizza1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Order_pizza.class);
                intent.putExtra("name", "แฮมและปูอัด");
                startActivity(intent);
            }
        });

        btn_pizza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Order_pizza.class);
                intent.putExtra("name", "ฮาวายเฮี้ยน");
                startActivity(intent);

            }
        });
        btn_pizza3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Order_pizza.class);
                intent.putExtra("name", "ซุปเปอร์ซีฟู๊ด");
                startActivity(intent);
            }
        });
        btn_pizza4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Order_pizza.class);
                intent.putExtra("name", "มีทเดอลุกซ์");
                startActivity(intent);
            }
        });
        btn_pizza5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Order_pizza.class);
                intent.putExtra("name", "ค็อกเทลกุ้ง");
                startActivity(intent);

            }
        });
        btn_pizza6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Order_pizza.class);
                intent.putExtra("name", "ต้มยำกุ้ง");
                startActivity(intent);
            }
        });


    }
}
