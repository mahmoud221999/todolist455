package com.example.projecttodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.VH> {
    public Context Adapter;


    List<UserModel> Adapter_list;

    public UserAdapter(List<UserModel> adapter_list) {
        this.Adapter_list = adapter_list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Adapter).inflate(R.layout.recycleview, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        UserAdapter userAdapter = Adapter_list.get(position);
        String time=((UserModel) userAdapter).getTime();
        String date=((UserModel) userAdapter).getDate();
        String id=((UserModel) userAdapter).getId();
        String periority=((UserModel) userAdapter).getPeriority();
        String data=((UserModel) userAdapter).getData();

        holder.time.setText(time);
        holder.date.setText(date);
        holder.data.setText(data);



    }

    @Override
    public int getItemCount() {
        return Adapter_list.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView date, data, time;

        public VH(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.task_date);
            data = itemView.findViewById(R.id.task_data);
            time = itemView.findViewById(R.id.task_time);
        }


    }

}
