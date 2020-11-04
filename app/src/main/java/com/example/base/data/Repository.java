package com.example.base.data;

import com.example.base.api.API;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class Repository {

    private API api;

    @Inject
    public Repository(API api) {
        this.api = api;
    }


    public Observable<List<Joke>> getJokes(){
        return api.getJokes();
    }
}
