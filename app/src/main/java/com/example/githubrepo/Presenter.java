package com.example.githubrepo;

import android.util.Log;

import com.example.githubrepo.model.GithubResponseModel;
import com.example.githubrepo.network.GithubClient;
import com.example.githubrepo.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements Contracts.Presenter {
    private Contracts.View view;
    private static final String TAG = "Presenter";

    public Presenter(Contracts.View view) {
        this.view = view;
    }

    @Override
    public void getRepo(String userName) {
        GithubClient client = RetrofitInstance.getClient();
        Call<List<GithubResponseModel>> call = client.getRepositories(userName);

        call.enqueue(new Callback<List<GithubResponseModel>>() {
            @Override
            public void onResponse(Call<List<GithubResponseModel>> call, Response<List<GithubResponseModel>> response) {
                view.showRepo(response.body());
            }

            @Override
            public void onFailure(Call<List<GithubResponseModel>> call, Throwable t) {
                view.onError(t);
            }
        });
    }

    @Override
    public void onDestroyCalled() {
        view = null;
    }
}
