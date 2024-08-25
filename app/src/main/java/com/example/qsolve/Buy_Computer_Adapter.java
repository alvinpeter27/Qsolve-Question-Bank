package com.example.qsolve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Buy_Computer_Adapter extends RecyclerView.Adapter<Buy_Computer_Adapter.Buy_ComputerViewHolder> {

    private List<Buy_Computer_courses> coursesList;
    private OnItemClickListener listener;

    public Buy_Computer_Adapter(List<Buy_Computer_courses> coursesList, OnItemClickListener listener) {
        this.coursesList = coursesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Buy_ComputerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.buy_compter_item, parent, false);
        return new Buy_ComputerViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull Buy_ComputerViewHolder holder, int position) {
        Buy_Computer_courses course = coursesList.get(position);
        holder.tvNumber.setText(course.getNumber());
        holder.tvTitle.setText(course.getName());
        holder.downloadIcon.setImageResource(
                course.isDownloaded() ? R.drawable.check : R.drawable.download_circle
        );
    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Buy_Computer_courses item);
    }

    static class Buy_ComputerViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumber, tvTitle;
        ImageView downloadIcon;

        public Buy_ComputerViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tvNumber);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            downloadIcon = itemView.findViewById(R.id.downloadIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick((Buy_Computer_courses) v.getTag());
                }
            });
        }

        public void bind(Buy_Computer_courses course) {
            itemView.setTag(course);
        }
    }
}
