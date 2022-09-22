package com.example.interactivestory;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //region member variable
    private EditText nameField;
    private Button startButton;


    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameEditText);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(view -> {
            String name = nameField.getText().toString();
            Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            startStory(name);

        });

    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);

        String key = getString(R.string.key_name);
        intent.putExtra(key, name);
        startActivity(intent);
    }
}