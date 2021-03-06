package com.galleryapp.cargallery.ui.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.galleryapp.cargallery.R;
import com.galleryapp.cargallery.data.model.Car;

import java.util.List;

/**
 * @author yuana
 * @since 10/21/17
 */

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private List<Car> mData;
    private CarAdapterListener mListener;

    public CarAdapter(List<Car> mData) {
        this.mData = mData;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_car, parent, false);

        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        Car item = getItem(position);
        holder.bind(item, mListener);
    }

    private Car getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setAdapterListener(CarAdapterListener carAdapterListener) {
        mListener = carAdapterListener;
    }

    public void remove(Car car) {
        mData.remove(car);
        notifyDataSetChanged();
    }

    public void add(Car savedCar) {
        mData.add(savedCar);
        notifyDataSetChanged();
    }

    public void removeAll() {
        mData = null;
        notifyDataSetChanged();
    }
}
