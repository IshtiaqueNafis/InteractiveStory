package com.example.interactivestory.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.interactivestory.R;
import com.example.interactivestory.models.Page;
import com.example.interactivestory.models.Story;

public class StoryActivity extends AppCompatActivity {
    public static final String Tag = StoryActivity.class.getSimpleName();
    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        storyImageView = findViewById(R.id.simageView);
        storyTextView = findViewById(R.id.storyTextView);
        choice1Button = findViewById(R.id.choice1Button);
        choice2Button = findViewById(R.id.choice2Button);

        Intent intent = getIntent();
             name = intent.getStringExtra(getString(R.string.key_name));
        if(name==null || name.isEmpty()){
            name = "FRIEND";
        }
        story = new Story();
        loadPage(0);

    }

    private void loadPage(int pageNumber) {
        Page page = story.getPage(pageNumber);
        Drawable image = ContextCompat.getDrawable(this, page.getImageId());
        storyImageView.setImageDrawable(image);

        String pageText = getString(page.getTextId());
        // add name if the place holder is included
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);
        choice1Button.setText(page.getChoice1().getTextId());
        choice2Button.setText(page.getChoice2().getTextId());

    }
}