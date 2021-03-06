package com.tahirietrit.socialapp.api;

        import android.text.GetChars; //unused import statement

        import com.tahirietrit.socialapp.model.FeedResponse;
        import com.tahirietrit.socialapp.model.LoginResponse;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Query;

public interface ApiService {
    @GET("/paintbook/index.php")
    Call<LoginResponse> loginUser(@Query("User") String user,
                                  @Query("Password") String password);

    @GET("/paintbook/index.php")
    Call<FeedResponse> getPostet(@Query("GetPostet") String postCount,
                                 @Query("UserID") String userID);
}