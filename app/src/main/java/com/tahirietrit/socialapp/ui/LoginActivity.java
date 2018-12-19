package com.tahirietrit.socialapp.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tahirietrit.socialapp.MainActivity;
import com.tahirietrit.socialapp.R;
import com.tahirietrit.socialapp.api.ApiService;
import com.tahirietrit.socialapp.api.Servicefactory;
import com.tahirietrit.socialapp.databinding.LoginActivityBinding;
import com.tahirietrit.socialapp.model.LoginResponse;
import com.tahirietrit.socialapp.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    LoginActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login_activity);
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private  void loginUser(){
        ApiService apiService = Servicefactory.retrofit.create(ApiService.class);
        Call<LoginResponse> call = apiService.loginUser("tahahahahahha",
                "50BE20EB6F29AA07D67DEB3AAFC4EF82");
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                User user = response.body().getUser().get(0);

                if(user!= null &&user.getStatus().equalsIgnoreCase("success")){
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                System.out.println("on fail");
                t.printStackTrace();
            }
        });
    }
}
