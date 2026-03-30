package com.example.hotelapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HotelActivity extends AppCompatActivity {
    public static String selectedFoodName;
    public static String selectedFoodPrice;


    TabLayout tabLayout;
    ViewPager2 viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if(position == 0) tab.setText("Hotels");
                    if(position == 1) tab.setText("Menu");
                    if(position == 2) tab.setText("Price");
                }).attach();
    }
    public void goToMenuTab() {
        viewPager.setCurrentItem(1); // go to Menu tab
    }

    public void goToPriceTab(String name, String price) {
        selectedFoodName = name;
        selectedFoodPrice = price;
        viewPager.setCurrentItem(2); // go to Price tab
    }
}
