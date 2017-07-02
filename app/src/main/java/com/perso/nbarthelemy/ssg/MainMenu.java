package com.perso.nbarthelemy.ssg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button gNewGameButton;
    private Button gLoadGameButton;
    private Button gSettingsButton;
    private Button gExitButton;

    // Called when the user clicks the finger image button
    private View.OnClickListener newGameClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Intent intent = new Intent(MainMenu.this, Level01.class);
        startActivity(intent);
        }
    };

    // Called when the user clicks the finger image button
    private View.OnClickListener exitClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        gNewGameButton = (Button) findViewById(R.id.button_new_game);
        gLoadGameButton = (Button) findViewById(R.id.button_load_game);
        gSettingsButton = (Button) findViewById(R.id.button_settings);
        gExitButton = (Button) findViewById(R.id.button_exit);

        gNewGameButton.setOnClickListener(newGameClickListener);
        gExitButton.setOnClickListener(exitClickListener);
    }

}
