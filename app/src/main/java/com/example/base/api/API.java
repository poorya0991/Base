package com.example.base.api;

import android.webkit.JsResult;

import com.example.base.data.Joke;
import com.example.base.data.JokeResult;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface API {

    @GET("random_ten")
    Observable<List<Joke>> getJokes();
}