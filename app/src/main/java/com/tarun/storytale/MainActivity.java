package com.tarun.storytale;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ExampleAdapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.mRecyclerView);
        String[] titles = getResources().getStringArray(R.array.stories_titles);
        String[] contents = getResources().getStringArray(R.array.stories_contents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter =  new ExampleAdapter(this,titles,contents);
        recyclerView.setAdapter(adapter);
    }
}
