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


public class Computer_samplePage_Fragment extends Fragment implements Computer_Sample_Adapter.OnItemClickListener{


    ImageView computer_back;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_computer_sample_page_, container, false);

        computer_back = view.findViewById(R.id.computer_back);
        computer_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new HomeFragment());
            }
        });

        RecyclerView recyclerView=view.findViewById(R.id.computer_science_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<computer_samplePage_item> computerSamplePageItems = new ArrayList<>();
        computerSamplePageItems.add(new computer_samplePage_item(01, "Probability Distributions, Transforms and Numerical Methods"));
        computerSamplePageItems.add(new computer_samplePage_item(02, "Business Economics"));
        computerSamplePageItems.add(new computer_samplePage_item(03, "Life Skills"));
        computerSamplePageItems.add(new computer_samplePage_item(04, "Advanced Mechanics of Solids"));
        computerSamplePageItems.add(new computer_samplePage_item(05, "Thermal Engineering"));
        computerSamplePageItems.add(new computer_samplePage_item(06, "Fluid Machinery"));
        computerSamplePageItems.add(new computer_samplePage_item(07, "Manufacturing Technology"));

        Computer_Sample_Adapter adapter = new Computer_Sample_Adapter(computerSamplePageItems,this);
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