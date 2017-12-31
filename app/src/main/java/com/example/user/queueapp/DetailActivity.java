package com.example.user.queueapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;

public class DetailActivity extends AppCompatActivity {

    private ImageView gambar;
    private TextView nama;
    private Button btSubmit,btDB;

    AntriAdapter ad;
    RecyclerView r1;

    MyCoreDatabase myData;

    public static String mainPref = "file.main.message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intens = getIntent();

//        getSupportActionBar().setTitle(intens.getStringExtra("food.desc1"));

        gambar = (ImageView)findViewById(R.id.myImg);

        gambar.setImageResource(intens.getIntExtra("dokter.gambar",0));

        nama = (TextView)findViewById(R.id.txt1);

        nama.setText(intens.getStringExtra("dokter.desc1"));

        btSubmit = (Button) findViewById(R.id.button);
        btDB = (Button) findViewById(R.id.buttonx);

        myData = new MyCoreDatabase(this);

        r1 = (RecyclerView)findViewById(R.id.antriRecycler);
        r1.setLayoutManager(new LinearLayoutManager(this));

//        database = FirebaseDatabase.getInstance().getReference();
//
//        final AntriAdapter barang = (AntriAdapter) getIntent().getSerializableExtra("data");

        SharedPreferences preferences = getSharedPreferences(mainPref,0);
        String dataPesan = preferences.getString("message","");

        try {
            JSONArray jsonArray = new JSONArray(dataPesan);
            ad = new AntriAdapter(jsonArray);

            r1.setAdapter(ad);
            ad.notifyDataSetChanged();
        }catch (JSONException e){
            e.printStackTrace();
        }
        Log.d("JSON", dataPesan);
    }


    public void goAntri(View view) {

        Intent intens = new Intent(this, AntriActivity.class);
        startActivity(intens);
    }

    protected void onRestart(){
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    public void goDB(View view) {
        myData.getAll();
    }
}
