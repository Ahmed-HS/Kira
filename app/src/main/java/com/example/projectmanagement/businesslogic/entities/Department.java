package com.example.projectmanagement.businesslogic.entities;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Departments")
public class Department {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int departmentID;

    @NonNull
    public String name;
}

