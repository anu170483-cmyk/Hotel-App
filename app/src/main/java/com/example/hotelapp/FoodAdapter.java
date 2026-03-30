package com.example.hotelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    Context context;
    List<FoodItem> list;

    public FoodAdapter(Context context, List<FoodItem> list) {
        this.context = context;
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView image;
        Button addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.foodName);
            price = itemView.findViewById(R.id.foodPrice);
            image = itemView.findViewById(R.id.foodImage);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
        FoodItem item = list.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((HotelActivity) context).goToPriceTab(item.getName(),String.valueOf(item.getPrice()));
            }
        });

        holder.name.setText(item.getName());
        holder.price.setText("₹ " + item.getPrice());

        // Load image
        Glide.with(context)
                .load(item.getImage())
                .into(holder.image);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getName() + " added", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {

        return list.size();
    }
}