package com.tahirietrit.socialapp.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.tahirietrit.socialapp.MainActivity;
import com.tahirietrit.socialapp.R;
import com.tahirietrit.socialapp.api.ApiService;
import com.tahirietrit.socialapp.api.Servicefactory;
import com.tahirietrit.socialapp.databinding.LoginActivityBinding;
import com.tahirietrit.socialapp.model.FeedResponse;
import com.tahirietrit.socialapp.model.LoginResponse;
import com.tahirietrit.socialapp.model.Posts;
import com.tahirietrit.socialapp.model.User;
import com.tahirietrit.socialapp.prefs.AppPreferences;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    LoginActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppPreferences.init(getApplication());
        binding = DataBindingUtil.setContentView(this, R.layout.login_activity);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
/*          if(AppPreferences.getUserID()!=null){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }*/

        binding.shikoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shikoPostimet();
            }
        });
    }


    private void loginUser() {
        ApiService apiService = Servicefactory.retrofit.create(ApiService.class);
        Call<LoginResponse> call = apiService.loginUser(getUserName(),
                md5(getPassword()));
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                User user = response.body().getUser().get(0);

                if (user != null && user.getStatus().equalsIgnoreCase("success")) {
                    AppPreferences.saveUserName(user.getUsername());
                    AppPreferences.saveUserName(user.getUserID());

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(), "Wrong combination",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Wrong combination",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void shikoPostimet(){
        ApiService apiService = Servicefactory.retrofit.create(ApiService.class);
        Call<FeedResponse> call = apiService.getPostet("158",
                "0");
        call.enqueue(new Callback<FeedResponse>() {
            @Override
            public void onResponse(Call<FeedResponse> call, Response<FeedResponse> response) {
                Posts post = response.body().getPostet().get(1);

                System.out.println("POSTIMI = " + post.getUserId());
                if(post!=null) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<FeedResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "SOMETHING WENT WRONG",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getUserName() {
        return binding.emailEdittext.getText().toString();
    }

    private String getPassword() {
        return binding.passwordEdittext.getText().toString();
    }

    private String getPostCount1(){
        return "100";
    }

    private String getUserID1(){
        return "546";
    }

    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
