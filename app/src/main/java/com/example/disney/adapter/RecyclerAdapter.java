package com.example.disney.adapter;
import com.bumptech.glide.Glide;
import com.example.disney.R;
import com.example.disney.models.Charact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
    private final Context context;
    ArrayList<Charact> listCharacters;

    public RecyclerAdapter(ArrayList<Charact> listCharacters, Context context) {
        this.listCharacters = listCharacters;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_list,parent, false);
        RecyclerHolder recyclerHolder = new RecyclerHolder(view);
        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        Charact character = listCharacters.get(position);
        holder.txtViewName.setText(character.getName());
        holder.txtViewId.setText(character.getId());
        Glide.with(this.context)
                .load(character.getImageUrl())
                .error(R.mipmap.ic_launcher)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return listCharacters.size();
    }

    public class RecyclerHolder extends ViewHolder{
        TextView txtViewName;
        TextView txtViewId;
        ImageView img;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.itemImg);
            txtViewName = (TextView)  itemView.findViewById(R.id.itemName);
            txtViewId = (TextView)  itemView.findViewById(R.id.itemId);
        }
    }
}