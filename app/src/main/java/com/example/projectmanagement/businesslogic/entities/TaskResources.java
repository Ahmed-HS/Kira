package com.example.projectmanagement.businesslogic.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;

@Entity
public class TaskResources
{
    @Embedded
    public Task task;
    @Relation(
            parentColumn = "taskID",
            entityColumn = "resourceID"
    )
    public List<Resource> resources;
}
