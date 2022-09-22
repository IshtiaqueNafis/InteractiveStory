package com.example.interactivestory.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.interactivestory.R;
import com.example.interactivestory.models.Page;

public class StoryActivity extends AppCompatActivity {
    public static final String Tag = StoryActivity.class.getSimpleName();
    private Page[] pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));
        if(name==null || name.isEmpty()){
            name = "FRIEND";
        }
        pages = new Page[7];



    }
}