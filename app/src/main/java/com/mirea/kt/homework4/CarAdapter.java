package com.mirea.kt.homework4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder>{
    private ArrayList<Car> cars;

    public CarAdapter(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView modelView;
        private final TextView numberView;
        private final TextView ageView;

        ViewHolder(View view){
            super(view);
            modelView = view.findViewById(R.id.tvCarModel);
            numberView = view.findViewById(R.id.tvCarNumber);
            ageView = view.findViewById(R.id.tvCarAge);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.modelView.setText(String.format("%s", car.getModel()));
        holder.numberView.setText(String.format("%s", car.getNumber()));
        holder.ageView.setText(String.format("%d", car.getAge()));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}