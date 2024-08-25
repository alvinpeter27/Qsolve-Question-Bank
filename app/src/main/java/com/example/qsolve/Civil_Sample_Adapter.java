package com.example.qsolve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Civil_Sample_Adapter extends RecyclerView.Adapter<Civil_Sample_Adapter.ViewHolder> {

    private List<civil_samplePage_item> civilSamplePageItems;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public Civil_Sample_Adapter(List<civil_samplePage_item> civilSamplePageItems, OnItemClickListener onItemClickListener) {
        this.civilSamplePageItems = civilSamplePageItems;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.civil_sample_item, parent, false);
        return new ViewHolder(view,onItemClickListener);
    }

            @Override
            public void onBindViewHolder(@NonNull Civil_Sample_Adapter.ViewHolder holder, int position) {
                civil_samplePage_item item = civilSamplePageItems.get(position);
                String formattedNumber = String.format("%02d", item.getCivil_number());
                holder.civil_number.setText(formattedNumber);
                holder.civil_title.setText(item.getCivil_title());
            }

    @Override
    public int getItemCount() {
        return civilSamplePageItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView civil_number;
        TextView civil_title;
        OnItemClickListener onItemClickListener;

        public ViewHolder(@NonNull View itemView,OnItemClickListener onItemClickListener) {
            super(itemView);
            civil_number = itemView.findViewById(R.id.civil_Number);
            civil_title = itemView.findViewById(R.id.civil_Title);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}