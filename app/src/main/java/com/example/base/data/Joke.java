package com.example.base.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Joke {

    @SerializedName("punchline")
    @Expose
    private String punchline;

    public String getPunchline() {
        return punchline;
    }
}

