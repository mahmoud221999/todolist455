package com.example.projecttodolist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class update extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Appdatabase appdatabase;
    Button update;
    EditText taskdata;
    TimePicker timePicker;
    DatePicker datePicker;
    Spinner spinner;
    TextView tasl_data;
    String[] periority = {"High", "Mediam", "Low"};

    int pr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        update = findViewById(R.id.update_data);
        taskdata = findViewById(R.id.taskdata_update);
        timePicker = findViewById(R.id.time_update);
        datePicker = findViewById(R.id.date_update);
        spinner = findViewById(R.id.spinner_pr_update);
        tasl_data = findViewById(R.id.task_data);
        appdatabase = Room.databaseBuilder(getApplicationContext(), Appdatabase.class, "database").build();

        //spinner
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, periority);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);


        //Time picker
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minutes) {
                timePicker.setIs24HourView(false);
                Toast.makeText(getApplicationContext(), hour + " : " + minutes, Toast.LENGTH_SHORT).show();
            }
        });


        //add task
        update.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
//data_and_time_picker
                String data = taskdata.getText().toString();
                String hour = timePicker.getCurrentHour().toString();
                String minutes = timePicker.getCurrentMinute().toString();


//date_picker
                String day = String.valueOf(datePicker.getDayOfMonth());
                String month = String.valueOf(datePicker.getMonth());
                String year = String.valueOf(datePicker.getYear());


                if (data.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "enter  task name ", Toast.LENGTH_SHORT).show();
                    return;
                }


//periority
                if (spinner.getSelectedItem().toString().equals("High")) {
                    pr = 0;
                } else if (spinner.getSelectedItem().toString().equals("Mediam")) {
                    pr = 1;
                } else if (spinner.getSelectedItem().toString().equals("Low")) {
                    pr = 2;
                }


//finally
                int id=getIntent().getIntExtra("id",0);
                UserModel userModel = new UserModel(id,day + ":" + month + ":" + year, hour + ":" + minutes, pr, data);
                new updatetask().execute(userModel);
                taskdata.setText("");
                timePicker.setCurrentHour(Integer.valueOf(hour));
                timePicker.setCurrentMinute(Integer.valueOf(minutes));

                //intent

                onBackPressed();

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterVie, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), periority[position], Toast.LENGTH_LONG).show();
//
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        Toast.makeText(this, "Select Priority", Toast.LENGTH_SHORT).show();

    }


    public class updatetask extends AsyncTask<UserModel, Void, Void>
    {

        @Override
        protected Void doInBackground(UserModel... userModels) {
            appdatabase.userDao().update(userModels[0]);
            return null;
        }
    }
}
