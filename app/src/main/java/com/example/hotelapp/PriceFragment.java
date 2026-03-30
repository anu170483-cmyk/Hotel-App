package com.example.hotelapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class PriceFragment extends Fragment {

    TextView name, price;

    public PriceFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_price, container, false);

        name = view.findViewById(R.id.foodName);
        price = view.findViewById(R.id.foodPrice);

        return view;
    }
//on resume method
    @Override
    public void onResume() {
        super.onResume();

        if(HotelActivity.selectedFoodName != null){
            name.setText(HotelActivity.selectedFoodName);
            price.setText("₹ " + HotelActivity.selectedFoodPrice);
        }
    }
}