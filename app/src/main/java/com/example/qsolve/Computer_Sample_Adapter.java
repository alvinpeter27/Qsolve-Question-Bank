package com.example.qsolve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Computer_Sample_Adapter extends RecyclerView.Adapter<Computer_Sample_Adapter.ViewHolder> {

    private List<computer_samplePage_item> computerSamplePageItems;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public Computer_Sample_Adapter(List<computer_samplePage_item> computerSamplePageItems,OnItemClickListener onItemClickListener) {
        this.computerSamplePageItems = computerSamplePageItems;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.computer_sample_item, parent, false);
        return new ViewHolder(view,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        computer_samplePage_item item = computerSamplePageItems.get(position);
        String formattedNumber = String.format("%02d", item.getComputer_number());
        holder.computer_number.setText(formattedNumber);
        holder.computer_title.setText(item.getComputer_title());

    }

    @Override
    public int getItemCount() {

        return computerSamplePageItems.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView computer_number;
        TextView computer_title;

       OnItemClickListener onItemClickListener;


        public ViewHolder(@NonNull View itemView,OnItemClickListener onItemClickListener) {
            super(itemView);
            computer_number = itemView.findViewById(R.id.science_number);
            computer_title = itemView.findViewById(R.id.science_title);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
