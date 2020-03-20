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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dremobil.R;
import com.example.dremobil.ui.cautare_marca.SecondFragment;

public class CreareContFragment extends Fragment {
    private CreareContViewModel creareContViewModel;
    private EditText textViewNume;
    private EditText textViewPrenume;
    private EditText textViewAdresa;
    private EditText textViewTelefon;
    private EditText textViewIban;
    private Button buttonCreareCont;
    private CreareContListener listener;

    public interface CreareContListener {
        void onInputCreareContSent(String inputNume, String inputPrenume, String inputAdresa, String inputTelefon,
                                   String inputIban);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        creareContViewModel =
                ViewModelProviders.of(this).get(CreareContViewModel.class);
        View root = inflater.inflate(R.layout.fragment_creare_con, container, false);
        final TextView textView = root.findViewById(R.id.cont_nume);

        textViewNume = root.findViewById(R.id.cont_nume_edittext);
        textViewAdresa = root.findViewById(R.id.cont_AdresaEditText);
        textViewIban = root.findViewById(R.id.cont_IbanEditText);
        textViewPrenume = root.findViewById(R.id.cont_prenumeEditText);
        textViewTelefon = root.findViewById(R.id.cont_TelefonEditText);
        buttonCreareCont = root.findViewById(R.id.cont_creareCont);

        buttonCreareCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputNume = textViewNume.getText().toString();
                String inputPrenume = textViewPrenume.getText().toString();
                String inputAdresa = textViewAdresa.getText().toString();
                String inputTelefon = textViewTelefon.getText().toString();
                String inputIban = textViewIban.getText().toString();


            }
        });

        return root;
    }

    public void updateEditText(String newNume, String newPrenume, String newAdresa,
                               String newTelefon, String newIban) {
        textViewNume.setText(newNume);
        textViewPrenume.setText(newPrenume);
        textViewTelefon.setText(newTelefon);
        textViewAdresa.setText(newAdresa);
        textViewIban.setText(newIban);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CreareContListener) {
            listener = (CreareContListener) context;

        } else {
            throw new RuntimeException(context.toString() +
                    "must implement CreareContListener");
        }
    }

}
