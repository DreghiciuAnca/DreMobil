package com.example.dremobil.ui.cautare_service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dremobil.R;
import com.example.dremobil.Service;
import com.example.dremobil.data.Produs;
import com.example.dremobil.data.model.Adaptor;
import com.example.dremobil.data.model.RecyclerViewAdaptor;

import java.util.ArrayList;
import java.util.List;

public class ServiceActivity extends AppCompatActivity implements Adaptor.OnServiceClickListener {

    RecyclerView recyclerView;

    private List<Service> lstService = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);


        lstService.add(new Service("Service Komplet","reparatii autovehicule diesel si benzina"," Cluj Napoca, str Calea Turzii nr160",
                "0753709920",R.drawable.service1));
        lstService.add(new Service("MediaValex","reprezentanta Bosch, vulcanizare, service","Alba Iulia, Calea Motilor 24",
                "0741042184",R.drawable.mediavalex_service));
        lstService.add(new Service("Toplac","service, vulcanizare, itp","Sebes, str.Dorobantilor nr 145",
                "0747120878",R.drawable.toplac_service));
        lstService.add(new Service("Timas","reparatii autovehicule mici sub 3T","Sibiu, str. Aurel Vlaicu nr 86",
                "0753042383",R.drawable.timas_service));

        recyclerView = (RecyclerView) findViewById(R.id.lista_service);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new Adaptor(this,lstService, this));


    }

    @Override
    public void onServiceClick(int position) {
        lstService.get(position);
        Intent intent = new Intent(this, ServiceItemActivity.class);
        Service nou = lstService.get(position);
        intent.putExtra("nume",nou.getNume());
        intent.putExtra("detalii",nou.getDetalii());
        intent.putExtra("adresa",nou.getAdresa());
        intent.putExtra("telefon",nou.getTelefon());
        intent.putExtra("img",nou.getImg());
        startActivity(intent);
    }
}

