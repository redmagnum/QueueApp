package com.example.user.queueapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CategoryActivity extends AppCompatActivity {

    private TextView email;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        auth = FirebaseAuth.getInstance();
        email = (TextView) findViewById(R.id.tvNama);

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        setDataToView(user);
    }

    private void setDataToView(FirebaseUser user) {

        email.setText("User Email: " + user.getEmail());


    }

    public void goJantung(View view) {
        Intent its = new Intent(this,MainActivity.class);
        startActivity(its);
    }

    public void goAnak(View view) {
        Intent its = new Intent(this,MainActivity.class);

        startActivity(its);
    }

    public void goGigi(View view) {
        Intent its = new Intent(this,MainActivity.class);

        startActivity(its);
    }

    public void goMata(View view) {
        Intent its = new Intent(this,MainActivity.class);

        startActivity(its);
    }

    public void goTht(View view) {
        Intent its = new Intent(this,MainActivity.class);

        startActivity(its);
    }

    public void goUmum(View view) {
        Intent its = new Intent(this,MainActivity.class);

        startActivity(its);
    }

    public void goKandungan(View view) {
        Intent its = new Intent(this,MainActivity.class);

        startActivity(its);
    }

    public void goSaraf(View view) {
        Intent its = new Intent(this,MainActivity.class);

        startActivity(its);
    }

}
