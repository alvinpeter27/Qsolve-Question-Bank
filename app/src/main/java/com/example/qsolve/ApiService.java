package com.example.qsolve;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {


    @FormUrlEncoded                                                  //registration
    @POST("register_user")
    Call<RegisterResponse> registerUser(
            @Field("first name")String firstName,
            @Field("last name")String lastName,
            @Field("email")String email,
            @Field("mobile")String mobile,
            @Field("category") String category,
            @Field("department") int department,
            @Field("password") String password,
            @Field("college") String college,
            @Field("device_token") String deviceToken


    );




@FormUrlEncoded
@POST("login")                                                                //login
    Call<LoginResponse>login(
            @Field("email") String email,
            @Field("password") String password,
            @Field("device_token") String device_token
);





@GET("get_departments")
    Call<DepartmentResponse> getDepartments();                               //spinner department






@GET("colleges")
    Call<CollegeResponse> getColleges();                                        //spinner college


}

