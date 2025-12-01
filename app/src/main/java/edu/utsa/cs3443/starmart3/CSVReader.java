package edu.utsa.cs3443.starmart3;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import edu.utsa.cs3443.starmart3.model.Item;
import edu.utsa.cs3443.starmart3.model.Season;

/**
 * This is a utility class for reading and parsing CSV files.
 */
public class CSVReader {

    /**
     * Reads and parses seasons.csv file from the assets.
     * @param context the context of the application.
     * @return a list of seasons.
     */
    public static List<Season> readSeasonsCSV(Context context) {
        List<Season> seasons = new ArrayList<>();
        try {
            InputStream inputStream = context.getAssets().open("seasons.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                String name = tokens[0].trim();
                int code = Integer.parseInt(tokens[1].trim());
                seasons.add(new Season(name, code));
            }
            reader.close();
        } catch (IOException e) {
            Log.e("CSVReader", "Error reading seasons CSV", e);
        }
        return seasons;
    }

    /**
     * Reads and parses the items.csv file from the assets folder.
     * @param context the context of the application.
     * @return a list of items.
     */
    public static List<Item> readItemsCSV(Context context) {
        List<Item> items = new ArrayList<>();
        try {
            InputStream inputStream = context.getAssets().open("items.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                int seasonCode = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim();
                String price = tokens[2].trim();
                String description = tokens[3].trim();
                String imageName = name.toLowerCase().replaceAll(" ", "");

                items.add(new Item(name, price, description, seasonCode, imageName));
            }
            reader.close();
        } catch (IOException e) {
            Log.e("CSVReader", "Error reading items CSV", e);
        }
        return items;
    }
}