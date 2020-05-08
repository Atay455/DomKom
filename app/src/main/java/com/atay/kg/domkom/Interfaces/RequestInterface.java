package com.atay.kg.domkom.Interfaces;

import com.atay.kg.domkom.Models.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("/news-api/")

    Call<List<NewsModel>> getNewsJson();
}
