package com.example.githubrepo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubrepo.model.GithubResponseModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contracts.View {
    private static final String TAG = "MainActivity";
    private Contracts.Presenter presenter;
    private Button button;
    private ProgressBar progressBar;
    private TextView textView;
    private RecyclerView recyclerView;
    private MVPAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textError);
        recyclerView = findViewById(R.id.rv_recycler);

        presenter = new Presenter(this);

        presenter.getRepo("achinxfgntyjtlimbu");
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRepo(List<GithubResponseModel> list) {
        for (int i = 0; i < list.size(); i++) {
            Log.i(TAG, "showRepo: " + list.get(i).getName());
        }
        textView.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        adapter = new MVPAdapter(list);

        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onError(Throwable t) {
        Log.i(TAG, "onFailure: " + t.getMessage());
        Log.i(TAG, "onError: " + t.getCause());
    }

    @Override
    public void tryAgain() {
        button.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        textView.setText("try again");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getRepo("alishechka");
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroyCalled();
        super.onDestroy();
    }
}
