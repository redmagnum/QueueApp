package com.example.user.queueapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 12/15/2017.
 */

public class AntriAdapter extends RecyclerView.Adapter<AntriAdapter.MAdapter>{



    List<JSONObject> dataJson = new ArrayList<>();
    JSONArray arrayJson;

    public AntriAdapter(JSONArray jason){
        arrayJson = jason;
        for (int i=0;i<this.arrayJson.length();i++)
            try {
                dataJson.add(this.arrayJson.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
    }

    @Override
    public AntriAdapter.MAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.arow,parent,false);
        return new MAdapter(view);
    }

    @Override
    public void onBindViewHolder(AntriAdapter.MAdapter holder, int position) {
        JSONObject jsonObject = dataJson.get(position);
        try {
            holder.nomor.setText((position+1)+"");
            holder.nama.setText(jsonObject.getString("nama"));
            holder.pesan.setText(jsonObject.getString("pesan"));
            holder.waktu.setText(jsonObject.getString("waktu"));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return dataJson.size();
    }

    public class MAdapter extends RecyclerView.ViewHolder{
        ImageView gambar;
        TextView nama, pesan, waktu, nomor;

        public MAdapter(View itemView) {
            super(itemView);
            nomor = (TextView)itemView.findViewById(R.id.nomor);
            nama = (TextView)itemView.findViewById(R.id.pengirim);
            pesan = (TextView)itemView.findViewById(R.id.konten);
            waktu = (TextView)itemView.findViewById(R.id.tgl);
        }
    }
}
