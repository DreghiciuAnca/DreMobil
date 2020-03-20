package com.example.dremobil.ui.detalii_cont;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dremobil.R;

public class ContFragment extends Fragment {
    private ContViewModel contViewModel;
    private EditText textViewNume;
    private EditText textViewPrenume;
    private EditText textViewAdresa;
    private EditText textViewTelefon;
    private EditText textViewIban;
    private Button buttonCont;
    private ContListener listener;

    public interface ContListener{
        void onInputContSent(String inputNume, String inputPrenume, String inputAdresa, String inputTelefon,
                             String inputIban);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        contViewModel =
                ViewModelProviders.of(this).get(ContViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cont, container, false);
        final TextView textView = root.findViewById(R.id.profil_nume);

        textViewNume = root.findViewById(R.id.profil_nume_edittext);
        textViewAdresa =root.findViewById(R.id.profil_AdresaEditText);
        textViewIban = root.findViewById(R.id.profil_IbanEditText);
        textViewPrenume = root.findViewById(R.id.profil_prenumeEditText);
        textViewTelefon = root.findViewById(R.id.profil_TelefonEditText);
        buttonCont = root.findViewById(R.id.profil_salvareModificari);


        buttonCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputNume = textViewNume.getText().toString();
                String inputPrenume = textViewPrenume.getText().toString();
                String inputAdresa = textViewAdresa.getText().toString();
                String inputTelefon = textViewTelefon.getText().toString();
                String inputIban = textViewIban.getText().toString();

            }
        });



        contViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    public void updateEditText(String newNume, String newPrenume, String newAdresa,
                               String newTelefon, String newIban)
    {
        textViewNume.setText(newNume);
        textViewPrenume.setText(newPrenume);
        textViewTelefon.setText(newTelefon);
        textViewAdresa.setText(newAdresa);
        textViewIban.setText(newIban);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if( context instanceof ContListener)
        {
            listener = (ContListener) context;
        }
        else{
            throw new RuntimeException(context.toString()+
                    "must implement ContListener");
        }
    }


}
