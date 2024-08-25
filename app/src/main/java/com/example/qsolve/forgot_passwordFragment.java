package com.example.qsolve;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class forgot_passwordFragment extends Fragment {

    ImageView forgot_back;

    Button reset_button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);

        forgot_back = view.findViewById(R.id.forgot_back);
        reset_button = view.findViewById(R.id.reset_button);

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new verification_Fragment());
            }
        });

        forgot_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignupActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.forgot_framelayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}