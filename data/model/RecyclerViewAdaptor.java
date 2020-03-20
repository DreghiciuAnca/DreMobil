package com.example.dremobil.data.model;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dremobil.R;
import com.example.dremobil.data.Produs;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.MyHolder>{

    Context mContext;
    List<Produs> mData;


    public RecyclerViewAdaptor(Context mContext, List<Produs> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.item_list_home,parent,false);

        MyHolder vHolder = new MyHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.nume_produs.setText(mData.get(position).getNume());
        holder.detalii_produs.setText(mData.get(position).getDetalii());
        holder.cantitate.setText(mData.get(position).getCantitate());
        holder.pret.setText(mData.get(position).getPret());
        holder.imageView.setImageResource(mData.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{


        private TextView nume_produs;
        private ImageView imageView;
        private TextView detalii_produs;
        private TextView cantitate;
        private TextView pret;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            nume_produs = (TextView) itemView.findViewById(R.id.nume_produs);
            imageView = (ImageView) itemView.findViewById(R.id.image_item_home);
            cantitate = (TextView) itemView.findViewById(R.id.cantitate_produs);
            pret = (TextView) itemView.findViewById(R.id.pret_produs);
            detalii_produs = (TextView) itemView.findViewById(R.id.detalii_produs);

        }
    }
}
