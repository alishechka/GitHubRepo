package com.example.githubrepo.network;

import com.example.githubrepo.model.GithubResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubClient {

    @GET("users/{user}/repos")
    Call<List<GithubResponseModel>> getRepositories(@Path("user") String user);

}
