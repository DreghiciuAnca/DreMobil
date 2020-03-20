package com.example.dremobil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dremobil.data.Produs;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PieseAdaptor extends FirestoreRecyclerAdapter<Produs,PieseAdaptor.PieseHolder > {


    public PieseAdaptor(@NonNull FirestoreRecyclerOptions<Produs> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PieseHolder pieseHolder, int i, @NonNull Produs produs) {
        pieseHolder.textViewNume.setText(produs.getNume());
        pieseHolder.textViewPret.setText(produs.getPret());
        pieseHolder.textViewDetalii.setText(produs.getDetalii());
        pieseHolder.textViewCantitate.setText(produs.getCantitate());
    }

    @NonNull
    @Override
    public PieseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_home,parent,false);

        return new PieseHolder(v);
    }

    class PieseHolder extends RecyclerView.ViewHolder{
        TextView textViewNume;
        TextView textViewDetalii;
        TextView textViewCantitate;
        TextView textViewPret;

        public PieseHolder(@NonNull View itemView) {
            super(itemView);
            textViewCantitate = itemView.findViewById(R.id.cantitate_produs);
            textViewDetalii = itemView.findViewById(R.id.detalii_produs);
            textViewPret = itemView.findViewById(R.id.pret_produs);
            textViewNume = itemView.findViewById(R.id.nume_produs);
        }
    }
}
