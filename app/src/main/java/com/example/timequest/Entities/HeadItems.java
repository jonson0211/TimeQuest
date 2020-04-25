package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HeadItems {

    @NonNull
    @PrimaryKey
    public String headItem;

    public HeadItems(String headItem) {
        this.headItem = headItem;
    }


    public String getHeadItem() {
        return headItem;
    }

    public void setHeadItem(String headItem) {
        this.headItem = headItem;
    }
}
