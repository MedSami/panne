package com.sabrine.panne.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sabrine.panne.R;
import com.sabrine.panne.Reponse;
import com.sabrine.panne.model.DataModel;

import java.util.List;

public class ReponseAdapter extends RecyclerView.Adapter<ReponseAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;
String idClient;

public ReponseAdapter(List<DataModel> items, Context ctx,String idClient) {
        this.items = items;
        this.ctx=ctx;
        this.idClient=idClient;

    }

    @Override
    public ReponseAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_msg,viewGroup,false);

        ReponseAdapter.ActorViewHolder Actionview = new ReponseAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(ReponseAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtNom.setText(dm.getNom()+" "+dm.getPrenom());
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtMsg,txtNom;
        ImageView tvImage;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtMsg =  itemView.findViewById(R.id.txtMsg);
            txtNom =  itemView.findViewById(R.id.txtNom);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Intent i = new Intent(ctx, Reponse.class);
                        i.putExtra("rep", dm.getReponse());
                        i.putExtra("idClient", idClient);
                        i.putExtra("msg", dm.getMessage());
                        ctx.startActivity(i);

                }});

        }
    }

}
