package com.atay.kg.domkom.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atay.kg.domkom.Models.NewsModel;
import com.atay.kg.domkom.NewsFragment;
import com.atay.kg.domkom.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<NewsModel> newsModels = new ArrayList<>();
    private NewsFragment context;


    public NewsAdapter(NewsFragment context, ArrayList<NewsModel> newsModels) {
        this.newsModels=newsModels;
        this.context=context;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.newsi_tem,viewGroup,false);


        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder viewHolder, int i) {
        viewHolder.news_title.setText(newsModels.get(i).getTitle());
        viewHolder.news_date.setText(newsModels.get(i).getDate());
        Picasso.get().load(newsModels.get(i).getImage()).into(viewHolder.news_image);
    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView news_image;
        private TextView news_title,news_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            news_image=(ImageView)itemView.findViewById(R.id.ItemImageNews);
            news_title=(TextView) itemView.findViewById(R.id.ItemTitleNews);
            news_date=(TextView)itemView.findViewById(R.id.ItemDateNews);
        }
    }
}

