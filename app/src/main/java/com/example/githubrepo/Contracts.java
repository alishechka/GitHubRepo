package com.example.githubrepo;

import com.example.githubrepo.model.GithubResponseModel;

import java.util.List;

public interface Contracts {

    interface View {
        void showRepo(List<GithubResponseModel> list);

        void onError(Throwable t);
    }

    interface Presenter {
        void getRepo(String userName);

        void onDestroyCalled();
    }
}
