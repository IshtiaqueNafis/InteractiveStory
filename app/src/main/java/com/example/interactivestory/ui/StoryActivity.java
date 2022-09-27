package com.example.interactivestory.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.interactivestory.R;
import com.example.interactivestory.models.Page;
import com.example.interactivestory.models.Story;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {
    public static final String Tag = StoryActivity.class.getSimpleName();

    //region *** private properties ***
    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;
    private String name;
    private Stack<Integer> pageStack = new Stack<Integer>();
    //endregion


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
        if (name == null || name.isEmpty()) {
            name = "FRIEND";
        }
        story = new Story();
        loadPage(0);

    }

    private void loadPage(int pageNumber) {
        pageStack.push(pageNumber);
        Page page = story.getPage(pageNumber);

        if (!page.isFinalPage()) {
            Drawable image = ContextCompat.getDrawable(this, page.getImageId());
            storyImageView.setImageDrawable(image);

            String pageText = getString(page.getTextId());
            // add name if the place holder is included
            pageText = String.format(pageText, name);
            storyTextView.setText(pageText);

            setButton(page);
        } else {
            Drawable image = ContextCompat.getDrawable(this, page.getImageId());
            storyImageView.setImageDrawable(image);
            String pageText = getString(page.getTextId());
            pageText = String.format(pageText, name);
            storyTextView.setText(pageText);
            choice1Button.setText(R.string.home_page);
            choice1Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            choice2Button.setVisibility(View.GONE);
        }


    }

    private void setButton(Page page) {

        choice1Button.setVisibility(View.VISIBLE);
        choice1Button.setText(page.getChoice1().getTextId());
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice1().getNextPage();
                System.out.println(nextPage);
                loadPage(nextPage);
            }
        });
        choice2Button.setVisibility(View.VISIBLE);
        choice2Button.setText(page.getChoice2().getTextId());
        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice2().getNextPage();
                System.out.println(nextPage);
                loadPage(nextPage);
            }
        });
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if(pageStack.isEmpty()){
        super.onBackPressed();
        }else{
            loadPage(pageStack.pop());
        }

    }
}