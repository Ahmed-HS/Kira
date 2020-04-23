package com.example.projectmanagement.businesslogic.entities;


import androidx.annotation.NonNull;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

import java.time.LocalDate;



@Entity(tableName = "Tasks")
public class Task {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int taskID;

    @NonNull
    public int projectID;

    @NonNull
    public String title;

    @NonNull
    public LocalDate fromDate;

    @NonNull
    public boolean status;
}



