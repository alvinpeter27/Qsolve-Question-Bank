package com.example.qsolve;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class continue_login_Fragment extends Fragment {

    Button btn_continue_login;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_continue_login_, container, false);

      btn_continue_login=view.findViewById(R.id.btn_continue_login);
        btn_continue_login.setOnClickListener(v -> {
            // Navigate to SignUpActivity
            Intent intent = new Intent(getActivity(), SignupActivity.class);
            startActivity(intent);
        });
      return  view;
    }
}