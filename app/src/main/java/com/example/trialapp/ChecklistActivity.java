package com.example.trialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class ChecklistActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapterCheck mainAdapterCheck;

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MainModelchecklist> options =
                new  FirebaseRecyclerOptions.Builder<MainModelchecklist>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("todolist"),MainModelchecklist.class )
                        .build();

        mainAdapterCheck = new MainAdapterCheck(options);
        recyclerView.setAdapter(mainAdapterCheck);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChecklistActivity.this, AddActivity_checklist.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapterCheck.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapterCheck.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
    private void  txtSearch(String str)
    {
        FirebaseRecyclerOptions<MainModelchecklist> options =
                new  FirebaseRecyclerOptions.Builder<MainModelchecklist>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("todolist").orderByChild("title").startAt(str).endAt(str+"~"),MainModelchecklist.class )
                        .build();

        mainAdapterCheck = new MainAdapterCheck(options);
        mainAdapterCheck.startListening();
        recyclerView.setAdapter(mainAdapterCheck);
    }
}