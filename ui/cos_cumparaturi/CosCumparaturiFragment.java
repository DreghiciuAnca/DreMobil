package com.example.dremobil.ui.cos_cumparaturi;

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

import com.example.dremobil.R;

public class CosCumparaturiFragment extends Fragment {

    private CosCumparaturiViewModel cosCumparaturiViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cosCumparaturiViewModel =
                ViewModelProviders.of(this).get(CosCumparaturiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cos_cumparaturi, container, false);
        final TextView textView = root.findViewById(R.id.cos_cumparaturi);
        cosCumparaturiViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
