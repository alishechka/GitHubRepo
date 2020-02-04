package com.example.githubrepo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.githubrepo.model.GithubResponseModel;
import com.example.githubrepo.network.GithubClient;
import com.example.githubrepo.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    //    private Retrofit retrofit;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create retrofit
//        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()).build();
//        GithubClient client = retrofit.create(GithubClient.class);

        GithubClient client = RetrofitInstance.getClient();
        //response type
        Call<List<GithubResponseModel>> call = client.getRepositories("alishechka");

        call.enqueue(new Callback<List<GithubResponseModel>>() {
            @Override
            public void onResponse(Call<List<GithubResponseModel>> call, Response<List<GithubResponseModel>> response) {
                List<GithubResponseModel> repo = response.body();
                Log.i(TAG, repo.get(3).getName());
            }

            @Override
            public void onFailure(Call<List<GithubResponseModel>> call, Throwable t) {

            }
        });
    }
}
