package com.example.anup.recyclerviewdrag;

/**
 * Created by IT on 16-Oct-17.
 */

public class ItemModel {

    private String itemName;
    private String itemDescription;
    private String itemPicture;

    public ItemModel(String itemName, String itemDescription, String itemPicture) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPicture = itemPicture;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(String itemPicture) {
        this.itemPicture = itemPicture;
    }
}
