package com.example.haripertama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PassingData extends AppCompatActivity {

    public static final String KEY_NAME = "NAME";
    public static final String KEY_AGE = "AGE";

    //TODO 2.1 declare widget yg ingin digunakan
    TextView tvDataRecieved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_data);

        //TODO 2.2 initialisasi id
        tvDataRecieved = findViewById(R.id.tv_data_recieved);

        //TODO 2.4 get data yg dikirim
        String name = getIntent().getStringExtra(KEY_NAME);
        int age = getIntent().getIntExtra(KEY_AGE, 0);

        //TODO 2.5 show ke view
        String tampung = "Name : " + name + "\nAge : " + age;

        tvDataRecieved.setText(tampung);
    }
}
