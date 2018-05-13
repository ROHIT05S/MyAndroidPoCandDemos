package com.woodward.androidaccesscontentprovider;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 24343 on 11/14/2017.
 */

public class DictionaryAdapter extends RecyclerView.Adapter<DictionaryAdapter.DictionaryViewHolder>
{
    private Context context;
    private List<String> wordList;
    public DictionaryAdapter(Context context, List<String> wordList) {
        this.context = context;
        this.wordList = wordList;
    }
    @Override
    public DictionaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_list_layout, parent, false);
        return new DictionaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DictionaryViewHolder holder, int position)
    {
        String rowContent = wordList.get(position);
        holder.word.setText(rowContent);
    }

    @Override
    public int getItemCount()
    {
        return wordList.size();
    }
    public class DictionaryViewHolder extends RecyclerView.ViewHolder{
        public TextView word;
        public DictionaryViewHolder(View itemView) {
            super(itemView);
            word = (TextView)itemView.findViewById(R.id.word);
        }
    }
}
