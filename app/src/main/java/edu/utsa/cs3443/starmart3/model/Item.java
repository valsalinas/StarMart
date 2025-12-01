package edu.utsa.cs3443.starmart3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private String name;
    private String price;
    private String description;
    private int seasonCode;  // Add seasonCode for filtering
    private String imageName;  // Assume image name is stored here

    public Item(String name, String price, String description, int seasonCode, String imageName) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.seasonCode = seasonCode;
        this.imageName = imageName;
    }

    protected Item(Parcel in) {
        name = in.readString();
        price = in.readString();
        description = in.readString();
        seasonCode = in.readInt();
        imageName = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getSeasonCode() {
        return seasonCode;
    }

    public String getImageName() {
        return imageName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(price);
        dest.writeString(description);
        dest.writeInt(seasonCode);
        dest.writeString(imageName);
    }
}