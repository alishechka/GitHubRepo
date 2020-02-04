package com.example.githubrepo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubrepo.model.GithubResponseModel;

import java.util.List;

public class MVPAdapter extends RecyclerView.Adapter<MVPAdapter.myViewHolder> {
    private List<GithubResponseModel> lists;

    public MVPAdapter(List<GithubResponseModel> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_view, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.textView.setText(lists.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_displayUser);
        }
    }
}
