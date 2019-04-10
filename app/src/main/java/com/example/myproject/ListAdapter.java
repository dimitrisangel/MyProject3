package com.example.myproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<List> lists;

    public ListAdapter (Context context, ArrayList<List> lists) {
        this.context = context;
        this.lists = lists;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.list_layout, viewGroup, false);
        Item item = new Item(row);
        return item;


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((Item)viewHolder).textView_title.setText(lists.get(i).getName());
        ((Item)viewHolder).textView_id.setText(lists.get(i).getId());
    }

    @Override
    public int getItemCount() {return lists.size();}

        public class Item extends RecyclerView.ViewHolder {

        TextView textView_title;
        TextView textView_id;

        public Item(View itemView) {
            super(itemView);
            textView_title = itemView.findViewById(R.id.textView_title);
            textView_id = itemView.findViewById(R.id.textView_id);


        }
    }
}
