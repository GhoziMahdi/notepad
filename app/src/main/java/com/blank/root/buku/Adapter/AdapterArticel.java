package com.blank.root.buku.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.blank.root.buku.Model.ArticelModel;
import com.blank.root.buku.R;

import java.util.ArrayList;

/**
 * Created by root on 22/06/16.
 */
public class AdapterArticel extends RecyclerView.Adapter<AdapterArticel.ViewHolder>{
    private final OnItemClickListener listener;
    private ArrayList<ArticelModel> articel;


    public AdapterArticel(ArrayList<ArticelModel> articel,OnItemClickListener listener){
        this.articel = articel;
        this.listener = listener;
    }



    public AdapterArticel.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articel, null);
        ViewHolder vh = new ViewHolder(view);
        return (vh);
    }

    @Override
    public void onBindViewHolder(AdapterArticel.ViewHolder holder, int position) {
        holder.click(articel.get(position), listener);
        holder.tvId.setText(String.valueOf(articel.get(position).getId()));
        holder.title.setText(articel.get(position).getTitle());
        holder.descripsi.setText(articel.get(position).getDescripsi());
    }

    @Override
    public int getItemCount() {
        return (articel.size());
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvId,title,descripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView)itemView.findViewById(R.id.tvId);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            descripsi = (TextView) itemView.findViewById(R.id.tvDescripsi);
        }
        public void click(final ArticelModel articelModel, final OnItemClickListener listener){

            itemView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    listener.onClick(articelModel);
                }
            });
        }
    }
    public interface  OnItemClickListener{
        void onClick(ArticelModel item);
    }
}
