package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    public Button playGame;
    public Button aboutGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.xo_48x48);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        playGame = (Button) findViewById(R.id.playButton);
        aboutGame = (Button) findViewById(R.id.aboutButton);
    }

    public void playGame(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void aboutGame(View view){

        Intent intent = new Intent(getApplicationContext(), AboutGame.class);
        startActivity(intent);

    }
}
