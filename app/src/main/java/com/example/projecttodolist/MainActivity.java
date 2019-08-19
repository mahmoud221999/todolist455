package com.example.projecttodolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.projecttodolist.fragment.high;
import com.example.projecttodolist.fragment.low;
import com.example.projecttodolist.fragment.mediam;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentPagerAdapter fragmentPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tablayout);


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
}
