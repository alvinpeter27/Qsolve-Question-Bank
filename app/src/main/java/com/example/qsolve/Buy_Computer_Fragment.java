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

public class Buy_Computer_Fragment extends Fragment implements Buy_Computer_Adapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private Buy_Computer_Adapter adapter;
    private List<Buy_Computer_courses> courseList;

    private ImageView buy_computer_back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy__compter, container, false);

        recyclerView = view.findViewById(R.id.buy_Computer_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        buy_computer_back = view.findViewById(R.id.buy_computer_back);

        buy_computer_back.setOnClickListener(v -> loadFragment(new HomeFragment()));

        courseList = new ArrayList<>();
        courseList.add(new Buy_Computer_courses("01", "Computer Organization and Architecture", true));
        courseList.add(new Buy_Computer_courses("02", "Operating Systems", false));
        courseList.add(new Buy_Computer_courses("03", "Data Structures and Algorithms", true));
        courseList.add(new Buy_Computer_courses("04", "Database Management Systems", false));
        courseList.add(new Buy_Computer_courses("05", "Computer Networks", false));
        courseList.add(new Buy_Computer_courses("06", "Software Engineering", false));
        courseList.add(new Buy_Computer_courses("07", "Manufacturing Technology", false));
        // Add more courses as needed

        adapter = new Buy_Computer_Adapter(courseList, this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(Buy_Computer_courses item) {
        openPdfFragment(item);
    }

    private void openPdfFragment(Buy_Computer_courses item) {
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
