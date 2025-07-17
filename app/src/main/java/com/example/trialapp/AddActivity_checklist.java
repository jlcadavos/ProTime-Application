package com.example.trialapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity_checklist extends AppCompatActivity {
    EditText date,title,task;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_checklist);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        date = (EditText) findViewById(R.id.txtDate1);
        title = (EditText) findViewById(R.id.txtTitle1);
        task = (EditText) findViewById(R.id.txtTask1);

        btnAdd = (Button) findViewById(R.id.btnAdd1);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserDAta1();
                clearAll();

            }
        });
    }

    private void  inserDAta1()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("date",date.getText().toString());
        map.put("title",title.getText().toString());
        map.put("task",task.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("todolist").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity_checklist.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddActivity_checklist.this, "Error While Insertion", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void clearAll()
    {
        date.setText("");
        title.setText("");
        task.setText("");
    }
}