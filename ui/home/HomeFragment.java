package com.example.dremobil.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dremobil.PieseAdaptor;
import com.example.dremobil.R;
import com.example.dremobil.data.Produs;
import com.example.dremobil.data.model.RecyclerViewAdaptor;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.vision.text.Line;
import com.google.android.gms.vision.text.Text;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView myRecyclerView;
    private List<Produs> lstProdus;
    private View root;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference produsRef = db.collection("Produs");


    public HomeFragment()
    {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       homeViewModel =
               ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        myRecyclerView = (RecyclerView) root.findViewById(R.id.lista_home);
       RecyclerViewAdaptor recyclerViewAdaptor = new RecyclerViewAdaptor(getContext(),lstProdus);
       myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       myRecyclerView.setAdapter(recyclerViewAdaptor);

        final TextView textView = root.findViewById(R.id.home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstProdus = new ArrayList<>();
        /*FirestoreRecyclerOptions<Produs> options = new FirestoreRecyclerOptions.Builder<Produs>()
                .setQuery(produsRef, Produs.class)
                .build();


        FirestoreRecyclerAdapter<Produs,ProdusViewHolder> adapter = new FirestoreRecyclerAdapter<Produs, ProdusViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final ProdusViewHolder produsViewHolder, int i, @NonNull final Produs produs) {

                produsViewHolder.textViewNume.setText(produs.getNume());
                produsViewHolder.textViewPret.setText(produs.getPret());
                produsViewHolder.textViewDetalii.setText(produs.getDetalii());
                produsViewHolder.textViewCantitate.setText(produs.getCantitate());

                produsRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult())
                            {
                                String nume = document.get("nume").toString();
                                String detalii = document.get("detalii").toString();
                                String cantitate = document.get("cantitate").toString();
                                String pret = document.get("pret").toString();
                                lstProdus.add(new Produs(nume,cantitate,pret,detalii,R.drawable.car));
                                produsViewHolder.textViewNume.setText(nume);
                                produsViewHolder.textViewPret.setText(pret);
                                produsViewHolder.textViewDetalii.setText(detalii);
                                produsViewHolder.textViewCantitate.setText(cantitate);
                                produsViewHolder.imageView.setImageResource(R.drawable.car);
                            }
                        }
                    }
                });

            }



            @NonNull
            @Override
            public ProdusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_home,parent,false);
                ProdusViewHolder viewHolder = new ProdusViewHolder(v);
                return viewHolder;

            }
        };
*/





        //aici ar trebui un adaptor la clasa ProdusAdaptor pe care nu o am..
        //stai sa ma gandesc daca nu pot face o clasa de care sa o leg de asta totusi
        //daca nu merge fara o sa incerc si asa

        //chestiile de la recyclerView sunt mai sus






        lstProdus.add(new Produs("Filtru de aer Mann-Filter","in stoc","100 lei",
                "cu filtru aditional pentru aerisire carcasa arbore cotit",R.drawable.filtru_aer1));

        lstProdus.add(new Produs("Filtru de aer conic universal","in stoc","150 lei","intrare 75mm",R.drawable.filtru_aer2));
        lstProdus.add(new Produs("Placute de frana", "in stoc","25 lei",
                "frana disc exclus indicator avertizare",R.drawable.placute_frana1));
        lstProdus.add(new Produs("Placute de frana", "in stoc","35 lei",
                "frana disc pentru indicator avertizare",R.drawable.placute_frana2));
        lstProdus.add(new Produs("Chit ambreiaj", "in stoc","330 lei",
                "producator Luk Germania placa disc rulment",R.drawable.chit_ambreiaj1));
        lstProdus.add(new Produs("Chit ambreiaj Audi", "in stoc","1200 lei",
                "producator Sachs Germania placa disc rulment",R.drawable.chit_ambreiaj2));
        lstProdus.add(new Produs("Ulei motor Castrol", "in stoc","124 lei",
                "producator Castrol Edge 5W-30",R.drawable.ulei));
        lstProdus.add(new Produs("Ulei motor Mobil1", "in stoc","99 lei",
                "producator Mobil1 5W-30",R.drawable.ulei2));
        lstProdus.add(new Produs("Far Audi a4 B8", "in stoc","1450 lei",
                "Far Audi A4 B8 stanga",R.drawable.far_audia4b8));
        lstProdus.add(new Produs("Motor Audi A4 B8","in stoc","5500 lei",
                "Motor Audi A4 2.0Tdi",R.drawable.motor_audi_b8));
        lstProdus.add(new Produs("Motor Ford Focus 1.8","in stoc","3400 lei",
                "Motor Ford Focus 1.8TDi",R.drawable.motor_ford_focus18));
        lstProdus.add(new Produs("Cutie viteza Mercedes Sprinter","in stoc","2600lei",
                "Cutie de viteze Sprinter 6+1 manuala",R.drawable.cutie_viteza_mercedes_sprinter));
        lstProdus.add(new Produs("Cutie viteza Open Insignia","in stoc","1800 lei",
                "Cutie de viteze Insignia 5+1",R.drawable.cutie_vit_insignia));


    }


/*
    public class ProdusViewHolder extends RecyclerView.ViewHolder{

        TextView textViewNume;
        TextView textViewDetalii;
        TextView textViewPret;
        TextView textViewCantitate;
        ImageView imageView;

         public ProdusViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCantitate = itemView.findViewById(R.id.cantitate_produs);
            textViewDetalii = itemView.findViewById(R.id.detalii_produs);
            textViewNume = itemView.findViewById(R.id.nume_produs);
            textViewPret = itemView.findViewById(R.id.pret_produs);
            imageView = itemView.findViewById(R.id.image_item_home);


        }
    }*/
}