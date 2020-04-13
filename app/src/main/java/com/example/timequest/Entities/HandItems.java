package com.example.timequest.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HandItems {

    @PrimaryKey(autoGenerate = true)
    private int handItemID;

    @ColumnInfo(name = "hand_item")
    private String handItem;

    public HandItems(int handItemID, String handItem) {
        this.handItemID = handItemID;
        this.handItem = handItem;
    }

    public int getHandItemID() {
        return handItemID;
    }

    public void setHandItemID(int handItemID) {
        this.handItemID = handItemID;
    }

    public String getHandItem() {
        return handItem;
    }

    public void setHandItem(String handItem) {
        this.handItem = handItem;
    }
}
