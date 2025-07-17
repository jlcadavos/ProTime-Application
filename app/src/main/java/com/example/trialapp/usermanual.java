package com.example.trialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class usermanual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermanual);

        CardView schedule =findViewById(R.id.cardschedules);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(usermanual.this, schedulemanual.class));
            }
        });
        CardView classroomtools = findViewById(R.id.classroomtools);
        classroomtools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(usermanual.this, classroomtoolmanualActivity.class));
            }
        });
        CardView studymaterial = findViewById(R.id.cardstudymaterial);
        studymaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(usermanual.this, attendancemanual.class));
            }
        });
        CardView checklist = findViewById(R.id.cardchecklist);
        checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(usermanual.this, todolistmanual.class));
            }
        });
    }
}