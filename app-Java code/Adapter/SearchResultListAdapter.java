package com.aumento.floodrescuresystem.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aumento.floodrescuresystem.ModelClass.SearchResultListModelClass;
import com.aumento.floodrescuresystem.R;

import java.util.List;

public class SearchResultListAdapter extends RecyclerView.Adapter<SearchResultListAdapter.MyViewHolder> {

    Context mtx;
    List<SearchResultListModelClass> resultList;

    public SearchResultListAdapter(Context mtx, List<SearchResultListModelClass> resultList) {
        this.mtx = mtx;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public SearchResultListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_search_victim, parent, false);
        return new SearchResultListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchResultListAdapter.MyViewHolder holder, final int position) {
        final SearchResultListModelClass lists = resultList.get(position);

        holder.nameTV.setText(lists.getName());
        holder.locationTV.setText(lists.getLocation());
        holder.campTV.setText(lists.getCamp());
        holder.dateTV.setText(lists.getDate());

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTV, campTV, dateTV, locationTV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = (TextView) itemView.findViewById(R.id.nameTextView);
            locationTV = (TextView) itemView.findViewById(R.id.locationTextView);
            campTV = (TextView) itemView.findViewById(R.id.campTextView);
            dateTV = (TextView) itemView.findViewById(R.id.dateTextView);
        }
    }
}
