package com.example.qsolve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Mechanical_Sample_Adapter extends RecyclerView.Adapter<Mechanical_Sample_Adapter.ViewHolder> {

    private List<mechanical_sample_item> mechanicalSampleItems;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public Mechanical_Sample_Adapter(List<mechanical_sample_item> mechanicalSampleItems, OnItemClickListener onItemClickListener) {
        this.mechanicalSampleItems = mechanicalSampleItems;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mechanical_items_sample, parent, false);
        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        mechanical_sample_item item = mechanicalSampleItems.get(position);
        String formattedNumber = String.format("%02d", item.getNumber());
        holder.tvNumber.setText(formattedNumber);
        holder.tvTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return mechanicalSampleItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvNumber;
        TextView tvTitle;
        OnItemClickListener onItemClickListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tvNumber);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
