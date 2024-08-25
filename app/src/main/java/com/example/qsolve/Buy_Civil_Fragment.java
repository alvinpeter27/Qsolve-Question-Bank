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

public class Buy_Civil_Fragment extends Fragment implements Buy_civil_Adapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private Buy_civil_Adapter adapter;
    private List<Buy_civil_courses> courseList;

    private ImageView buy_civil_back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy__civil_, container, false);

        recyclerView = view.findViewById(R.id.buy_Civil_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        buy_civil_back=view.findViewById(R.id.buy_civil_back);

        buy_civil_back.setOnClickListener(v -> loadFragment(new HomeFragment()));

        courseList = new ArrayList<>();
        courseList.add(new Buy_civil_courses("01", "Probability Distributions, Transforms and Numerical Methods", true));
        courseList.add(new Buy_civil_courses("02", "Business Economics", false));
        courseList.add(new Buy_civil_courses("03", "Life Skills", true));
        courseList.add(new Buy_civil_courses("04", "Advanced Mechanics of Solids", false));
        courseList.add(new Buy_civil_courses("05", "Thermal Engineering", false));
        courseList.add(new Buy_civil_courses("06", "Fluid Machinery", false));
        courseList.add(new Buy_civil_courses("07", "Manufacturing Technology", false));
        // Add more courses as needed

        adapter = new Buy_civil_Adapter(courseList, this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(Buy_civil_courses item) {
        openPdfFragment(item);
    }

    private void openPdfFragment(Buy_civil_courses item) {
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
