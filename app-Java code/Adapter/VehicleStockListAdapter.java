package com.aumento.floodrescuresystem.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aumento.floodrescuresystem.ModelClass.VehicleStockListModelClass;
import com.aumento.floodrescuresystem.R;
import com.aumento.floodrescuresystem.VehicleStockActivity;

import java.util.List;

public class VehicleStockListAdapter extends RecyclerView.Adapter<VehicleStockListAdapter.MyViewHolder> {

    Context mtx;
    List<VehicleStockListModelClass> stockList;

    public VehicleStockListAdapter(Context mtx, List<VehicleStockListModelClass> stockList) {
        this.mtx = mtx;
        this.stockList = stockList;
    }

    @NonNull
    @Override
    public VehicleStockListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_stock_list, parent, false);
        return new VehicleStockListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final VehicleStockListAdapter.MyViewHolder holder, final int position) {
        final VehicleStockListModelClass lists = stockList.get(position);

        holder.stockItemNameTV.setText(lists.getItem_name());
        holder.stockItemQtyTV.setText(lists.getItem_qty());

    }

    @Override
    public int getItemCount() {
        Log.d("TAG", "getItemCount: "+stockList.size());
        return stockList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView stockItemNameTV, stockItemQtyTV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            stockItemNameTV = itemView.findViewById(R.id.stockItemNameTextView);
            stockItemQtyTV = itemView.findViewById(R.id.stockItemQtyTextView);
        }
    }
}
