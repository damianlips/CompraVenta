package com.example.compraventa;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryViewHolder>{
    private List<Categoria> mDataset;
    public CategoryRecyclerAdapter(List<Categoria> myDataset) {
        mDataset = myDataset;
    }
    public int getItemCount(){
        return (mDataset == null)? 0 : mDataset.size();
    }
    public void onBindViewHolder(CategoryViewHolder categoryHolder, final int position){
        Categoria categoria = mDataset.get(position);
        categoryHolder.nombreCategoria.setText(categoria.nombre);
        //categoryHolder.nombreCategoria.setText(categoria.color);
        categoryHolder.nombreCategoria.setTag(position);
        //categoryHolder.card.setCardBackgroundColor(categoria.color);
        categoryHolder.card.setCardBackgroundColor(Color.parseColor(categoria.color));
    }

    public CategoryViewHolder onCreateViewHolder(ViewGroup pr, int tipo){
        View v = LayoutInflater.from(pr.getContext()).inflate(R.layout.fila_cat,pr,false);
        return new CategoryViewHolder(v);
    }

}
