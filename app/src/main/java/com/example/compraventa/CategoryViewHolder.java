package com.example.compraventa;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CategoryViewHolder extends RecyclerView.ViewHolder{
    CardView card;
    TextView nombreCategoria;
    public CategoryViewHolder(View v) {
        super(v);
        card = v.findViewById(R.id.cardCategoria);
        nombreCategoria = v.findViewById(R.id.nombre_categoria);

    }

}
