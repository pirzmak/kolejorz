package com.example.chciabymbyckolejarzem;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = (Button) view.findViewById(R.id.jeden_button);
        button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_jedenFragment));
        Button button2 = (Button) view.findViewById(R.id.dwa_button);
        button2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_dwaFragment));
    }
}
