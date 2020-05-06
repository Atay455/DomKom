package com.atay.kg.domkom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private final String JSON_URL = "https://dashboard.heroku.com/apps/domkom-app/news-api/";
    private RecyclerView myrecyclerview;
    private RequestQueue requestQueue;
    private JsonArrayRequest request;
    private List<NewsClass> listNews;

    public NewsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);


       /* listNews = new ArrayList<>() ;
        jsonrequest();

*/
        return view;

    }
}

   /* private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        NewsClass newsClass = new NewsClass() ;
                        newsClass.setTitle(jsonObject.getString("title"));
                        newsClass.setText(jsonObject.getString("text"));
                        newsClass.setDate(jsonObject.getString("date"));
                        newsClass.setId(jsonObject.getInt("id"));
                        newsClass.setImage_url(jsonObject.getString("image"));
                        listNews.add(newsClass);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(listNews);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = (RequestQueue) Volley.newRequestQueue(NewsFragment.this);
        requestQueue.add(request) ;
*//**//*

    }

    private void setuprecyclerview(List<NewsClass> listNews) {


        RycyclerViewAdapter myadapter = new RycyclerViewAdapter(this,listNews);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        myrecyclerview.setAdapter(myadapter);

    }
}



*/