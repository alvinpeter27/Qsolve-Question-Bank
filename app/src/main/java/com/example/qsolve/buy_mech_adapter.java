package com.example.qsolve;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class buy_mech_adapter extends RecyclerView.Adapter<buy_mech_adapter.buy_mechViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Buy_course_item item);
    }

    private Context context;
    private List<Buy_course_item> buyCourseItems;
    private OnItemClickListener listener;

    public buy_mech_adapter(Context context, List<Buy_course_item> buyCourseItems, OnItemClickListener listener) {
        this.context = context;
        this.buyCourseItems = buyCourseItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public buy_mechViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.buy_mech_item, parent, false);
        return new buy_mechViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull buy_mechViewHolder holder, int position) {
        Buy_course_item course = buyCourseItems.get(position);
        Log.d("Adapter", "Number: " + course.getNumber() + ", Name: " + course.getName());
        holder.tvNumber.setText(course.getNumber());
        holder.tvTitle.setText(course.getName());
        if (course.isDownloaded()) {
            holder.downloadIcon.setImageResource(R.drawable.check);
        } else {
            holder.downloadIcon.setImageResource(R.drawable.download_circle);
        }

        holder.itemView.setOnClickListener(v -> listener.onItemClick(course));
    }

    @Override
    public int getItemCount() {
        return buyCourseItems.size();
    }

    public class buy_mechViewHolder extends RecyclerView.ViewHolder {

        TextView tvNumber, tvTitle;
        ImageView downloadIcon;

        public buy_mechViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNumber = itemView.findViewById(R.id.tvNumber);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            downloadIcon = itemView.findViewById(R.id.downloadIcon);
        }
    }
}

