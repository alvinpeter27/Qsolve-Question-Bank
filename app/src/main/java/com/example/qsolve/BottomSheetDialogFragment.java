package com.example.qsolve;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomSheetDialogFragment extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_syllabus_bottom, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogTheme);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.mechanicalengineering).setOnClickListener(v -> {
            navigateToHomeFragment();
        });

        view.findViewById(R.id.civilengineering).setOnClickListener(v -> {
            navigateToHomeFragment();
        });

        view.findViewById(R.id.computerscience_engineering).setOnClickListener(v -> {
            navigateToHomeFragment();
        });
    }

    private void navigateToHomeFragment() {
        // This will pop the back stack and remove the BottomSheetDialogFragment
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.popBackStack();
        dismiss();
    }
}
