package com.example.user.queueapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by USER on 12/12/2017.
 */

public class MyOwnAdapter extends RecyclerView.Adapter<MyOwnAdapter.MyOwnHolder> {

    List<Model> rantai;
    Context ctx;

    public MyOwnAdapter(Context ct, List<Model> rant){
        ctx = ct;
        rantai = rant;

    }

    @Override
    public MyOwnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInflator = LayoutInflater.from(ctx);
        View myOwnView = myInflator.inflate(R.layout.myrow,parent,false);
        return new MyOwnHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(MyOwnHolder holder, int position) {
        final Model data = rantai.get(position);

        holder.t1.setText(data.getName());
        holder.t2.setText(data.getDesc());
        holder.gambar.setImageResource(data.getImage());
        holder.gambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(ctx, DetailActivity.class);

                inten.putExtra("dokter.gambar", data.getImage());
                inten.putExtra("dokter.desc1", data.getName());
//                inten.putExtra("food.desc2", data.getRecipe());

                ctx.startActivity(inten);

            }
        });
    }

    @Override
    public int getItemCount() {
        return rantai.size();
    }

    public class MyOwnHolder extends RecyclerView.ViewHolder {
        TextView t1, t2;
        ImageView gambar;
        RelativeLayout rel;

        public MyOwnHolder(View itemView) {
            super(itemView);
            t1 = (TextView)itemView.findViewById(R.id.text1);
            t2 = (TextView)itemView.findViewById(R.id.text2);
            gambar = (ImageView)itemView.findViewById(R.id.myImage);
            rel = (RelativeLayout)itemView.findViewById(R.id.layoutrel);

        }
    }
}
