package com.example.hotelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;
import com.google.firebase.database.*;

import java.util.*;

public class MenuFragment extends Fragment {

    RecyclerView recyclerView;
    List<FoodItem> list;
    FoodAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        adapter = new FoodAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference("hotels/Hotels/Hotel1/menu");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                list.clear();

                for(DataSnapshot data : snapshot.getChildren()){
                    FoodItem item = data.getValue(FoodItem.class);
                    list.add(item);
                }
                Toast.makeText(getContext(), "Loaded: " + snapshot.getChildrenCount(), Toast.LENGTH_SHORT).show();

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {}
        });

        return view;
    }
}