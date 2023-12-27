package com.bsu.beweather.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bsu.beweather.Domains.Hourly;
import com.bsu.beweather.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.viewholder> {
    ArrayList<Hourly> items;
    Context context;

    public HourlyAdapter(ArrayList<Hourly> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HourlyAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hourly, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.viewholder holder, int position) {
        holder.hourTxt.setText(items.get(position).getHour());
        holder.tempTxt.setText(items.get(position).getTemp()+ "\u00B0");

        int drawableResourceId=holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(), "drawable", holder.itemView.getContext().getOpPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView hourTxt,tempTxt;
        ImageView pic;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            hourTxt=itemView.findViewById(R.id.hourTxt);
            tempTxt=itemView.findViewById(R.id.tempTxt);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
