package com.example.qsolve;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG= SignupActivity.class.getSimpleName();

    ImageView backScreen;
    TextView forgot_password;
    TextView register_page;
    Button signup;
    EditText editEmail, editPassword;

    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       backScreen=(ImageView)findViewById(R.id.backscreen);
       forgot_password=(TextView)findViewById(R.id.forgot_password);
       register_page=(TextView)findViewById(R.id.register_page);


        signup = findViewById(R.id.signup);
        editEmail = (EditText) findViewById(R.id.edEmail);
        editPassword = (EditText) findViewById(R.id.edPassword);
        apiService = RetrofitClient.getClient().create(ApiService.class);

        backScreen.setOnClickListener(new View.OnClickListener() {                 //back to first activity page
            @Override
            public void onClick(View v) {
                Intent b=new Intent(SignupActivity.this,FirstActivity.class);
                startActivity(b);
            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {              //forgot password activity
            @Override
            public void onClick(View v) {
                Intent f=new Intent(SignupActivity.this, forgot_password_Activity.class);
                startActivity(f);
            }
        });

        register_page.setOnClickListener(new View.OnClickListener() {                 //registration activity
            @Override
            public void onClick(View v) {
                Intent r=new Intent(SignupActivity.this,RegistrationActivity.class);
                startActivity(r);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                String device_token = "31cd4eb45b3aff17";


                login(email, password, device_token);


            }
        });

    }

    private void login(String username, String password, String device_token) {


        Call<LoginResponse> call = apiService.login(username, password,device_token);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse( Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){

                    Log.d(TAG, "onResponse: lllllllllllllllllllllllllllllllllllllll"+response.body().getToken());

                    String status=response.body().getStatus();
                    if (status.equals("true")){

                        Intent i=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(i);

                        Toast.makeText(SignupActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(SignupActivity.this, "wrong crerdentials", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(SignupActivity.this, " failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}










