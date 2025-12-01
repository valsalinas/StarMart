package edu.utsa.cs3443.starmart3;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.media.MediaPlayer;

import edu.utsa.cs3443.starmart3.model.Item;

/**
 * This class activity is to display a list of items for the selected time of year.
 */
public class ItemListActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    private List<Item> items;
    private List<Item> selectedItems = new ArrayList<>();
    private int seasonCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mediaPlayer=MediaPlayer.create(this,R.raw.mouseclick);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        seasonCode = getIntent().getIntExtra("seasonCode", -1);
        items = CSVReader.readItemsCSV(this);

        LinearLayout layout = findViewById(R.id.item_list_layout);

        for (final Item item : items) {
            if (item.getSeasonCode() == seasonCode) {
                View itemView = getLayoutInflater().inflate(R.layout.item_list_item, layout, false);

                ImageView itemImage = itemView.findViewById(R.id.item_image);
                itemImage.setImageResource(getResources().getIdentifier(item.getImageName(), "drawable", getPackageName()));
                itemImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(ItemListActivity.this)
                                .setTitle(item.getName())
                                .setMessage(item.getDescription())
                                .setPositiveButton(android.R.string.ok, null)
                                .show();
                    }
                });

                TextView itemName = itemView.findViewById(R.id.item_name);
                itemName.setText(item.getName());

                TextView itemPrice = itemView.findViewById(R.id.item_price);
                itemPrice.setText(item.getPrice());

                CheckBox itemCheckbox = itemView.findViewById(R.id.item_checkbox);
                itemCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    mediaPlayer.start();
                    if (isChecked) {
                        selectedItems.add(item);
                    } else {
                        selectedItems.remove(item);
                    }
                });

                layout.addView(itemView);
            }
        }

        ImageButton finishButton = findViewById(R.id.finish_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent = new Intent(ItemListActivity.this, ShoppingListActivity.class);
                intent.putParcelableArrayListExtra("selectedItems", new ArrayList<>(selectedItems));
                startActivity(intent);
            }
        });
    }
}