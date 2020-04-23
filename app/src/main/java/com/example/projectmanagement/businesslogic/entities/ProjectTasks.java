package com.example.projectmanagement.businesslogic.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;

@Entity
public class ProjectTasks
{
    @Embedded
    public Project project;
    @Relation(
            parentColumn = "projectID",
            entityColumn = "taskID"
    )
    public List<Task> tasks;
}
