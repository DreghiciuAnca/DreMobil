package com.example.dremobil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.dremobil.data.Produs;
import com.example.dremobil.ui.detalii_cont.ContFragment;
import com.example.dremobil.ui.detalii_cont.CreareContFragment;
import com.example.dremobil.ui.piese.PieseFragment;
//import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
//import com.google.firebase.firestore.CollectionReference;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.Query;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;


public class MeniuActivity extends AppCompatActivity implements CreareContFragment.CreareContListener, ContFragment.ContListener {

    private AppBarConfiguration mAppBarConfiguration;
    private FirebaseAuth auth;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference produsRef = db.collection("Produs");
    private CollectionReference serviceRef = db.collection("Service");
    private CollectionReference masinaRef = db.collection("Masina");
    private CollectionReference user = db.collection("User");
    private PieseAdaptor adaptor;


    private ContFragment contfr;
    private CreareContFragment creareContFr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();


        FirebaseAuth var10001 = FirebaseAuth.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(var10001, "FirebaseAuth.getInstance()");
        this.auth = var10001;
        FirebaseAuth var10000 = this.auth;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
        }

        if (var10000.getCurrentUser() == null) {
            Intent intent = new Intent((Context)this, LoginActivity.class);
            this.startActivity(intent);
            this.finish();
        } else {
            Toast.makeText((Context)this, (CharSequence)"Welcome", Toast.LENGTH_SHORT ).show();
        }

        setContentView(R.layout.activity_meniu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        //Configurare cu ajutorul builder-ului fiecare activitate de fragment
        //Clasa R stocheaza automat fiecare layout de interfata a proiectului cu fiecare componenta
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_piese_auto, R.id.nav_cautare_marca, R.id.nav_cautare_service,
                R.id.nav_cos_cumparaturi, R.id.nav_profil, R.id.nav_creare_cont, R.id.nav_login, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();

        //se porneste activitatea meniului principal
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        creareContFr = new CreareContFragment();
        contfr = new ContFragment();


        //setUpRecyclerView();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.meniu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onInputContSent(String inputNume, String inputPrenume, String inputAdresa, String inputTelefon, String inputIban) {
        contfr.updateEditText(inputNume,inputPrenume,inputAdresa,inputTelefon,inputIban);
    }

    @Override
    public void onInputCreareContSent(String inputNume, String inputPrenume, String inputAdresa, String inputTelefon, String inputIban) {
        creareContFr.updateEditText(inputNume,inputPrenume,inputAdresa,inputTelefon,inputIban);
    }



    private void setUpRecyclerView()
    {
        Query query = produsRef.orderBy("nume",Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Produs> options = new FirestoreRecyclerOptions.Builder<Produs>()
                .setQuery(query, Produs.class)
                .build();

        adaptor = new PieseAdaptor(options);
        RecyclerView recyclerView = findViewById(R.id.lista_home);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);
    }

    @Override
    public void onStart() {
        super.onStart();
        adaptor.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adaptor.stopListening();
    }
}

