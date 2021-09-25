package com.example.blockid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import net.glxn.qrgen.android.QRCode;


import java.util.Hashtable;


public class qr_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_view);
        Intent intent = getIntent();
        String url = intent.getStringExtra(Home.ID);
        Bitmap bitmap = QRCode.from(url).bitmap();
        ImageView imagenCodigo = findViewById(R.id.QR);
        imagenCodigo.setImageBitmap(bitmap);

        Button volver = (Button) findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


