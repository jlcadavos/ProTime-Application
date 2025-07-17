package com.example.trialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class ClassroomActivity extends AppCompatActivity {
    CardView googleclassroom, msoffice,msexcel,ppt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        googleclassroom = findViewById(R.id.cardclassroom);
        msoffice = findViewById(R.id.cardmsoffice);
        msexcel = findViewById(R.id.cardmsexcel);
        ppt = findViewById(R.id.cardmsppt);

        googleclassroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://classroom.google.com/");
            }
        });

        msoffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://docs.google.com/document/u/0/");
            }
        });

        msexcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://docs.google.com/spreadsheets/u/0/");
            }
        });

        ppt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://docs.google.com/presentation/u/0/?usp=slides_alc");
            }
        });

    }

    private  void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}