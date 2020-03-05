package com.atay.kg.domkom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    View v;
    private   RecyclerView  myrecyclerview;
    private List<NewsClass> firsttextNews;

    public NewsFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        myrecyclerview = (RecyclerView)view.findViewById(R.id.NEWSrecyclerView);
        RycyclerViewAdapter recyclerViewAdapter = new RycyclerViewAdapter(getContext(),firsttextNews);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firsttextNews = new ArrayList<>();
        firsttextNews.add(new NewsClass("He determined to drop his litigation with the monastry, and relinguish his claims to the wood-cuting and fishery rihgts at once.",R.drawable.news));
        firsttextNews.add(new NewsClass("His claims to the wood-cuting and fishery rihgts at once. He was the more ready to do this becuase the rights had becom much less valuable, and he had indeed the vaguest idea where the wood and river in quedtion were.",R.drawable.news));
        firsttextNews.add(new NewsClass("He determined to drop his litigation with the monastry, and relinguish his claims to the wood-cuting and fishery rihgts at once. He was the more ready to do this becuase the rights had becom much less valuable, and he had indeed the vaguest idea where the wood and river in quedtion were.",R.drawable.news));
        firsttextNews.add(new NewsClass("His litigation with the monastry, and relinguish his claims to the wood-cuting and fishery rihgts at once. He was the more ready to do this becuase the rights had becom much less valuable, and he had indeed the vaguest idea where the wood and river in quedtion were.",R.drawable.news));
        firsttextNews.add(new NewsClass("He determined to drop his litigation with the monastry, and relinguish his claims to the wood-cuting and fishery rihgts at once. He was the more ready to do this becuase the rights had becom much less valuable, and he had indeed the vaguest idea where the wood and river in quedtion were.",R.drawable.news));
        firsttextNews.add(new NewsClass("He determined to drop his litigation with the monastry, and relinguish his claims to the wood-cuting and fishery rihgts at once. He was the more ready to do this becuase the rights had becom much less valuable, and he had indeed the vaguest idea where the wood and river in quedtion were.",R.drawable.news));
        firsttextNews.add(new NewsClass("He was the more ready to do this becuase the rights had becom much less valuable, and he had indeed the vaguest idea where the wood and river in quedtion were.",R.drawable.news));
        firsttextNews.add(new NewsClass("He determined to drop his litigation with the monastry, and relinguish his claims to the wood-cuting and fishery rihgts at once. He was the more ready to do this becuase the rights had becom much less valuable, and he had indeed the vaguest idea where the wood and river in quedtion were.",R.drawable.news));
        firsttextNews.add(new NewsClass("He determined to drop his litigation with the monastry, and relinguish his claims to the wood-cuting and fishery rihgts at once. He was the more ready to do this becuase the rights had becom much less valuable, and he had indeed the vaguest idea where the wood and river in quedtion were.",R.drawable.news));
        firsttextNews.add(new NewsClass("These excellant intentions were strengthed when he enterd the Father Superior's diniing-room, though, stricttly speakin, it was not a dining-room, for the Father Superior had only two rooms alltogether;",R.drawable.news));


    }
}


