package com.atay.kg.domkom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RycyclerViewAdapter extends RecyclerView.Adapter<RycyclerViewAdapter.MyViewHolder> {

    private  Context bContext;
    private  List<NewsClass> mData;
    RequestOptions option;

    public RycyclerViewAdapter(Context bContext, List<NewsClass>mData){
        this.bContext = bContext;
        this.mData = mData;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.rounded_option).error(R.drawable.rounded_option);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(bContext);
        view = inflater.inflate(R.layout.newsi_tem,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(bContext, SecondNewsActivity.class);
                i.putExtra("news_name",mData.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("news_text",mData.get(viewHolder.getAdapterPosition()).getText());
                i.putExtra("news_date",mData.get(viewHolder.getAdapterPosition()).getDate());
                i.putExtra("news_image",mData.get(viewHolder.getAdapterPosition()).getImage_url());
                i.putExtra("news_id",mData.get(viewHolder.getAdapterPosition()).getId());


                bContext.startActivity(i);

            }
        });




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.news_title.setText(mData.get(position).getTitle());
        holder.news_date.setText(mData.get(position).getDate());
        // Load Image from the internet and set it into Imageview using Glide
        Glide.with(bContext).load(mData.get(position).getImage_url()).apply(option).into(holder.news_image);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView news_title ;
        TextView news_date;
        ImageView news_image;
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            news_title = itemView.findViewById(R.id.ItemTextNews);
            news_date = itemView.findViewById(R.id.textViewDate);
            news_image = itemView.findViewById(R.id.ItemImageNews);

        }
    }

}


