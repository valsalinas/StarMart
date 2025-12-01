package edu.utsa.cs3443.starmart3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import android.content.Intent;
import android.media.MediaPlayer;


import edu.utsa.cs3443.starmart3.model.Item;

/**
 * This class displays the selected items along with their quantities and total cost.
 */
public class ShoppingListActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private List<Item> selectedItems;
    private LinearLayout layout;
    private TextView totalCostTextView;
    private double totalCost = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mediaPlayer= MediaPlayer.create(this,R.raw.mouseclick);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        selectedItems = getIntent().getParcelableArrayListExtra("selectedItems");
        layout = findViewById(R.id.shopping_list_layout);
        totalCostTextView = findViewById(R.id.total_cost);

        for (Item item : selectedItems) {
            View itemView = getLayoutInflater().inflate(R.layout.shopping_list_item, layout, false);

            TextView itemName = itemView.findViewById(R.id.item_name);
            itemName.setText(item.getName());

            TextView itemPrice = itemView.findViewById(R.id.item_price);
            itemPrice.setText(item.getPrice());

            TextView itemQuantity = itemView.findViewById(R.id.item_quantity);
            ImageButton decreaseButton = itemView.findViewById(R.id.quantity_decrease);
            ImageButton increaseButton = itemView.findViewById(R.id.quantity_increase);

            itemQuantity.setText("1");

            increaseButton.setOnClickListener(v -> {
                mediaPlayer.start();
                int currentQuantity = Integer.parseInt(itemQuantity.getText().toString());
                itemQuantity.setText(String.valueOf(currentQuantity + 1));
                updateTotalCost();
            });

            decreaseButton.setOnClickListener(v -> {
                mediaPlayer.start();
                int currentQuantity = Integer.parseInt(itemQuantity.getText().toString());
                if (currentQuantity > 0) {
                    itemQuantity.setText(String.valueOf(currentQuantity - 1));
                    updateTotalCost();
                }
            });

            layout.addView(itemView);
        }

        updateTotalCost();

        ImageButton backToHomeButton = findViewById(R.id.backtohomebutton);
        backToHomeButton.setOnClickListener(v -> {
            mediaPlayer.start();
            Toast.makeText(ShoppingListActivity.this, "Thank you for your purchase!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ShoppingListActivity.this, SeasonSelectionActivity.class);
            startActivity(intent);
        });
    }

    /**
     * Updates the total cost based on the selected items and the quantity.
     */
    private void updateTotalCost() {
        totalCost = 0.0;

        for (int i = 0; i < layout.getChildCount(); i++) {
            View itemView = layout.getChildAt(i);

            TextView itemPriceTextView = itemView.findViewById(R.id.item_price);
            TextView itemQuantityTextView = itemView.findViewById(R.id.item_quantity);

            String priceText = itemPriceTextView.getText().toString();
            String quantityText = itemQuantityTextView.getText().toString();

            try {
                double price = Double.parseDouble(priceText.replace("$", "").replace("g", ""));
                int quantity = Integer.parseInt(quantityText);

                totalCost += price * quantity;
            } catch (NumberFormatException e) {
            }
        }

        totalCostTextView.setText(String.format("Total Cost: %.2f g", totalCost));
    }
}