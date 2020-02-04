package com.example.githubrepo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.githubrepo.model.GithubResponseModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contracts.View {
    private static final String TAG = "MainActivity";
    private Contracts.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);
        presenter.getRepo("alishechka");


    }

    @Override
    public void showRepo(List<GithubResponseModel> list) {

        for(int i=0; i<list.size();i++){
            Log.i(TAG, "showRepo: "+list.get(i).getName());
        }
    }

    @Override
    public void onError(Throwable t) {
        Log.i(TAG, "onFailure: " + t.getMessage());

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroyCalled();
        super.onDestroy();
    }
}
