package com.example.haripertama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.haripertama.model.Orang;

public class PassingObject extends AppCompatActivity {

    public static final String EXTRA_OBJ = "OBJECT";

    //TODO 3.1 declare
    TextView tvDataRecievedObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_object);

        //TODO 3.2 inisialisasi
        tvDataRecievedObj = findViewById(R.id.tv_data_object);

        //TODO 3.4 get data object orang dengan parcelable
        Orang objOrang = getIntent().getParcelableExtra(EXTRA_OBJ);

        //TODO 3.5 tanpung dalam variable
        String tampung = "Name : " + objOrang.getName() +
                "\nAge : " + objOrang.getAge() +
                "\nJob : " + objOrang.getJob() +
                "\nAsal : " + objOrang.getAsal() +
                "\nTinggal : " + objOrang.getTinggal();

        //TODO 3.6 Show ke View
        tvDataRecievedObj.setText(tampung);

    }
}
