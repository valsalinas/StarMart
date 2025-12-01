package edu.utsa.cs3443.starmart3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import edu.utsa.cs3443.starmart3.model.Season;
import android.media.MediaPlayer;

/**
 * This class is the activity that displays the category selection screen.
 * The user selects the season they want to shop for.
 */
public class SeasonSelectionActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    private List<Season> seasons;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_selection);

        seasons = CSVReader.readSeasonsCSV(this);

        LinearLayout layout = findViewById(R.id.season_buttons_layout);

        mediaPlayer=MediaPlayer.create(this,R.raw.mouseclick);

        for (final Season season : seasons) {
            ImageButton button = new ImageButton(this);
            int imageResource = getImageResource(season.getName());
            button.setImageResource(imageResource);
            button.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            button.setContentDescription(season.getName() + " Stock");

            button.setOnClickListener(v -> {
                mediaPlayer.start();
                Intent intent = new Intent(SeasonSelectionActivity.this, ItemListActivity.class);
                intent.putExtra("seasonCode", season.getCode());
                startActivity(intent);
            });

            layout.addView(button);
        }
    }

    private int getImageResource(String seasonName) {
        switch (seasonName.toLowerCase().replace(" ", "")) {
            case "fall":
                return R.drawable.fallstockbutton;
            case "spring":
                return R.drawable.springstockbutton;
            case "summer":
                return R.drawable.summerstockbutton;
            case "yearround":
                return R.drawable.yearroundstockbutton;
            default:
                return R.drawable.start_button;
        }
    }
}