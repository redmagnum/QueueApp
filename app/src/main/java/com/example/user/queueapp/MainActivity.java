package com.example.user.queueapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //SPESIALIS JANTUNG



    RecyclerView r1;
    List<Model> kereta = new ArrayList();
    MyOwnAdapter ad;

    public void masukan()
    {
        kereta.add(new Model("Dr. Monkey D. Luffy","Jl. Dr. Soetomo 52 Semarang\n" +
                "Jam 13.00-18.00", R.drawable.a));

        kereta.add(new Model("Dr. Rorona Zoro","Jl. Pahlawan 9 Pekalongan\n" +
                "Jam 09.00-18.00", R.drawable.a));

        kereta.add(new Model("Dr. Eustass Kidd","Jl. Ungaran 10 Madiun\n" +
                "Jam 05.00-10.00", R.drawable.a));

        kereta.add(new Model("Dr. Shinichi Kudou","Jl. Pamularsih 7 Jakarta\n" +
                "Jam 12.00-18.00", R.drawable.a));

        kereta.add(new Model("Dr. Sherlock Holmes","Jl. Pandaran 5 Magelang\n" +
                "Jam 18.00-22.00", R.drawable.a));

        ad.notifyDataSetChanged();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = (RecyclerView) findViewById(R.id.myRecycler);

        ad = new MyOwnAdapter(this, kereta);

        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));

        masukan();
    }
}
