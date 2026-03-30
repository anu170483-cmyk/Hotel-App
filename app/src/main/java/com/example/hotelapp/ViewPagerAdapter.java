package com.example.hotelapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0) return new HotelFragment();
        if(position == 1) return new MenuFragment();
        else return new PriceFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}