package com.example.dremobil.ui.cautare_marca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dremobil.R;
import com.example.dremobil.data.Produs;
import com.example.dremobil.data.model.RecyclerViewAdaptor;

import java.util.ArrayList;
import java.util.List;

import static android.widget.ArrayAdapter.*;

public class FourthFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private CautareMarcaViewModel cautareMarcaViewModel;
    private RecyclerView myRecyclerView;
    private List<Produs> lstProdus = new ArrayList<>();
    public String spinnerName = "";
    private boolean zero = false;
    public boolean unu = false;
    private boolean doi = false;
    private boolean trei = false;

    public FourthFragment() {

    }


    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        cautareMarcaViewModel = ViewModelProviders.of(this).get(CautareMarcaViewModel.class);

        View root = inflater.inflate(R.layout.fragment_cautare_marca, container, false);
        final TextView textView = root.findViewById(R.id.home);

        Spinner spinner = root.findViewById(R.id.spinner_marca);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.SpinnerItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        myRecyclerView = (RecyclerView) root.findViewById(R.id.lista_cautare_piese);
        RecyclerViewAdaptor recyclerViewAdaptor = new RecyclerViewAdaptor(getContext(), lstProdus);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdaptor);


        cautareMarcaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);



            }
        });
        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerName = parent.getItemAtPosition(position).toString();
        if(position == 1) {
            SecondFragment fragm = new SecondFragment();
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().add(R.id.nav_host_fragment, fragm).commit();
        }
        else if(position == 2)
        {
            ThirdFragment fragm = new ThirdFragment();
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().add(R.id.nav_host_fragment, fragm).commit();
        }
        else if(position == 3)
        {
            FourthFragment fragm = new FourthFragment();
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().add(R.id.nav_host_fragment, fragm).commit();
        }
        else if(position == 4){
            FifthFragment fragm = new FifthFragment();
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().add(R.id.nav_host_fragment, fragm).commit();
        }
        else if(position == 5){
            CautareMarcaFragment fragm = new CautareMarcaFragment();
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().add(R.id.nav_host_fragment,fragm).commit();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstProdus.add(new Produs("Cutie viteza Mercedes Sprinter", "in stoc", "2600lei",
                "Cutie de viteze Sprinter 6+1 manuala", R.drawable.cutie_viteza_mercedes_sprinter));


    }


}
