package com.tuanna.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tuanna.retrofitdemo.API.ApiAuth;
import com.tuanna.retrofitdemo.API.core.ApiClient;
import com.tuanna.retrofitdemo.API.core.ApiConfig;
import com.tuanna.retrofitdemo.API.core.ApiError;
import com.tuanna.retrofitdemo.API.core.Callback;
import com.tuanna.retrofitdemo.model.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import retrofit.Response;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewById(R.id.tvUserName)
    TextView tvUserName;
    @ViewById(R.id.tvEmail)
    TextView tvEmail;
    @ViewById(R.id.tvCompany)
    TextView tvCompany;
    @ViewById(R.id.tvLocation)
    TextView tvLocation;
    @ViewById(R.id.imgAvatar)
    ImageView imgAvatar;

    @AfterViews
    void init() {
        ApiConfig apiConfig = ApiConfig.builder(getApplicationContext())
                .baseUrl("https://api.github.com")
                .build();
        ApiClient.getInstance().create(apiConfig);
        ApiAuth.getUser("tuanna-asiantech", new Callback<User>() {
            @Override
            public void onResponse(Response<User> userResponse) {
                tvUserName.setText(userResponse.body().getName());
                tvEmail.setText(userResponse.body().getEmail());
                tvCompany.setText(userResponse.body().getCompany());
                tvLocation.setText(userResponse.body().getLocation());
                Picasso.with(getApplicationContext())
                        .load(userResponse.body().getAvatarUrl())
                        .into(imgAvatar);
            }

            @Override
            public void onFailure(ApiError error) {
                Log.d("xxx", "Error: " + error.getMessage());
            }
        });
    }
}
