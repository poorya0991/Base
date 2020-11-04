package com.example.base.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokeResult {

    @SerializedName("Result")
    @Expose
    private List<Joke> Result = null;

    public List<Joke> getResult() {
        return Result;
    }
}
