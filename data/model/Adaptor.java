package com.example.dremobil.data.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dremobil.R;
import com.example.dremobil.Service;
import com.example.dremobil.data.Produs;

import java.util.List;

public class Adaptor extends RecyclerView.Adapter<Adaptor.MineHolder> {

    Context mContext;
    List<Service> mData;
    private OnServiceClickListener mOnServiceClickListener;

    public Adaptor(Context mContext, List<Service> mData, OnServiceClickListener onServiceClickListener)
    {
        this.mContext = mContext;
        this.mData = mData;
        this.mOnServiceClickListener = onServiceClickListener;
    }


    @NonNull
    @Override
    public MineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf = LayoutInflater.from(mContext);

        View view =  inf.inflate(R.layout.fragment_service,parent,false);
        MineHolder mine = new MineHolder(view,mOnServiceClickListener);
        return mine;
    }

    @Override
    public void onBindViewHolder(@NonNull MineHolder holder, int position) {

        holder.nume_service.setText(mData.get(position).getNume());
        holder.detalii_service.setText(mData.get(position).getDetalii());
        holder.adresa.setText(mData.get(position).getAdresa());
        holder.telefon.setText(mData.get(position).getTelefon());
        holder.img.setImageResource(mData.get(position).getImg());
    }

    @Override
    public int getItemCount() {
       return mData.size();
    }

    public static class MineHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nume_service;
        private ImageView img;
        private TextView detalii_service;
        private TextView adresa;
        private TextView telefon;
        OnServiceClickListener onServiceClickListener;


        public MineHolder(@NonNull View itemView, OnServiceClickListener onServiceClickListener) {
            super(itemView);

            nume_service = (TextView) itemView.findViewById(R.id.nume_service);
            img = (ImageView) itemView.findViewById(R.id.image_item_service);
            adresa = (TextView) itemView.findViewById(R.id.adresa_service);
            telefon = (TextView) itemView.findViewById(R.id.service_telefon);
            detalii_service = (TextView) itemView.findViewById(R.id.detalii_service);
            this.onServiceClickListener = onServiceClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onServiceClickListener.onServiceClick(getAdapterPosition());
        }
    }
    public interface OnServiceClickListener
    {
        void onServiceClick(int position);
    }


}
