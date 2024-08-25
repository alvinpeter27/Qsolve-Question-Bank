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

public class Buy_Mechanical_Fragment extends Fragment {


    private RecyclerView recyclerView;
    private buy_mech_adapter adapter;
    private List<Buy_course_item> courseList;

    private ImageView buy_mech_back;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_buy__mechanical_, container, false);

        buy_mech_back = view.findViewById(R.id.buy_mech_back);
        buy_mech_back.setOnClickListener(v -> loadFragment(new HomeFragment()));

        recyclerView = view.findViewById(R.id.buy_Mechanical_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        courseList = new ArrayList<>();
        courseList.add(new Buy_course_item("01", "Probability Distributions, Transforms and Numerical Methods", true));
        courseList.add(new Buy_course_item("02", "Business Economics", false));
        courseList.add(new Buy_course_item("03", "Life Skills", true));
        courseList.add(new Buy_course_item("04", "Advanced Mechanics of Solids", false));
        courseList.add(new Buy_course_item("05", "Thermal Engineering", false));
        courseList.add(new Buy_course_item("06", "Fluid Machinery", false));
        courseList.add(new Buy_course_item("07", "Manufacturing Technology", false));

        adapter = new buy_mech_adapter(getContext(), courseList, new buy_mech_adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Buy_course_item item) {
                openPdfFragment(item);
            }
        });

        recyclerView.setAdapter(adapter);

        return view;
    }

    private void openPdfFragment(Buy_course_item item) {
        Pdf_Fragment pdfFragment = new Pdf_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("courseName", item.getName());  // Pass any required data to the Pdf_Fragment
        pdfFragment.setArguments(bundle);
        loadFragment(pdfFragment);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}