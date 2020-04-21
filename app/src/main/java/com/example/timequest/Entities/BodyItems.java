package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BodyItems {

    @NonNull
    @PrimaryKey
    public String bodyItem;

    public BodyItems(String bodyItem) {

        this.bodyItem = bodyItem;
    }

    public String getBodyItem() {
        return bodyItem;
    }

    public void setBodyItem(String bodyItem) {
        this.bodyItem = bodyItem;
    }
}
