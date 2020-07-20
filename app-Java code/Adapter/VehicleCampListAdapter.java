package com.aumento.floodrescuresystem.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aumento.floodrescuresystem.ModelClass.VehicleCampListModelClass;
import com.aumento.floodrescuresystem.R;
import com.aumento.floodrescuresystem.RequestDetailsActivity;
import com.aumento.floodrescuresystem.VehicleStockActivity;

import java.util.List;

public class VehicleCampListAdapter extends RecyclerView.Adapter<VehicleCampListAdapter.MyViewHolder> {

    Context mtx;
    List<VehicleCampListModelClass> campList;

    public VehicleCampListAdapter(Context mtx, List<VehicleCampListModelClass> campList) {
        this.mtx = mtx;
        this.campList = campList;
    }

    @NonNull
    @Override
    public VehicleCampListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_camp_list, parent, false);
        return new VehicleCampListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final VehicleCampListAdapter.MyViewHolder holder, final int position) {
        final VehicleCampListModelClass lists = campList.get(position);

        holder.campNameTV.setText(lists.getCamp_name());

        holder.campListTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mtx, VehicleStockActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mtx.startActivity(intent);

            }
        });

        holder.campLocationIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?daddr="+lists.getLatitude()+","+lists.getLongitude()));
                mtx.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return campList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView campNameTV, campListTV;
        ImageView campLocationIV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            campNameTV = itemView.findViewById(R.id.campNameTextView);
            campListTV = itemView.findViewById(R.id.campListTextView);
            campLocationIV = itemView.findViewById(R.id.campLocationImageView);
        }
    }
}
