package com.example.dremobil.ui.piese;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dremobil.R;
import com.example.dremobil.data.Produs;
import com.example.dremobil.data.model.RecyclerViewAdaptor;

import java.util.ArrayList;
import java.util.List;

public class PieseFragment extends Fragment {
    private PieseViewModel pieseViewModel;
    private RecyclerView myRecyclerView;
    private List<Produs> lstProdus;
    public PieseFragment()
    {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        pieseViewModel = ViewModelProviders.of(this).get(PieseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_piese,container,false);
        final TextView textView = root.findViewById(R.id.home);

        myRecyclerView = (RecyclerView) root.findViewById(R.id.lista_piese);
        RecyclerViewAdaptor recyclerViewAdaptor = new RecyclerViewAdaptor(getContext(),lstProdus);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdaptor);



        pieseViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);


            }
        });
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstProdus = new ArrayList<>();
        lstProdus.add(new Produs("Motor Audi A4 B8","in stoc","5500 lei",
                "Motor Audi A4 2.0Tdi",R.drawable.motor_audi_b8));
        lstProdus.add(new Produs("Motor Ford Focus 1.8","in stoc","3400 lei",
                "Motor Ford Focus 1.8TDi",R.drawable.motor_ford_focus18));
        lstProdus.add(new Produs("Cutie viteza Mercedes Sprinter","in stoc","2600lei",
                "Cutie de viteze Sprinter 6+1 manuala",R.drawable.cutie_viteza_mercedes_sprinter));
        lstProdus.add(new Produs("Cutie viteza Open Insignia","in stoc","1800 lei",
                "Cutie de viteze Insignia 5+1",R.drawable.cutie_vit_insignia));


    }
}
