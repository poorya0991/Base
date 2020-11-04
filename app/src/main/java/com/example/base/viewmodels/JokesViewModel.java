package com.example.base.viewmodels;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.base.data.Joke;
import com.example.base.data.Repository;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class JokesViewModel extends ViewModel {
    private static final String TAG = "PokemonViewModel";

    private Repository repository;
    private MutableLiveData<ArrayList<Joke>> jokesList = new MutableLiveData<>();

    @ViewModelInject
    public JokesViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ArrayList<Joke>> getJokesList() {
        return jokesList;
    }

    @SuppressLint("CheckResult")
    public void getJokes(){
        repository.getJokes()
                .subscribeOn(Schedulers.io())
                .map(jsonElements -> {
                    ArrayList<Joke> list = (ArrayList<Joke>) jsonElements;
                    return list;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> jokesList.setValue(result),
                 error-> Log.e(TAG, "getPokemons: " + error.getMessage() ));
    }
}
