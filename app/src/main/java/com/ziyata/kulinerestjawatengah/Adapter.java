package com.ziyata.kulinerestjawatengah;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    String[] kulinerJawa, isiKuliner;
    int[] imgKuliner;

    public Adapter(Context context, String[] kulinerJawa, String[] isiKuliner, int[] imgKuliner) {
        this.context = context;
        this.kulinerJawa = kulinerJawa;
        this.isiKuliner = isiKuliner;
        this.imgKuliner = imgKuliner;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_kuliner,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtListTitle.setText(kulinerJawa[i]);
        Glide.with(context).load(imgKuliner[i]).into(viewHolder.imgList);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailKulinerActivity.class);
                pindah.putExtra("kj", kulinerJawa[i]);
                pindah.putExtra("ik", isiKuliner[i]);
                pindah.putExtra("imgk", imgKuliner[i]);
                context.startActivity(pindah);
            }
        });

    }
    @Override
    public int getItemCount() {
        return imgKuliner.length; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtListTitle;
        ImageView imgList;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtListTitle = itemView.findViewById(R.id.txtListTitle);
            imgList = itemView.findViewById(R.id.imgList);
        }
    }
}

