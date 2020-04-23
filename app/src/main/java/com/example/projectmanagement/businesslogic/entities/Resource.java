package com.example.projectmanagement.businesslogic.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Resources")
public class Resource {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int resourceID;

    @NonNull
    public String name;

    @NonNull
    public int taskID;

}
