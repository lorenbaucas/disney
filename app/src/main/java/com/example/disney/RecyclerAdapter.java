package com.example.disney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.disney.models.Charact;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<Charact> characterList;
    private Context mContext;

    public RecyclerAdapter(ArrayList<Charact> characterList, Context mContext) {
        this.characterList = characterList;
        this.mContext = mContext;
    }

    //Pongo el layout que voy a usar
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_list, parent, false);
        return new MyViewHolder(view);
    }

    //Los datos los cargo en mi layout
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(characterList.get(position).getName());
        holder.url.setText(characterList.get(position).getSourceUrl());
        Glide.with(mContext)
                .load(characterList.get(position).getImageUrl())
                .error(R.mipmap.ic_launcher)
                .into(holder.img);
    }

    //Le digo cuanto tamaño tendrá, en este caso lo que ocupe la lista
    @Override
    public int getItemCount() {
        return characterList.size();
    }

    //Declaro la imagen y los text view y los conecto con los del layout
    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name;
        TextView url;

        public MyViewHolder(View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.itemImg);
            name = itemView.findViewById(R.id.itemName);
            url = itemView.findViewById(R.id.itemUrl);
        }
    }
}
