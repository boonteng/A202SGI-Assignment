package com.inti.student.assignment.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.inti.student.assignment.Interface.ItemClickListener;
import com.inti.student.assignment.R;


public class DietViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView diet_name;
    public ImageView diet_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public DietViewHolder(View itemView) {
        super(itemView);
        diet_name = (TextView)itemView.findViewById(R.id.diet_name);
        diet_image = (ImageView)itemView.findViewById(R.id.diet_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
