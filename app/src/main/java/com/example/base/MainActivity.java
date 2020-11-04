package com.example.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.base.adapters.JokesAdapter;
import com.example.base.data.Joke;
import com.example.base.viewmodels.JokesViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    JokesViewModel viewModel;
    private JokesAdapter adapter;
    private ArrayList<Joke> jokeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(JokesViewModel.class);

        RecyclerView recyclerJokes = findViewById(R.id.recyclerJokes);
        recyclerJokes.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new JokesAdapter(MainActivity.this, jokeList, joke -> {

        });
        recyclerJokes.setAdapter(adapter);

        observeData();
        viewModel.getJokes();


    }


    private void observeData() {
        viewModel.getJokesList().observe(this, pokemons -> adapter.updateList(pokemons));
    }
}