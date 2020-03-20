package com.example.dremobil.ui.cautare_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dremobil.MapsActivity;
import com.example.dremobil.R;
import com.example.dremobil.ui.cautare_marca.FifthFragment;

import java.util.zip.Inflater;

public class CautareServiceFragment extends Fragment {
    private CautareServiceViewModel cautareServiceViewModel;

    private Button buttonLocatie;
    private Button buttonMasina;
    private Button buttonService;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cautareServiceViewModel =
                ViewModelProviders.of(this).get(CautareServiceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cautare_service, container, false);
        final TextView textView = root.findViewById(R.id.home);

        buttonMasina = root.findViewById(R.id.buton_adaugaMasina);
        buttonLocatie = root.findViewById(R.id.buton_locatie);
        buttonService = root.findViewById(R.id.buton_alegeService);

        buttonLocatie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),MapsActivity.class);
                startActivity(in);
            }
        });

        buttonMasina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent in = new Intent(getActivity(),MasinaActivity.class);
               startActivity(in);

            }
        });

        buttonService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent in = new Intent(getContext(), ServiceActivity.class);
               startActivity(in);
            }
        });


        cautareServiceViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
