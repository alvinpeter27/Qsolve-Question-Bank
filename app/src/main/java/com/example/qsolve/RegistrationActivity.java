package com.example.qsolve;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationActivity extends AppCompatActivity {

    ImageView backicon;

    Spinner spinnerCollege;

    Spinner spinnerDepartment;

    Button register;

    TextView loginTextView;

    EditText firstNameEditText, lastNameEditText, emailEditText, mobileEditText, passwordEditText;


    CheckBox acceptBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);


        backicon = (ImageView) findViewById(R.id.back_icon);
        spinnerDepartment = (Spinner) findViewById(R.id.spinnerDepartment);
        loginTextView = findViewById(R.id.register_login);
        register = findViewById(R.id.register_account);
        spinnerCollege = (Spinner) findViewById(R.id.spinnerCollege);



        firstNameEditText = findViewById(R.id.registrationconame);
        lastNameEditText = findViewById(R.id.registrationlastname);
        emailEditText = findViewById(R.id.registrationemail);
        mobileEditText = findViewById(R.id.registration_phone_number);
        passwordEditText = findViewById(R.id.registrationpassword);
        acceptBox=findViewById(R.id.acceptBox);




        backicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });






        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(RegistrationActivity.this, SignupActivity.class);
                startActivity(l);
            }
        });


        fetchDepartments();
        fecthColleges();




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();              //button is clicked, the registerUser method is called.
            }

        });
    }






    private void registerUser() {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String mobile = mobileEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String category = "STUDENT";
        int department = spinnerDepartment.getSelectedItemPosition() + 1;
        String college = spinnerCollege.getSelectedItem().toString();
        String deviceToken = "";

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || mobile.isEmpty() || password.isEmpty()) {
            Toast.makeText(RegistrationActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }


        if (!acceptBox.isChecked()) {
            Toast.makeText(RegistrationActivity.this, "Please accept the terms and conditions", Toast.LENGTH_SHORT).show();
            return;
        }
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<RegisterResponse> call = apiService.registerUser(firstName, lastName, email, mobile, category, department, password, college, deviceToken);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RegisterResponse registerResponse = response.body();
                    if (registerResponse.getStatus().equals("true")) {
                        Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();

                        Intent d=new Intent(RegistrationActivity.this,SignupActivity.class);
                        startActivity(d);

                        finish();
                        // Handle successful registration (e.g., navigate to login screen)
                    } else {
                        Toast.makeText(RegistrationActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegistrationActivity.this, "Registration failed: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.e("RegistrationActivity", "Failed to register", t);
                Toast.makeText(RegistrationActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
            }
        });
    }







            private void fecthColleges() {
                ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
                Call<CollegeResponse> call = apiService.getColleges();

                call.enqueue(new Callback<CollegeResponse>() {
                    @Override
                    public void onResponse(Call<CollegeResponse> call, Response<CollegeResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<String> colleges = new ArrayList<>();
                            for (CollegeResponse.College college : response.body().getData()) {
                                colleges.add(college.getName());
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(RegistrationActivity.this, android.R.layout.simple_spinner_item, colleges);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinnerCollege.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<CollegeResponse> call, Throwable t) {
                        Log.e("RegistrationActivity", "Failed to fetch colleges");

                    }
                });
            }






            private void fetchDepartments() {

                ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
                Call<DepartmentResponse> call = apiService.getDepartments();

                call.enqueue(new Callback<DepartmentResponse>() {
                    @Override
                    public void onResponse(Call<DepartmentResponse> call, Response<DepartmentResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<String> departments = new ArrayList<>();
                            for (DepartmentResponse.Department department : response.body().getData()) {
                                departments.add(department.getName());
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(RegistrationActivity.this, android.R.layout.simple_spinner_item, departments);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinnerDepartment.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<DepartmentResponse> call, Throwable t) {
                        Log.e("RegistrationActivity", "Failed to fetch departments", t);

                    }
                });


            }


        }