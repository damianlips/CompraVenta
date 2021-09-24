package com.example.compraventa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>{
    private List<Categoria> mDataset;
    CategoriasRecycler categoriasRecycler;
    public CategoryRecyclerAdapter(List<Categoria> myDataset) {
        mDataset = myDataset;
    }

    public CategoryRecyclerAdapter(List<Categoria> mDataset, CategoriasRecycler categoriasRecycler) {
        this.mDataset = mDataset;
        this.categoriasRecycler = categoriasRecycler;
    }

    public int getItemCount(){
        return (mDataset == null)? 0 : mDataset.size();
    }
    public void onBindViewHolder(CategoryViewHolder categoryHolder, final int position){
        Categoria categoria = mDataset.get(position);
        categoryHolder.nombreCategoria.setText(categoria.nombre);
        categoryHolder.nombreCategoria.setTag(position);
        //categoryHolder.card.setCardBackgroundColor(categoria.color);
        categoryHolder.card.setCardBackgroundColor(Color.parseColor(categoria.color));
    }

    public CategoryViewHolder onCreateViewHolder(ViewGroup pr, int tipo){
        View v = LayoutInflater.from(pr.getContext()).inflate(R.layout.fila_cat,pr,false);
        CategoryViewHolder cvh =  new CategoryViewHolder(v);
        cvh.adapter=this;
        return cvh;
    }
    public void devolverCategoria(final int position){
        Intent intent = new Intent();
        intent.putExtra("nombre",mDataset.get(position).nombre);
        intent.putExtra("id",mDataset.get(position).id);
        intent.putExtra("color",mDataset.get(position).color);
        categoriasRecycler.setResult(Activity.RESULT_OK,intent);
        categoriasRecycler.finish();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        CategoryRecyclerAdapter adapter;
        CardView card;
        TextView nombreCategoria;

        public CategoryViewHolder(View v) {
            super(v);
            card = v.findViewById(R.id.cardCategoria);
            nombreCategoria = v.findViewById(R.id.nombre_categoria);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapter.devolverCategoria((int)nombreCategoria.getTag());
                }
            });
        }

    }
}
