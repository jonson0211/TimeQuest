package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HandItems {

    @NonNull
    @PrimaryKey
    public String handItem;

    public HandItems(String handItem) {

        this.handItem = handItem;
    }


    public String getHandItem() {
        return handItem;
    }

    public void setHandItem(String handItem) {
        this.handItem = handItem;
    }
}
