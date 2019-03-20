package com.sabrine.panne.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sabrine.panne.R;
import com.sabrine.panne.model.DataModel;

import java.util.List;

public class DepanneurAdapter extends RecyclerView.Adapter<DepanneurAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;
    public DepanneurAdapter(List<DataModel> items, Context ctx) {
        this.items = items;
        this.ctx=ctx;

    }

    @Override
    public DepanneurAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_depanneur,viewGroup,false);

        DepanneurAdapter.ActorViewHolder Actionview = new DepanneurAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(DepanneurAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtDepanneur.setText(dm.getNom()+" "+dm.getPrenom());
        holder.txtSpeciliter.setText(dm.getSpecialite());
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtDepanneur,txtSpeciliter;
        ImageView tvImage;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtDepanneur =  itemView.findViewById(R.id.txtDepanneur);
            txtSpeciliter =  itemView.findViewById(R.id.txtSpecialiter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
/*
                    Uri gmmIntentUri = Uri.parse("google.streetview:cbll="+dm.getLatitude()+","+dm.getLongitude());
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    ctx.startActivity(mapIntent);*/


                }
            });

        }
    }

}
