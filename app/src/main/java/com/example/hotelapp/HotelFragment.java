package com.example.hotelapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class HotelFragment extends Fragment {

    public HotelFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hotel, container, false);

        ImageView image = view.findViewById(R.id.hotelImage);
        View card = view.findViewById(R.id.hotelCard);


        Glide.with(getContext())
                .load("https://d2kihw5e8drjh5.cloudfront.net/eyJidWNrZXQiOiJ1dGEtaW1hZ2VzIiwia2V5IjoicGxhY2VfaW1nL0pUcERGaHg0VG82SUJZYVlWMzdQS3ciLCJlZGl0cyI6eyJyZXNpemUiOnsid2lkdGgiOjY0MCwiaGVpZ2h0Ijo2NDAsImZpdCI6Imluc2lkZSJ9LCJyb3RhdGUiOm51bGwsInRvRm9ybWF0IjogIndlYnAifX0=") // you can change image
                .into(image);


        card.setOnClickListener(v -> {
            ((HotelActivity)getActivity()).goToMenuTab();
        });

        return view;
    }
}