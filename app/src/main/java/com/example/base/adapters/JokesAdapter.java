package com.example.base.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.base.R;
import com.example.base.data.Joke;
import com.example.base.view.MyTextView;

import java.util.ArrayList;

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.JokeViewHolder> {
    private Context mContext;
    private ArrayList<Joke> mList;
    private final LayoutInflater inflater;
    private JokesAdapter.OnItemClickListener listener;
    public interface OnItemClickListener {
        void onClick(Joke joke);
    }

    public JokesAdapter(Context mContext, ArrayList<Joke> mList,JokesAdapter.OnItemClickListener listener) {
        this.mContext = mContext;
        this.mList = mList;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listener = listener;

    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.row_joke, parent, false);



        return new JokesAdapter.JokeViewHolder(rootView);
    }


    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        holder.txtText.setText(mList.get(position).getPunchline());

    }


    class JokeViewHolder extends RecyclerView.ViewHolder {

        MyTextView txtText;

        JokeViewHolder(View itemView) {
            super(itemView);

            txtText = itemView.findViewById(R.id.txtText);
            txtText.setOnClickListener(v -> mList.get(getAdapterPosition()));

        }
    }


    public  void updateList(ArrayList<Joke> updatedList){
        mList = updatedList;
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
}
