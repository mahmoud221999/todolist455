package com.example.projecttodolist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import com.example.projecttodolist.fragment.high;
import com.example.projecttodolist.fragment.low;
import com.example.projecttodolist.fragment.mediam;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentPagerAdapter fragmentPagerAdapter;
    boolean doubleBackToExitPressedOnce = false;
    Appdatabase appDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tablayout);
       appDataBase  = Room.databaseBuilder(getApplicationContext(),Appdatabase.class,"database").build();


        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            Fragment[] myfragment = new Fragment[]
                    {
                            new high(),
                            new mediam(),
                            new low()
                    };
            String[] fragmentname = new String[]
                    {
                            "high",
                            "mediam",
                            "low"
                    };

            @Override
            public Fragment getItem(int position) {
                return myfragment[position];
            }

            @Override
            public int getCount() {
                return myfragment.length;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return fragmentname[position];
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void add(View view) {
        Intent gototaskdata = new Intent(getApplicationContext(), taskdata.class);
        startActivity(gototaskdata);

    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
