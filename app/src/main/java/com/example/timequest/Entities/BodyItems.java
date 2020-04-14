package com.example.timequest.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BodyItems {

    @PrimaryKey(autoGenerate = true)
    private int bodyItemID;

    @ColumnInfo(name = "body_item")
    private String bodyItem;

    public BodyItems(int bodyItemID, String bodyItem) {
        this.bodyItemID = bodyItemID;
        this.bodyItem = bodyItem;
    }

    public int getBodyItemID() {
        return bodyItemID;
    }

    public void setBodyItemID(int bodyItemID) {
        this.bodyItemID = bodyItemID;
    }

    public String getBodyItem() {
        return bodyItem;
    }

    public void setBodyItem(String bodyItem) {
        this.bodyItem = bodyItem;
    }
}
