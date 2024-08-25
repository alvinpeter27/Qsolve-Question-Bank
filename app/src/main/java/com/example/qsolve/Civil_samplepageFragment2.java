package com.example.qsolve;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class Civil_samplepageFragment2 extends Fragment implements Civil_Sample_Adapter.OnItemClickListener {

    ImageView civil_back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_civil_samplepage2, container, false);


        civil_back = view.findViewById(R.id.civil_back);
        civil_back.setOnClickListener(new View.OnClickListener() {   //back button press go home fragment
            @Override
            public void onClick(View v) {
                loadFragment(new HomeFragment());

            }
        });

        RecyclerView recyclerView=view.findViewById(R.id.civil_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<civil_samplePage_item> civilSamplePageItems= new ArrayList<>();
        civilSamplePageItems.add(new civil_samplePage_item(01, "Probability Distributions, Transforms and Numerical Methods"));
        civilSamplePageItems.add(new civil_samplePage_item(02, "Business Economics"));
        civilSamplePageItems.add(new civil_samplePage_item(03, "Life Skills"));
        civilSamplePageItems.add(new civil_samplePage_item(04, "Advanced Mechanics of Solids"));
        civilSamplePageItems.add(new civil_samplePage_item(05, "Thermal Engineering"));
        civilSamplePageItems.add(new civil_samplePage_item(06, "Fluid Machinery"));
        civilSamplePageItems.add(new civil_samplePage_item(07,"Manufacturing Technoogy"));

        Civil_Sample_Adapter adapter = new Civil_Sample_Adapter(civilSamplePageItems,this);
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onItemClick(int position) {

        loadFragment(new Pdf_Fragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}