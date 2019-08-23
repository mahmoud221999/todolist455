package com.example.projecttodolist.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Delete;
import androidx.room.Room;

import com.example.projecttodolist.Appdatabase;
import com.example.projecttodolist.R;
import com.example.projecttodolist.UserAdapter;
import com.example.projecttodolist.UserModel;
import com.example.projecttodolist.taskdata;

import java.util.List;

public class high extends Fragment {
    View high;
    Appdatabase appdatabase;
    EditText taskdata;
    DatePicker datePicker;
    TimePicker timePicker;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    UserAdapter useradapter;
    DividerItemDecoration dividerItemDecoration;

    @Override
    public void onAttachFragment(Fragment childFragment) {
        new get().execute();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        high = inflater.inflate(R.layout.high, container, false);
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
        new get().execute();

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                new deletedata ().execute(useradapter.getTaskAt(viewHolder.getAdapterPosition()));

            }
        }).attachToRecyclerView(recyclerView);
    }

    class get extends AsyncTask<Void, Void, List<UserModel>>
    {
        List<UserModel> uu;

        @Override
        protected List<UserModel> doInBackground(Void... voids)
        {
            uu = appdatabase.userDao().getHigh();
            return uu;
        }

        @Override
        protected void onPostExecute(List<UserModel> userModels)
        {
           useradapter=new UserAdapter(getContext(),userModels);

           recyclerView.setAdapter( useradapter);
        }


    }
    public class deletedata extends AsyncTask<UserModel, Void,List<UserModel>>{

        @Override
        protected List<UserModel> doInBackground(UserModel... userModels) {
            appdatabase.userDao().delete(userModels[0]);
            return appdatabase.userDao().getHigh();
        }

        @Override
        protected void onPostExecute(List<UserModel> userModels) {
            useradapter = new UserAdapter(getContext(),userModels);
            recyclerView.setAdapter(useradapter);
        }
    }
}
