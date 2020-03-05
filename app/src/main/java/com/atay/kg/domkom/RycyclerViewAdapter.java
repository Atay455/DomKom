package com.atay.kg.domkom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RycyclerViewAdapter extends RecyclerView.Adapter<RycyclerViewAdapter.MyViewHolder> {

    Context bContext;
    List<NewsClass> mData;

    public RycyclerViewAdapter(Context bContext, List<NewsClass>mData){
        this.bContext = bContext;
        this.mData = mData;
    }






    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View v;
        v = LayoutInflater.from(bContext).inflate(R.layout.newsi_tem,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,int position) {

        holder.text.setText(mData.get(position).getText());
        holder.image.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        private ImageView image;



        public  MyViewHolder(View itemView) {
            super(itemView);

            text = (TextView)itemView.findViewById(R.id.ItemTextNews);
            image = (ImageView)itemView.findViewById(R.id.ItemImageNews);
        }
    }
}

