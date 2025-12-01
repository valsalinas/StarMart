package edu.utsa.cs3443.starmart3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This is the main activity of the application.
 * Displays the welcome screen and navigates to the season selection screen.
 */
public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton startButton = findViewById(R.id.start_button);

        mediaPlayer=MediaPlayer.create(this,R.raw.mouseclick);

        startButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                try {
                    // Pause for 100 milliseconds
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, SeasonSelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}