package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Word> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<Word> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    public void setmData(List<Word> mData) {
        this.mData = mData;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Word word = mData.get(position);
        holder.mWord.setText(word.getWord());
        holder.mCount.setText(String.valueOf(word.getCount()));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView mWord;
        TextView mCount;

        ViewHolder(View itemView) {
            super(itemView);
            mWord = itemView.findViewById(R.id.tv_word);
            mCount = itemView.findViewById(R.id.tv_count);
        }


    }


}