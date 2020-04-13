package com.example.timequest.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HeadItems {

    @PrimaryKey(autoGenerate = true)
    private int headItemID;

    @ColumnInfo(name = "head_item")
    private String headItem;

    public HeadItems(int headItemID, String headItem) {
        this.headItemID = headItemID;
        this.headItem = headItem;
    }

    public int getHeadItemID() {
        return headItemID;
    }

    public void setHeadItemID(int headItemID) {
        this.headItemID = headItemID;
    }

    public String getHeadItem() {
        return headItem;
    }

    public void setHeadItem(String headItem) {
        this.headItem = headItem;
    }
}
