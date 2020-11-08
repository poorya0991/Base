package com.example.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import com.example.base.adapters.JokesAdapter;
import com.example.base.data.Joke;
import com.example.base.databinding.ActivityMainBinding;
import com.example.base.viewmodels.JokesViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    JokesViewModel viewModel;
    private JokesAdapter adapter;
    private ArrayList<Joke> jokeList;
    ActivityMainBinding binding;

    @Inject
    Typeface sans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        viewModel = new ViewModelProvider(this).get(JokesViewModel.class);

        binding.btnSend.setTypeface(sans);
        binding.editTextCell.setTypeface(sans);
        binding.textFieldCell.setTypeface(sans);
        binding.editTextCell.requestFocus();


        binding.lProgressBar.getRoot().setVisibility(View.VISIBLE);
        observeData();
        viewModel.getJokes();


    }


    private void observeData() {
        viewModel.getJokesList().observe(this, pokemons ->
                {
                adapter.updateList(pokemons);
                    binding.lProgressBar.getRoot().setVisibility(View.GONE);
                });}
}