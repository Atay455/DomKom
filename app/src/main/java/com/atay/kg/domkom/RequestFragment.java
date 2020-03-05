package com.atay.kg.domkom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RequestFragment extends Fragment {

    public static Fragment newInstance() {
        return  new RequestFragment();
    }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_requests, container, false);
            List<String> list = new ArrayList<>();
            list.add("Заявка#1");
            RecyclerView requestrecyclerview = view.findViewById(R.id.request_recyclerView);
            requestrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
            requestrecyclerview.setAdapter(new RecyclerViewAdapter());

            return view;
        }

        private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private CardView reqCardView;
        private TextView reqTextView;
        private TextView reqTextView2;

         public  RecyclerViewHolder(View itemView) {
             super(itemView);

         }
         public RecyclerViewHolder(LayoutInflater inflater,ViewGroup container) {
             super(inflater.inflate(R.layout.card_view_request,container,false));

             reqCardView = itemView.findViewById(R.id.card_container);
             reqTextView = itemView.findViewById(R.id.text_holder);
             reqTextView2 = itemView.findViewById(R.id.text_holder2);
         }
        }

        private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

            @NonNull
            @Override
            public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                return new RecyclerViewHolder(inflater, parent);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 9;
            }
        }


    }


