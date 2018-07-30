package com.example.android.madridguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create ViewPager and associate it with the one in the layout
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Instantiate a new SimpleFragmentPagerAdapter
        FragmentAdapter adapter = new FragmentAdapter(this, getSupportFragmentManager());

        // Set the adapter in the ViewPager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }
}
