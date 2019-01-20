package com.tahirietrit.socialapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.tahirietrit.socialapp.api.ApiService;
import com.tahirietrit.socialapp.api.Servicefactory;
import com.tahirietrit.socialapp.model.FeedResponse;
import com.tahirietrit.socialapp.model.ListAdapter;
import com.tahirietrit.socialapp.model.Posts;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Posts> posts;
    ListView listView;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shikoPostimet();

    }



    private void shikoPostimet(){
        ApiService apiService = Servicefactory.retrofit.create(ApiService.class);
        Call<FeedResponse> call = apiService.getPostet(getPostCount(), getUserID());
        call.enqueue(new Callback<FeedResponse>() {
            @Override
            public void onResponse(Call<FeedResponse> call, Response<FeedResponse> response) {
                listView=findViewById(R.id.list_view);
                posts = (ArrayList<Posts>) response.body().getPostet();
                System.out.println("POSTIMI MAIN = " + posts.get(1).getUserId());

                if(posts!=null) {
                    //adapter = new com.tahirietrit.socialapp.model.ListAdapter(MainActivity.this,getLayoutInflater());
                    adapter = new ListAdapter(MainActivity.this,getLayoutInflater());
                    //(() adapter).setPosts(posts);
                    adapter.setPosts(posts);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<FeedResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "SOMETHING WENT WRONG",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getPostCount(){
        return "100";
    }

    private String getUserID(){
        return "546";
    }
}
