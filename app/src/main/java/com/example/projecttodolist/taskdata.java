package com.example.projecttodolist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projecttodolist.fragment.high;

public class taskdata extends AppCompatActivity
{
    Button addtask;
    EditText taskdata;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskdata);
        addtask=findViewById(R.id.addtask);
        taskdata=findViewById(R.id.taskdata);



        addtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data=taskdata.getText().toString();
                if (data.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "enter  task name ", Toast.LENGTH_SHORT).show();
                    return;
                }

                UserModel userModel=new UserModel("","",1,data);
                new high.insert().execute(userModel);
                taskdata.setText("");
            }
        });
    }




}

