package com.atay.kg.domkom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.atay.kg.domkom.Adapters.NewsAdapter;
import com.atay.kg.domkom.Interfaces.RequestInterface;
import com.atay.kg.domkom.Models.NewsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsFragment extends Fragment {

    ArrayList<NewsModel> newsModels = new ArrayList<>();
    private NewsAdapter newsAdapter;
    private RecyclerView news_recyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        news_recyclerview = (RecyclerView)view.findViewById(R.id.NewsRecyclerView);
        news_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        news_recyclerview.setHasFixedSize(true);
        news_recyclerview.setAdapter(newsAdapter);

        getNewsResponse();

    return view;
    }

    private void getNewsResponse() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://dashboard.heroku.com/apps/domkom-app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInteface=retrofit.create(RequestInterface.class);
        Call<List<NewsModel>> call=requestInteface.getNewsJson();


        call.enqueue(new Callback<List<NewsModel>>() {
            @Override
            public void onResponse(Call<List<NewsModel>> call, Response<List<NewsModel>> response) {
                newsModels = new ArrayList<>(response.body());
                newsAdapter = new NewsAdapter(NewsFragment.this,newsModels);
                news_recyclerview.setAdapter(newsAdapter);
                Toast.makeText(getActivity(), "Успешно", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<NewsModel>> call, Throwable t) {
                Toast.makeText(getActivity(),"Ошибка",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
