package com.example.haripertama;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.haripertama.model.Orang;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE = 1;
    //TODO 1.1 Declare widget yg mw digunakan
    Button btnMove, btnPassingData, btnPassingObject,
            btnCallBack, btnEmail, btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 1.2 inisialisasi dengan id
        btnMove = findViewById(R.id.btn_move);
        btnCall = findViewById(R.id.btn_call);
        btnCallBack = findViewById(R.id.btn_call_back);
        btnEmail = findViewById(R.id.btn_email);
        btnPassingData = findViewById(R.id.btn_passing_data);
        btnPassingObject = findViewById(R.id.btn_passing_object);

        //TODO 1.3 event click listener
        btnMove.setOnClickListener(this);
        btnPassingObject.setOnClickListener(this);
        btnPassingData.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnCallBack.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move:
                move();
                break;
            case R.id.btn_call:
                implicitCall();
                break;
            case R.id.btn_call_back:
                callBack();
                break;
            case R.id.btn_email:
                implicitEmail();
                break;
            case R.id.btn_passing_data:
                passData();
                break;
            case R.id.btn_passing_object:
                passObject();
                break;
        }       
    }

    //TODO 6.1 intent implicit email
    private void implicitEmail() {
        Intent email = new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto",
                        "romydho@gmail.com",
                        null));
        email.putExtra(Intent.EXTRA_SUBJECT, "ini subject");
        email.putExtra(Intent.EXTRA_TEXT, "ini body message");

        if (email.resolveActivity(getPackageManager()) != null){
            startActivity(Intent.createChooser(email, "Pilih share client"));
        }else{
            Toast.makeText(this,
                    "Tidak ada share client", Toast.LENGTH_SHORT).show();
        }

    }

    //TODO 5.1 intent implicitCall
    private void implicitCall() {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:081807365101"));
        startActivity(call);
    }

    private void callBack() {
        Intent callBack = new Intent(MainActivity.this, CallBack.class);
        startActivityForResult(callBack, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String tampung = getIntent().getStringExtra(CallBack.EXTRA_DATA);
                Toast.makeText(this, tampung, Toast.LENGTH_LONG).show();
            }
        }
    }

    //TODO 3.3 buat intent/ kirim data
    private void passObject() {
        Intent passObj = new Intent(MainActivity.this, PassingObject.class);
        /**
         * instance class "orang"
         * atau buat object dari class orang
         */
        Orang objectOrang = new Orang();
        objectOrang.setName("Romy");
        objectOrang.setAge(25);
        objectOrang.setAsal("Batu Ceper");
        objectOrang.setTinggal("Ciledug");
        objectOrang.setJob("programmer");

        passObj.putExtra(PassingObject.EXTRA_OBJ, objectOrang);

        startActivity(passObj);
    }

    //TODO 2.3 kirim datanya
    private void passData() {
        Intent passData = new Intent(MainActivity.this, PassingData.class);

        /**
         * intent put extra
         * param 1 key sebagai penampung data (ambil dari class yg dituju)
         * param 2 value data yg dikirim ke class yg dituju (dapat berupa type apa saja)
         */

        passData.putExtra(PassingData.KEY_NAME, "Romy");
        passData.putExtra(PassingData.KEY_AGE, 25);

        startActivity(passData);
    }

    private void move(){
        //TODO 1.4 intent to move activity
                /**
                 * param 1 diisi dengan class asal
                 * param 2 diisi dengan class tujuan
                 */
                Intent move = new Intent(MainActivity.this, Move.class);
                startActivity(move);
    }
}

//TODO 3 event click listener
//        btnMove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //TODO 4 intent to move activity
//                /**
//                 * param 1 diisi dengan class asal
//                 * param 2 diisi dengan class tujuan
//                 */
//                Intent move = new Intent(MainActivity.this, Move.class);
//                startActivity(move);
//            }
//        });
