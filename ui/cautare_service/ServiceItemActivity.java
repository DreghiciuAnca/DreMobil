package com.example.dremobil.ui.cautare_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dremobil.R;

import org.w3c.dom.Text;

import java.io.Serializable;

public class ServiceItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_item);

        Intent intent = getIntent();
        String nume = intent.getStringExtra("nume");
        String detalii = intent.getStringExtra("detalii");
        String adresa = intent.getStringExtra("adresa");
        String telefon = intent.getStringExtra("telefon");


        TextView num = findViewById(R.id.nume_service_item);
        TextView det =findViewById(R.id.detalii_service_item);
        TextView adr = findViewById(R.id.adresa_service_item);
        TextView tel = findViewById(R.id.telefon_service_item);
        ImageView imag = findViewById(R.id.image_item_service);

        num.setText(nume);
        det.setText(detalii);
        adr.setText(adresa);
        tel.setText(telefon);

    }
}
