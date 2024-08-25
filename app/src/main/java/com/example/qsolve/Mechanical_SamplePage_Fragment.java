package com.example.qsolve;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Mechanical_SamplePage_Fragment extends Fragment implements Mechanical_Sample_Adapter.OnItemClickListener {

    ImageView mechanical_back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mechanical__samplepage, container, false);

        mechanical_back = view.findViewById(R.id.mechanical_back);
        mechanical_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new HomeFragment());
            }
        });

        // Handle the physical back button press
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                loadFragment(new HomeFragment());
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.mechanical_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<mechanical_sample_item> mechanicalSampleItems = new ArrayList<>();
        mechanicalSampleItems.add(new mechanical_sample_item(01, "Probability Distributions, Transforms and Numerical Methods"));
        mechanicalSampleItems.add(new mechanical_sample_item(02, "Business Economics"));
        mechanicalSampleItems.add(new mechanical_sample_item(03, "Life Skills"));
        mechanicalSampleItems.add(new mechanical_sample_item(04, "Advanced Mechanics of Solids"));
        mechanicalSampleItems.add(new mechanical_sample_item(05, "Thermal Engineering"));
        mechanicalSampleItems.add(new mechanical_sample_item(06, "Fluid Machinery"));
        mechanicalSampleItems.add(new mechanical_sample_item(07, "Manufacturing Technology"));

        Mechanical_Sample_Adapter adapter = new Mechanical_Sample_Adapter(mechanicalSampleItems, this);
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
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
