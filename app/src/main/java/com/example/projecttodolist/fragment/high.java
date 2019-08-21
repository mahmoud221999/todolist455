package com.example.projecttodolist.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.projecttodolist.Appdatabase;
import com.example.projecttodolist.R;
import com.example.projecttodolist.UserAdapter;
import com.example.projecttodolist.UserModel;

import java.util.List;

public class high extends Fragment {
    View high;
    Appdatabase appdatabase;
    EditText taskdata;
    DatePicker datePicker;
    TimePicker timePicker;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter useradapter;
    DividerItemDecoration dividerItemDecoration;
    private UserModel model;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        high = inflater.inflate(R.layout.recycleview, container, false);
        return high;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskdata = high.findViewById(R.id.taskdata);
        datePicker = high.findViewById(R.id.date);
        timePicker = high.findViewById(R.id.time);
        recyclerView = high.findViewById(R.id.recycleview);
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        appdatabase = Room.databaseBuilder(getContext(), Appdatabase.class, "database").build();


    }

    class get extends AsyncTask<Void, Void, List<UserModel>>
    {
        List<UserModel> uu;

        @Override
        protected List<UserModel> doInBackground(Void... voids)
        {
            uu = appdatabase.userDao().getAll();
            return uu;
        }

        @Override
        protected void onPostExecute(List<UserModel> userModels)
        {
           useradapter=new UserAdapter(UserModel);

           recyclerView.setAdapter((RecyclerView.Adapter) useradapter);
        }
    }


    class insert extends AsyncTask<UserModel , Void, Void>
    {

        @Override
        protected Void doInBackground(UserModel... userModels)
        {
            appdatabase.userDao().insert(userModels);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            new get().execute();
        }
    }











}
