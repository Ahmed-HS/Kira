package com.example.projectmanagement.businesslogic.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Projects")
public class Project {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int projectID;

    @NonNull
    public String name;

    @NonNull
    public int departmentID;

    @NonNull
    public int managerID;
}


