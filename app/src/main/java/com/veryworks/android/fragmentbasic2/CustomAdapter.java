package com.veryworks.android.fragmentbasic2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pc on 9/27/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<Holder>{
    Context context;
    ListFragment.Callback callback;
    List<String> data;
    public CustomAdapter(Context context, ListFragment.Callback callback, List<String> data){
        this.context = context;
        this.callback = callback;
        this.data = data;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new Holder(view, callback);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}

class Holder extends RecyclerView.ViewHolder{
    private TextView textView;
    public Holder(View itemView, final ListFragment.Callback callback) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.goDetail(textView.getText().toString());
            }
        });
    }
    public void setText(String text){
        textView.setText(text);
    }
}