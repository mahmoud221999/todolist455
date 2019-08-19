package com.example.projecttodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class taskdata extends AppCompatActivity  {
    TimePicker timePicker;
    TextView tasktimer,taskdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskdata);
        tasktimer=findViewById(R.id.task_time);


        timePicker=findViewById(R.id.time);
timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
    @Override
    public void onTimeChanged(TimePicker timePicker, int hour, int minute)
    {
     tasktimer.setText(hour+":"+minute);
    }
});

  }


  }

